$(document.body).ready(function() {
    
  // Views
  // -----
  var PostItem = Backbone.View.extend(
        {
          initialize: function(options) {
            this.li = options.li

            this.model.on('change:selected', this.select, this)
            this.render()
          }

        , events: {
            'click .show-case': 'openCase'
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
      }
    }
  )

  Toolbar.PaginationActions = Backbone.View.extend(
    {
      initialize: function(options) {
        var _t = this

        this.collection.pagination.on('change', function(model, evt) {
          var data = model.toJSON()
            , max = Math.min(data.offset + data.pageSize, data.total)
          
          _t.$('.offset').html(data.offset + 1)
          _t.$('.max').html(max)
          _t.$('.total').html(data.total)
          _t.$('.prev,.next').removeClass('disabled')
          if (data.offset === 0) _t.$('.prev').addClass('disabled')
          if (max >= data.total) _t.$('.next').addClass('disabled')
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
    , modalQueue = new ElementQueue({ max: 3 })
    , assets = engage.assets = new engage.model.Assets()
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

  _.each(templateListeners, function(callback, key) {
        // key = 'tmplName[:one]'
        var arr = key.split(':') 

        tmplLoader[arr[1] || 'on']('load:' + arr[0], callback)
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
  tmplLoader.load($('#page'))
})