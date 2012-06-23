$(document.body).ready(function() {

  function getListHeight() {
    return $(window).height() - $('.app-tabs').outerHeight() - $('.toolbar').outerHeight() - 30
  }

  function updateListHeight() {
    $('.post-list-wrap').height(getListHeight())
  }

  $(window).resize(updateListHeight)
  updateListHeight()

  var tmpl = $('.post-list li')
  for(var i = 0; i < 100; i++) $('.post-list').append(tmpl.clone())

})