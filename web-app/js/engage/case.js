// Case

// Models
// -----
;(function() {

  var CaseApp = engage.CaseApp = Backbone.View.extend(
      {
        initialize: function(options) {
          var _t = this
            , details = this.$('.case-details')

          this.childs = {}

          details.find('.nav-tabs a').one('show', function() {
            var tab = $(this)
              , loaded = function(className, el) {
                  var name = tab.attr('href').split('#')[1]

                  _t.childs[name] = new CaseApp[capitalize(toCamelCase(name))]({ el: el })
                }

            tmplLoader.one('templateLoaded', loaded)
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
          engage.repeat(this.$('.comments ul'))
        }
      }
    )

  CaseApp.CaseHistory = Backbone.View.extend({
        initialize: function(options) {
          engage.repeat(this.$('ul'), 50)
        }
      }
    )

  CaseApp.CaseSocialProfile = Backbone.View.extend({
        initialize: function(options) {

        }
      }
    )
})()