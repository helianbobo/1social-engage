// Case

// Models
// -----
engage.CaseApp = Backbone.View.extend(
    {
      initialize: function(options) {
        var _t = this;
        this.$('.case-details .nav-tabs a').one('show', function() {
          var tab = $(this)

          loadTemplates(_t.findPane(tab.attr('href')), function() { return true })
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

$(document.body).ready(function() {
  function repeat(ul, max) {
    var li = ul.find('li')
      , max = max || 12

    for(var i = 0; i < max; i++) ul.append(li.clone())
  }

  repeat($('.comments ul'))
  repeat($('.case-history-wrap ul'), 50)
})