$(document.body).ready(function() {

  function getListHeight() {
    return $(window).height() - $('.app-tabs').outerHeight() - $('.toolbar').outerHeight() - 30
  }

  function updateListHeight() {
    $('.post-list-wrap').height(getListHeight())
  }

  $(window).resize(updateListHeight)
  // updateListHeight()

  var tmpl = $('.post-list li')
  for(var i = 0; i < 100; i++) $('.post-list').append(tmpl.clone())

  $('.post-item').delegate('.show-case', 'click', function() {
    $('.modal').modal()
  })

  function getTemplatePath(path) {
    return path.indexOf('.') > 0 ? path : path + '.html'
  }

  function joinPath(s1, s2) {
    s1 = s1.replace(/\/$/, '')
    s2 = s2.replace(/^\//, '')
    return s1 + '/' + s2;
  }

  function loadTemplate(el, fn) {
    var url = joinPath($.rootPath, '/tmpl/' + getTemplatePath(el.attr('tmpl')))
    console.log(url)
    $.ajax({
      url: url,
      success: function(data) {
        el.replaceWith(data)
        appFrame.set({'templateLoaded': el.attr('class')})
      }
    })
  }

  var AppFrame = Backbone.Model.extend({})

  var appFrame = new AppFrame()

  appFrame.on('change:templateLoaded', function(model, className) {
    var arr = className.split(' ')

    if (_.find(arr, function(it) { return it === 'toolbar'})) updateListHeight()
  })

  $('[tmpl]').each(function(i, it) {
    loadTemplate($(it))
  })
})