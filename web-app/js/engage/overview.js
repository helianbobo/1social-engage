;define(['engage', 'lib/highcharts/brandtology'], function(engage) {


  // Page setup
  // -----
  $(document.body).ready(function() {
    //$(window).resize(updateListHeight)
    engage.showAjax()
  
    //tmplLoader.addListeners(templateListeners)
    tmplLoader.load($('#page'))
  })
})