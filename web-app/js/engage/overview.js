;define(['engage', 'jquery-ui.datepicker', 'lib/highcharts/brandtology'], function(engage) {

  var Overview = Backbone.View.extend({
        initialize: function(options) {
          this.$el.find('.date-dropdown input').datepicker({
            dateFormat: 'dd MM yy'
          , changeMonth: true
          , numberOfMonths: 1
          });

          this.$el.delegate('.date-dropdown', 'click', function() {
            $(this).find('input').datepicker('show')
          })

          this.model.on('sync', this.render, this)
          if (this.model.length > 0) {
            this.render(this.model)
          }
        }

      , render: function(model) {
          
        }
      })

  var assets = new engage.model.Assets()
    , templateListeners = {
        'engage-overview:one': function(el, placeholder) {
          new Overview({
            model: assets
          , el: el
          })
        }
      }
  // Page setup
  // -----
  $(document.body).ready(function() {
    //$(window).resize(updateListHeight)
    engage.showAjax()

    assets.fetch()
  
    tmplLoader.addListeners(templateListeners)
    tmplLoader.load($('#page'))
  })
})