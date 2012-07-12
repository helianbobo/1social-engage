$(document.body).ready(function() {
    
  // Views
  // -----
  var PostItem = Backbone.View.extend(
        {
          initialize: function(options) {
            this.li = options.li

            this.model.on('change:selected', this.select, this)
            this.model.on('change', this.render, this)
            this.render()
          }

        , events: {
            'click .mark': 'mark'
          , 'click .show-case': 'openCase'
          }

        , mark: function(evt) {
            var btn = $(evt.currentTarget)
              , readStatus = btn.attr('data-read-status')

            function reverse(status) {
              return status == 'read' ? 'unread' : 'read'
            }

            var model = this.model
              , post = this.model.toJSON()
              , params = this.model.getIds()

            params.type = this.model.collection.params.get('type')
            params.status = reverse(readStatus)

            $.ajax(
              {
                url: absolutePath($.contextPath, 'socialEngage/markStatus')
              , data: params
              , dataType: 'json'
              , success: function(response) {
                  if (response.response == 'ok') {
                    model.set('readStatus', params.status)
                  }
                }
              }
            )
          }

        , openCase: function(evt) {
            var attrName = 'modal-id'
              , btn = $(evt.currentTarget)
              , el = $('#' + btn.attr(attrName))

            if (el.length === 0) {
              el = prepareModal('app-case-modal')
              btn.attr(attrName, el.attr('id'))
              modalQueue.push(el.attr('id'))
              el.one('show', function() { tmplLoader.load(el) })
            }
            
            el.find('.app-case').attr('post-id', this.model.get('id'))
            el.modal()
          }

        , render : function() {
            var data = this.model.toJSON()

            // format datetime
            data.format = function() {
              return function(text, render) {
                return engage.formatDateTime(render(text), 'h:mm:ss tt<br/>MMM dd yyyy ddd')
              }
            }

            data.postVoiceName = data.voiceName
            data.postVoicePic = data.voicePic
            data.postVoiceURL = data.voiceURL

            if (data.comment.length > 0) {
              _.extend(data, 
                  _.pick(
                      data.comment[0]
                    , 'likeCount'
                    , 'datetimePosted'
                    )
                )
              data.postVoiceName = data.comment[0].voiceName
              data.postVoicePic = data.comment[0].voicePic
              data.postVoiceURL = data.comment[0].voiceURL
              data.commentCount = '-'
            }

            data.read = data.readStatus == 'read' ? true : false

            var el = $(Mustache.render(this.li, data))
            if (this.$el.parent().length > 0) {
              this.$el.replaceWith(el)
              el.find('img').each(function(i, it) {
                  it = $(it)
                  it.attr('src', it.attr('data-original'))
                }
              )
            }

            el.find('a').copyAttr('data-url', 'href')

            this.setElement(el)
          }

        , select: function(model, selected) {
            this.$('.input-item-selector').attr('checked', selected ? 'checked' : false)
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
        this.assets.fetch({
            data:{type:'facebook'}
        })
      }

    , events: {
        'click .dropdown-menu a': 'updateFilter'
      }

    , renderAssets: function(collection, data) {
        var li = this.$asset
          , ul = this.$('.assets')
        collection.each(function(model) {
          ul.append(Mustache.render(li, model.toJSON()))
        })
      }

    , updateFilter: function(evt) {
        var btn = $(evt.currentTarget)
          , menu = btn.closest('.dropdown')
          , key = menu.attr('data-name')
          , value = btn.attr('href').split('#')[1]

        if (btn.parent().hasClass('active')) return;
        if (value) { this.collection.params.set(key, value) }
        else { this.collection.params.unset(key) }
        this.collection.fetch()

        btn.closest('ul').find('li').removeClass('active')
        btn.parent().addClass('active')
        menu.find('.dropdown-toggle-text').html(btn.html())
        evt.preventDefault()
      }
    }
  )

  Toolbar.PaginationActions = Backbone.View.extend(
    {
      initialize: function(options) {
        var _t = this

        $.pagination(this.$el).on('go', function(evt, to) {
          var pagination = _t.collection.pagination
            , data = _.pick(pagination.toJSON(), 'offset', 'pageSize')

          pagination.set(
              { offset: data.offset + data.pageSize * (to === 'next' ? 1 : -1) }
            , { silent: true }
            )

          _t.collection.fetch()
        })

        this.collection.pagination.on('change', function(model, evt) {
          _t.$el.trigger('change', model.toJSON())
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

        // default sort desc
        this.updateStatus(el, !el.hasClass('desc') ? 'desc' : 'asc')
        return false
      }

    , updateStatus: function(el, flag) {
        this.reset()
        el.addClass(flag)
        el.attr('title', el.attr('title') + ' ' + flag.toUpperCase())
        this.collection.params.set(
            { 
              sort: el.attr('href').split('#')[1]
            , order: flag
            }
          )
        this.collection.fetch()
      }
    }
  )


  // Objects
  // -----

  var ids = 0
    , assets = engage.assets = new engage.model.Assets()
    , cases = engage.cases = new engage.model.Cases()
    , modalQueue = new ElementQueue({ max: 3 })
    , posts = engage.posts = new engage.model.Posts(null
      , { 
          order: 'desc'
        , pageSize: 20
        , sort: 'datetimeSort'
        , type: 'facebook' 
        }
      )
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
       * Name ends with :one, will be trigger only once
       */
        'case': function(el, placeholder) {
          el.attr('post-id', placeholder.attr('post-id'))

          var obj = new engage.CaseApp({el: el})

          el.parents('.modal').on('remove', function() {
            obj.destroy()
            obj = null
          })
        }
      , 'posts:one': function(el, placeholder) {
          new PostList(
            {
              collection: posts
            , el: el.find('.post-list')
            }
          )
        }
      , 'posts-toolbar:one': function(el, placeholder) {
          updateListHeight()
          new Toolbar({ collection: posts, el: el })
        }

      }

  // Handlers
  // -----
  function getListHeight(el) {
    // 30 is the #page margin bottom
    return $(window).height() - el.offset().top - 30
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
  engage.showAjax()
  
  tmplLoader.addListeners(templateListeners)
  tmplLoader.load($('#page'))
})