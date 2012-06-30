// Case

// Models
// -----
;(function() {

  var CaseApp = engage.CaseApp = Backbone.View.extend(
      {
        initialize: function(options) {
          var _t = this
            , details = this.$('.case-details')

          this.childs = {
            'post-info': new CaseApp.PostInfo(
              {
                el: this.$('.post-info')
              , caseApp: this
              }
            )
          }

          details.find('.nav-tabs a').one('show', function() {
            var tab = $(this)
              , name = tab.attr('href').split('#')[1]
              , loaded = function(el, placeholder) {
                  _t.childs[name] = new CaseApp[capitalize(toCamelCase(name))](
                    {
                      caseApp: _t
                    , el: el
                    }
                  )
                }

            tmplLoader.one('load:' + name, loaded)
            tmplLoader.load(_t.findPane(tab.attr('href')), function() { return true })
          })

          // load the content of first tab
          details.find('.nav-tabs a:first').click();
        }
      , destroy: function() {
          _.each(this.childs, function(it) { it.destroy() })
          
          this.$el.remove()
          this.reset()
        }
      , findPane: function(id) {
          var el = $(id)

          if (el.length > 0) return el

          return this.$('.case-details [name=' + id.split('#')[1] + ']:first')
        }
      }
    )

  CaseApp.CaseConversation = Backbone.View.extend({
        initialize: function(options) {
          var id = options.caseApp.$el.attr('post-id')
            , el = this.$('.conversation-inner')
            , conversation = new engage.model.Conversation({ id : id })

          this.tmpl = el[0].outerHTML
          el.replaceWith('<div class="conversation-inner"></div>')
          this.model = conversation
          conversation.on('change', this.render, this)
          conversation.fetch()
        }

      , render: function(model, data) {
          this.$('.conversation-inner').replaceWith(
              Mustache.render(this.tmpl, model.toJSON())
            )
        }
      }
    )

  CaseApp.CaseHistory = Backbone.View.extend({
        initialize: function(options) {
          engage.repeat(this.$('ul'), 50)
        }
      }
    )

  CaseApp.PostInfo = Backbone.View.extend(
      {
        initialize: function(options) {
          var id = options.caseApp.$el.attr('post-id')
            , post = engage.posts.get(id)

          this.model = post
          this.render()
        }

      , render: function() {
          var tmpl = this.el.outerHTML
            , el = $(Mustache.render(tmpl, this.model.toJSON()))

          this.$el.replaceWith(el)
          this.setElement(el)
          this.$('img').lazyload({ effect: "fadeIn" })
        }
      }
    )

  CaseApp.CaseSocialProfile = Backbone.View.extend({
        initialize: function(options) {

        }
      }
    )
})()