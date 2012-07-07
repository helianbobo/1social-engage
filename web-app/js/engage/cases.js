$(document.body).ready(function() {
  var CaseItem = Backbone.View.extend(
        {
          initialize: function(options) {
            this.li = options.li
            this.render()
          }

        , events: {
            'click .show-case': 'openCase'
          }

        , openCase: function(evt) {
            var attrName = 'modal-id'
              , btn = $(evt.currentTarget)
              , el = $('#' + btn.attr(attrName))
              , data = this.model.toJSON()
              , postId = data.articleId

            if (data.comment && data.comment.length > 0) postId = data.commentId
            if (el.length === 0) {
              el = prepareModal('app-case-modal')
              btn.attr(attrName, el.attr('id'))
              modalQueue.push(el.attr('id'))
              el.one('show', function() { tmplLoader.load(el) })

              if (!engage.posts.get(postId)) {
                var post = {
                      'fbId': data.articleId
                    , 'caseId': data.caseId
                    , 'content': data.articleContent
                    , 'voiceName': data.articleVoiceName
                    , 'voicePic': data.articleVoicePicture
                    , 'comment': []
                    }
                if (data.comment && data.comment.length > 0) {
                  post.comment.push(
                    {
                      'content': data.comment[0].content
                    , 'fbId': data.commentId
                    , 'voiceName': data.comment[0].voiceName
                    , 'voicePic': data.comment[0].voicePicture
                    }
                  )
                }
                engage.posts.add(new engage.model.Post(post))
              }
            }
            
            el.find('.app-case').attr('post-id', postId)
            el.modal()
          }

        , render: function() {
            var data = this.model.toJSON()

            // split date & time
            function mapDatetime(obj, src, target) {
              _.extend(obj, array2Object(target, obj[src].split(/[TZ]/)))
            }

            mapDatetime(data, 'articleDateTimePost', ['datePosted', 'timePosted'])
            mapDatetime(data, 'dateCreated', ['dateCreated', 'timeCreated'])

            if (data.comment && data.comment.length > 0) {
              data.voiceName = data.comment[0].voiceName
              data.voicePic = data.comment[0].voicePicture
            } else {
              data.voiceName = data.articleVoiceName
              data.voicePic = data.articleVoicePicture
            }

            data.platformPic = joinPath($.contextPath, 'images/icon-' + data.type + '-32x32.png')

            this.setElement($(Mustache.render(this.li, data)))
            updatePriority(this.$('.prioritys-small li:nth-child(' + data.priority + ')'))
          }
        }
      )

  var CaseList = Backbone.View.extend(
        {
          initialize: function(options) {
            this.$li = this.extractTemplate(this.$('li:first'))
            this.childs = []

            this.collection.on('sync', this.render, this)
            var _t = this;
            this.collection.on('fetch:started', function(){
              $(document).trigger('showPreloader', [{places:[_t.$el]}]);
            }, this)
            this.collection.fetch()
          }

        , append: function(model) {
            var item = new CaseItem(
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
            this.collection.forEach(function(it) {
              _t.append(it)
            })

            this.$('img').lazyload(
                {
                  container: this.$el.parent()
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

  Toolbar.FilterActions = Backbone.View.extend(
    {
      initialize: function(options) {
        this.$asset = this.extractTemplate(this.$('.assets li:last'))
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


  var assets = engage.assets = new engage.model.Assets()
    , cases = engage.cases = new engage.model.Cases(null
      , {
          pageSize: 20
        , order: 'desc'
        , sort: 'dateCreated'
        }
      )
    , ids = 0
    , modalQueue = new ElementQueue({ max: 3 })
    , posts = engage.posts = new engage.model.Posts()

    , templateListeners = {
        'case': function(el, placeholder) {
          el.attr('post-id', placeholder.attr('post-id'))

          var obj = new engage.CaseApp({el: el})

          el.parents('.modal').on('remove', function() {
            obj.destroy()
            obj = null
          })
        }

      , 'cases:one': function(el, placeholder) {
          $(window).resize(updateListHeight('.case-list-wrap'))
          new CaseList({ collection: cases, el: el.find('.case-list') })
        }

      , 'cases-toolbar:one': function(el, placeholder) {
          updateListHeight('.case-list-wrap')()
          new Toolbar({ collection: cases, el: el })
        }
      }

    , tmpls = {
        'app-case-modal': $('.app-case-modal').remove()
      , get: function(name) {
          var el = this[name]

          if (!el) throw 'could not get template named ' + name
          return el.clone()
        }
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

  function updateListHeight(selector) {
    var el = $(selector)

    return function() {
      el.height($(window).height() - el.offset().top - 30)
    }
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

  tmplLoader.addListeners(templateListeners)
  tmplLoader.load($('#page'))
})