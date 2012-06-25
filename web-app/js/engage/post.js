$(document.body).ready(function() {
  // constants
  var DEFAULT_TEMPLATE_FILTER = function(el) { return el.attr('tmpl-load-timing') != 'manual' }

  // models
  var AppFrame = Backbone.Model.extend({})

  var ElementQueue = Backbone.Model.extend({
    push: function(obj) {
      var arr = []

      this.get('queue') && arr.push.apply(arr, this.get('queue'))
      arr.push(obj)
      this.set('queue', arr)
    }
  })

  // variables
  var appFrame = new AppFrame()
    , ids = 0
    , modalQueue = new ElementQueue({ max: 3 })
    , tmpls = {
        'app-case-modal': $('.app-case-modal').remove()
      , get: function(name) {
          var el = this[name]

          if (!el) throw 'could not get template named ' + name
          return el.clone()
        }
      }

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

  function loadTemplates(el, filter) {
    el.find('[tmpl]').each(function(i, it) {
      var el = $(it)
        , filter = filter || DEFAULT_TEMPLATE_FILTER

      filter(el) && loadTemplate(el)
    })
  }

  function newId(prefix, suffix) {
    return (prefix ? prefix : '') + (++ids) + (suffix ? suffix : '')
  }

  function prepareModal(name) {
    var el = tmpls.get(name)

    el.attr('id', newId('modal-'))
    $(document.body).append(el)
    return el
  }

  function repeat(ul) {
    var li = ul.find('li')

    for (var i = 0; i < 100; i++) ul.append(li.clone())
  }

  function updateListHeight() {
    $('.post-list-wrap').height(getListHeight())
  }

  // Event listeners
  // -----

  appFrame.on('change:templateLoaded', function(model, className) {
    var arr = className.split(' ')

    if (_.find(arr, function(it) { return it === 'toolbar'})) updateListHeight()
  })

  modalQueue.on('change:queue', function(model, queue) {
    if (queue.length > model.get('max')) {
      $('#' + queue.shift()).remove()
      this.set('queue', _.map(queue, function(it) { return it }))
    }
  })

  $('.post-list').delegate('.show-case', 'click', function() {
    var attrName = 'modal-id'
      , btn = $(this)
      , el = $('#' + btn.attr(attrName))

    if (el.length === 0) {
      el = prepareModal('app-case-modal')
      btn.attr(attrName, el.attr('id'))
      modalQueue.push(el.attr('id'))
      el.on('show', _.once(function() { loadTemplates(el) }))
    }
    
    el.modal()
  })

  // Page setup
  // -----

  $(window).resize(updateListHeight)
  updateListHeight()
  loadTemplates($('#page'))

  // TODO remove it after test
  repeat($('.post-list'))
})