
// Namespaces
var engage = {
      appFrame: _.extend({}, Backbone.Events)
    , model: {}

    , repeat: function (ul, max) {
        var li = ul.find('li')
          , max = max || 10

        for (var i = 0; i < max; i++) ul.append(li.clone())
      }
    }

$(document.body).ready(function() {
  // constants
  var DEFAULT_TEMPLATE_FILTER = function(el) { return el.attr('tmpl-load-timing') != 'manual' }

  // Models
  // -----
  var ElementQueue = Backbone.Model.extend(
      {
        push: function(obj) {
          var arr = []

          this.get('queue') && arr.push.apply(arr, this.get('queue'))
          arr.push(obj)
          this.set('queue', arr)
        }
      }
    )

  var Post = Backbone.Model.extend(
        {
        }
      )

    , Posts = Backbone.Collection.extend(
        {
          model: Post

        , parse: function(response) {
            return response.data
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/getAllPosts')
          }
        }
      )
    
    , PostList = Backbone.View.extend(
        {
          initialize: function(options) {
            // prepare template
            this.$li = this.$el.html() //this.$('li').remove()
            this.$el.empty()

            this.collection.on('sync', this.render, this)
          }

        , append: function(model) {
            var data = model.toJSON()
              , date = data.datetimePosted.split(/[TZ]/)

            data.date = date[0]
            data.time = date[1]
            // data.voicePic = 'src="' + data.voicePic + '"'

            var li = $(Mustache.render(this.$li, data))
            this.$el.append(li)
            li.find('img').each(function(i, it) {
              var img = $(it)

              img.attr('src', img.attr('data-original'))
            })
            // lazy load has some bug when image inside a scrollable div
            // li.find('img').lazyload()
          }

        , render: function(collection, data) {
            var _t = this

            collection.forEach(function(it) {
              _t.append(it)
            })
          }
        }
      )

  _.extend(engage.model, {
      'Post': Post
    , 'Posts': Posts
    }
  )


  // Objects
  // -----

  var appFrame = engage.appFrame
    , ids = 0
    , modalQueue = new ElementQueue({ max: 3 })
    , posts = engage.posts = new engage.model.Posts()
    , postList = new PostList(
        {
          collection: posts
        , el: $('.post-list')
        }
      )
    , tmpls = {
        'app-case-modal': $('.app-case-modal').remove()
      , get: function(name) {
          var el = this[name]

          if (!el) throw 'could not get template named ' + name
          return el.clone()
        }
      }

  // Handlers
  // -----
  function getListHeight(el) {
    // 30 is the #page margin bottom
    return $(window).height() - el.offset().top - 30
  }

  function getTemplatePath(path) {
    return path.indexOf('.') > 0 ? path : path + '.html'
  }

  function loadTemplate(el, callback) {
    var url = joinPath($.contextPath, '/tmpl/' + getTemplatePath(el.attr('tmpl')))

    $.ajax({
      url: url,
      success: function(data) {
        var newEl = $(data)

        el.replaceWith(newEl)
        if ($.isFunction(callback)) callback(el, newEl)
      }
    })
  }

  function loadTemplates(el, filter) {
    filter = filter || DEFAULT_TEMPLATE_FILTER
    var callback = function(placeholder, el) {
          loadTemplates(el, filter)
          appFrame.trigger('templateLoaded', placeholder.attr('class'), el)
        }
      , load = function(i, it) {
          var el = $(it)

          if (!filter) loadTemplate(el, callback)
          filter(el) && loadTemplate(el, callback)
        }

    if (el.hasClass('tmpl')) load(0, el)
    else el.find('[tmpl]').each(load)
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

  function updateListHeight() {
    $('.post-list-wrap').height(getListHeight($('.post-list-wrap')))
  }

  // Event listeners
  // -----

  appFrame.on('templateLoaded', function(className, el) {
    var arr = className.split(' ')

    function has(obj) {
      return _.find(arr, function(it) { return it === obj })
    }

    if (has('toolbar')) updateListHeight()
    if (has('app-case')) {
      var obj = new engage.CaseApp({el: el})
      el.parents('.modal').on('remove', function() {
        obj.destroy()
        obj = null
      })
    }
  })

  modalQueue.on('change:queue', function(model, queue) {
    if (queue.length > model.get('max')) {
      var el = $('#' + queue.shift())
      
      el.trigger('remove')
      el.remove()
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
  window.loadTemplates = loadTemplates

  engage.posts.fetch()

  // engage.repeat($('.post-list'), 50)
})