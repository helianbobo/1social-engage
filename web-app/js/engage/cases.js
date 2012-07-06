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

  var cases = new engage.model.Cases()

  var caseList = new CaseList({ collection: cases, el: $('.case-list') })

  var templateListeners = {
        'cases-toolbar:one': function() {
          updateListHeight('.case-list-wrap')()
          // new Toolbar({ collection: posts, el: el })
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