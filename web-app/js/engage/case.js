// Case

// Models
// -----
engage.CaseApp = Backbone.View.extend({
      initialize: function(options) {
        var _t = this;

        this.childs = {}

        this.$('.case-details .nav-tabs a').one('show', function() {
          var tab = $(this)
            , loaded = function(className, el) {
                var name = el.parent().attr('name')

                _t.childs[name] = new engage[capitalize(toCamelCase(name))]({ el: el })
                engage.appFrame.off('templateLoaded', loaded)
              }

          loadTemplates(_t.findPane(tab.attr('href')), function() { return true })
          engage.appFrame.on('templateLoaded', loaded)
        })

        this.$('.case-details a:first').click();
      }
    , destroy: function() {
        this.$el.remove()
        delete this.el
        delete this.$el
      }
    , findPane: function(id) {
        var el = $(id)

        if (el.length > 0) return el

        return this.$('.case-details [name=' + id.split('#')[1] + ']:first')
      }
    }
  )

engage.CaseConversation = Backbone.View.extend({
      initialize: function(options) {
        engage.repeat(this.$('.comments ul'))
      }
    }
  )

engage.CaseHistory = Backbone.View.extend({
      initialize: function(options) {
        engage.repeat(this.$('ul'), 50)
      }
    }
  )

engage.CaseSocialProfile = Backbone.View.extend({
      initialize: function(options) {

      }
    }
  )