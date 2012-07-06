$(document.body).ready(function() {
  var CaseItem = Backbone.View.extend(
        {
          initialize: function(options) {
            this.li = options.li
            this.render()
          }

        , render: function() {
            var data = this.model.toJSON()

            // split date & time
            var date = data.articleDateTimePost.split(/[TZ]/)
            data.datePosted = date[0]
            data.timePosted = date[1]
            var date = data.dateCreated.split(/[TZ]/)
            data.dateCreated = date[0]
            data.timeCreated = date[1]

            this.setElement($(Mustache.render(this.li, data)))
          }
        }
      )

  var CaseList = Backbone.View.extend(
        {
          initialize: function(options) {
            this.$li = this.extractTemplate(this.$('li:first'))
            this.childs = []

            this.collection.on('sync', this.render, this)
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
            collection.forEach(function(it) {
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
  

  var cases = new engage.model.Cases(null
      , {
          pageSize: 20
        , order: 'desc'
        , sort: 'dateCreated'
        }
      )
    , assets = engage.assets = new engage.model.Assets()

  var caseList = new CaseList({ collection: cases, el: $('.case-list') })

  var templateListeners = {
        'cases-toolbar:one': function(el, placeholder) {
          updateListHeight('.case-list-wrap')()
          new Toolbar({ collection: cases, el: el })
        }
      }

  function updateListHeight(selector) {
    var el = $(selector)

    return function() {
      el.height($(window).height() - el.offset().top - 30)
    }
  }

  $(window).resize(updateListHeight('.case-list-wrap'))

  tmplLoader.addListeners(templateListeners)
  tmplLoader.load($('#page'))
})