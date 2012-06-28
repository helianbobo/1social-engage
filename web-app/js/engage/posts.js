
// Namespaces
var engage = {
      appFrame: _.extend({}, Backbone.Events)
    , model: {}

    , repeat: function (ul, max) {
        var li = ul.find('li')
          , max = max || 10

        for (var i = 0; i < max; i++) ul.append(li.clone())
      }
    }

$(document.body).ready(function() {
  // constants
  var DEFAULT_TEMPLATE_FILTER = function(el) { return el.attr('tmpl-load-timing') != 'manual' }

  // Models
  // -----
  var ElementQueue = Backbone.Model.extend(
      {
        push: function(obj) {
          var arr = []

          this.get('queue') && arr.push.apply(arr, this.get('queue'))
          arr.push(obj)
          this.set('queue', arr)
        }
      }
    )

  var Asset = Backbone.Model.extend({})

    , Assets = Backbone.Collection.extend(
        {
          model: Asset

        , parse: function(response) {
            return response.data[0].pageData
          }

        , url: function() {
            return joinPath($.contextPath, 'socialAssets/getAllAssets')
          }
        }
      )

    , Pagination = Backbone.Model.extend({})

    , Post = Backbone.Model.extend({})

    , Posts = Backbone.Collection.extend(
        {
          model: Post

        , parse: function(response) {
            this.updatePagination(response)
            return response.data
          }

        , updatePagination: function(response) {
            var data = _.pick(response, 'offset', 'max')
            if ('pagination' in this) {
              this.pagination.set(data)
            } else {
              this.pagination = new Pagination(data)
            }
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/getAllPosts')
          }
        }
      )
    
    , PostItem = Backbone.View.extend(
        {
          initialize: function(options) {
            this.li = options.li

            this.model.on('change:selected', this.select, this)
            this.render()
          }

        , select: function(model, selected) {
            this.$('.input-item-selector').attr('checked', selected ? 'checked' : false)
          }
        , render : function() {
            var data = this.model.toJSON()

            if (data.comment.length > 0) {
              _.extend(data, 
                  _.pick(
                      data.comment[0]
                    , 'likeCount'
                    , 'commentCount'
                    , 'datetimePosted'
                    )
                )
            }

            // split date & time
            var date = data.datetimePosted.split(/[TZ]/)
            data.date = date[0]
            data.time = date[1]

            this.setElement($(Mustache.render(this.li, data)))
          }
        }
      )

    , PostList = Backbone.View.extend(
        {
          initialize: function(options) {
            // prepare template
            this.childs = []
            this.$li = this.$el.html()
            // clear the template
            this.$el.empty()
            this.collection.on('sync', this.render, this)
            this.collection.fetch()

            $('.post-list').delegate('.show-case', 'click', function() {
              var attrName = 'modal-id'
                , btn = $(this)
                , el = $('#' + btn.attr(attrName))

              if (el.length === 0) {
                el = prepareModal('app-case-modal')
                btn.attr(attrName, el.attr('id'))
                modalQueue.push(el.attr('id'))
                el.one('show', function() { loadTemplates(el) })
              }
              
              el.modal()
            })
          }

        , append: function(model) {
            var item = new PostItem(
                  {
                    li: this.$li
                  , model: model
                  }
                )

            this.childs.push(item)
            this.$el.append(item.$el)
          }

        , render: function(collection, data) {
            var _t = this

            this.$el.empty()
            collection.forEach(function(it) {
              _t.append(it)
            })

            this.$('img').lazyload(
                {
                  container: this.$el.parents(".post-list-wrap")
                , effect: "fadeIn"
                }
              )
          }
        }
      )
    
    , Toolbar = Backbone.View.extend(
        {
          initialize: function(options) {
            var _t = this

            this.childs = []

            this.$el.children().each(function(i, it) {
                _t.createChild($(it).attr('class').split(/\s+/)[0])
              }
            )
          }

        , createChild: function(name) {
            var className = capitalize(toCamelCase(name))

            if (!/\-actions$/.test(name) || !Toolbar[className]) return;
            this.childs[name] = new Toolbar[className](
              {
                collection: this.collection
              , el: this.$el.find('.' + name)
              }
            )
          }
        }
      )

  Toolbar.BatchActions = Backbone.View.extend(
    {
      events: {
        'click .input-all-selector': 'select'
      , 'click .mark': 'mark'
      }

    , mark: function() {
        console.log(this, arguments)
      }
    , select: function(evt) {
        var selected = !!$(evt.target).attr('checked')
        this.collection.forEach(function(model) {
          model.set('selected', selected)
        })
      }
    }
  )

  Toolbar.FilterActions = Backbone.View.extend(
    {
      initialize: function(options) {
        this.$asset = this.$('.assets li:last').remove()[0].outerHTML
        this.assets = assets
        this.assets.on('sync', this.renderAssets, this)
        this.assets.fetch()
      }

    , renderAssets: function(collection, data) {
        var li = this.$asset
          , ul = this.$('.assets')
        collection.each(function(model) {
          ul.append(Mustache.render(li, model.toJSON()))
        })
      }
    }
  )

  Toolbar.RefreshActions = Backbone.View.extend(
    {
      events: { 'click .btn-refresh': 'refresh' }

    , refresh: function() {
        this.collection.fetch()
      }
    }
  )

  Toolbar.SortActions = Backbone.View.extend(
    {
      events: { 'click a': 'sort' }

    , reset: function() {
        this.$('a').each(function(i, it) {
          var el = $(it)

          el.removeClass('asc desc')
          el.attr('title', el.attr('title').replace(/ (asc|desc)$/i, ''))
        })
      }

    , sort: function(evt) {
        var el = $(evt.currentTarget)
          , title = el.attr('title').replace(/ (asc|desc)/i, '')

        // default sort desc
        this.updateStatus(el, !el.hasClass('desc') ? 'desc' : 'asc', title)
        return false
      }

    , updateStatus: function(el, flag, title) {
        this.reset()
        el.addClass(flag)
        el.attr('title', title + ' ' + flag.toUpperCase())
      }
    }
  )

  _.extend(engage.model, {
      'Asset': Asset
    , 'Assets': Assets
    , 'Post': Post
    , 'Posts': Posts
    }
  )


  // Objects
  // -----

  var appFrame = engage.appFrame
    , ids = 0
    , modalQueue = new ElementQueue({ max: 3 })
    , assets = engage.assets = new engage.model.Assets()
    , posts = engage.posts = new engage.model.Posts()
    , tmpls = {
        'app-case-modal': $('.app-case-modal').remove()
      , get: function(name) {
          var el = this[name]

          if (!el) throw 'could not get template named ' + name
          return el.clone()
        }
      }

    , templateListeners = {
      /**
       * If the listener return false, it will be off
       */
        'case': function(tmplName, el) {
          var obj = new engage.CaseApp({el: el})
          el.parents('.modal').on('remove', function() {
            obj.destroy()
            obj = null
          })
        }
      , 'posts': function(tmplName, el) {
          new PostList(
            {
              collection: posts
            , el: el.find('.post-list')
            }
          )
          return false
        }
      , 'posts-toolbar': function(tmplName, el) {
          updateListHeight()

          new Toolbar({ collection: posts, el: el })

          return false
        }

      }

  // Handlers
  // -----
  function getListHeight(el) {
    // 30 is the #page margin bottom
    return $(window).height() - el.offset().top - 30
  }

  function getTemplatePath(path) {
    return path.indexOf('.') > 0 ? path : path + '.html'
  }

  function loadTemplate(el, callback) {
    var url = joinPath($.contextPath, '/tmpl/' + getTemplatePath(el.attr('tmpl')))

    $.ajax({
      url: url,
      success: function(data) {
        var newEl = $(data)

        el.replaceWith(newEl)
        if ($.isFunction(callback)) callback(el, newEl)
      }
    })
  }

  function loadTemplates(el, filter) {
    filter = filter || DEFAULT_TEMPLATE_FILTER
    var callback = function(placeholder, el) {
          loadTemplates(el, filter)
          appFrame.trigger('templateLoaded', placeholder.attr('tmpl'), el)
        }
      , load = function(i, it) {
          var el = $(it)

          if (!filter) loadTemplate(el, callback)
          filter(el) && loadTemplate(el, callback)
        }

    if (el.hasClass('tmpl')) load(0, el)
    else el.find('[tmpl]').each(load)
  }

  function newId(prefix, suffix) {
    return (prefix ? prefix : '') + (++ids) + (suffix ? suffix : '')
  }

  function prepareModal(name) {
    var el = tmpls.get(name)

    el.attr('id', newId('modal-'))
    $(document.body).append(el)
    return el
  }

  function updateListHeight() {
    $('.post-list-wrap').height(getListHeight($('.post-list-wrap')))
  }

  // Event listeners
  // -----

  _.each(templateListeners, function(callback, tmplName) {
        var fn = function(tmpl) {
              if (tmpl !== tmplName) return;

              if (callback.apply(this, arguments) === false) {
                appFrame.off('templateLoaded', fn)
              }
            }
        appFrame.on('templateLoaded', fn)
      }
    )

  modalQueue.on('change:queue', function(model, queue) {
    if (queue.length > model.get('max')) {
      var el = $('#' + queue.shift())
      
      el.trigger('remove')
      el.remove()
      this.set('queue', _.map(queue, function(it) { return it }))
    }
  })

  // Page setup
  // -----

  $(window).resize(updateListHeight)
  // updateListHeight()
  loadTemplates($('#page'))
  window.loadTemplates = loadTemplates

  // engage.posts.fetch()

  // engage.repeat($('.post-list'), 50)
})