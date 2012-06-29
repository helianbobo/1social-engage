// Case

// Models
// -----
engage.CaseApp = Backbone.View.extend({
      initialize: function(options) {
        var _t = this
          , details = this.$('.case-details')

        this.childs = {}

        details.find('.nav-tabs a').one('show', function() {
          var tab = $(this)
            , loaded = function(className, el) {
                var name = el.parent().attr('name')

                _t.childs[name] = new engage[capitalize(toCamelCase(name))]({ el: el })
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