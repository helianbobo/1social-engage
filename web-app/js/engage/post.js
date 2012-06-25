$(document.body).ready(function() {
  var AppFrame = Backbone.Model.extend({})

  var appFrame = new AppFrame()

  function getListHeight() {
    return $(window).height() - $('.app-tabs').outerHeight() - $('.toolbar').outerHeight() - 30
  }

  function getTemplatePath(path) {
    return path.indexOf('.') > 0 ? path : path + '.html'
  }

  function joinPath(s1, s2) {
    s1 = s1.replace(/\/$/, '')
    s2 = s2.replace(/^\//, '')
    return s1 + '/' + s2;
  }

  function loadTemplate(el) {
    var url = joinPath($.rootPath, '/tmpl/' + getTemplatePath(el.attr('tmpl')))

    $.ajax({
      url: url,
      success: function(data) {
        el.replaceWith(data)
        appFrame.set({'templateLoaded': el.attr('class')})
      }
    })
  }

  function repeat(ul) {
    var li = ul.find('li')

    for (var i = 0; i < 100; i++) ul.append(li.clone())
  }

  function updateListHeight() {
    $('.post-list-wrap').height(getListHeight())
  }

  appFrame.on('change:templateLoaded', function(model, className) {
    var arr = className.split(' ')

    if (_.find(arr, function(it) { return it === 'toolbar'})) updateListHeight()
  })

  $('.post-item').delegate('.show-case', 'click', function() {
    $('.modal').modal()
  })

  $(window).resize(updateListHeight)
  updateListHeight()
  repeat($('.post-list'))

  $('[tmpl]').each(function(i, it) {
    loadTemplate($(it))
  })
})