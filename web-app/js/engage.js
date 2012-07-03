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

// Global Models
// -----

var ElementQueue = Backbone.Model.extend(
      {
        push: function(obj) {
          this.set('queue', [].concat(this.get('queue') || [], obj))
        }
      }
    )

  , Parameters = Backbone.Model.extend({})

  , Pagination = Backbone.Model.extend(
      {
        defaults : {
          offset: 0
        , pageSize: 50
        , total: 0
        }
      }
    )

// Global Objects
// -----

var tmplLoader = _.extend({}, Backbone.Events)

;(function() {
  // constants
  var DEFAULT_TEMPLATE_FILTER = function(el) { return el.attr('tmpl-load-timing') != 'manual' }

  // Models
  // -----
  var Asset = Backbone.Model.extend({})

    , Assets = Backbone.Collection.extend(
        {
          model: Asset

        , parse: function(response) {
            return _.reduce(response.data
              , function(prev, it) { return prev.concat(it.pageData) }
              , []
              )
          }

        , url: function() {
            return joinPath($.contextPath, 'socialAssets/getAllAssets')
          }
        }
      )

    , Case = Backbone.Model.extend(
        {
          defaults: {
            priority: 3
          }

        , parse: function(response) {
            if (response.data) {
              var data = response.data

              if (!data.id) data.id = data.caseId
              
              // TODO map status num to text
              // data.statusText = statusMap[data.status]

              return data
            }
            return response
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/case/' + this.get('id'))
          }
        }
      , {
          statusMap: {
            // TODO mapping data
          }
        }
      )

    , Cases = Backbone.Collection.extend(
        {
          defaultOptions: {
            'sort': 'dateCreated'
          , 'order': 'asc'
          , 'max': 20
          , 'offset': 0
          , 'platform': 'everything'
          , 'assetId': 'everything'
          }

        , model: Case

        , parse: function(response) {
            return response.data
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/getAllCase')
          }
        }
      )

    , Conversation = Backbone.Model.extend(
        {
          collectParams: function() {
            return { articleId: this.toJSON().articleId, commentId:this.toJSON().commentId }
          }

        , fetch: function(options) {
            options = options || {}
            options.data = _.extend(this.collectParams(), options.data)
            Backbone.Model.prototype.fetch.apply(this, [options])
          }

        , parse: function(response) {
            var data = response
              , datetime = (data.datetimePost || '').split(/[TZ]/)

            data.date = datetime[0]
            data.time = datetime[1]

            return data
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/showConversation')
          }
        }
      )

    , Post = Backbone.Model.extend(
        {
          initialize: function(data) {
            var id = data.fbId
            if (data.comment && data.comment.length > 0) {
              id = data.comment[0].fbId
            }

            this.set({ id: id }, { silent: true })
          }
        }
      )

    , Posts = Backbone.Collection.extend(
        {
          initialize: function(models, options) {
            options = options || {}
            this.params = new Parameters(_.pick(options, 'order', 'sort', 'type'))
            this.pagination = new Pagination(_.pick(options, 'offset', 'pageSize'))
          }

        , model: Post

        , collectParams: function() {
            var params = {}
              , pagination = this.pagination.toJSON()

            params = _.extend(params, this.params.toJSON())

            params.max = pagination.pageSize
            if (pagination.offset > 0) params.offset = pagination.offset
            return params
          }

        , fetch: function(options) {
            options = options || {}
            options.data = _.extend(this.collectParams(), options.data)
            Backbone.Collection.prototype.fetch.apply(this, [options])
          }

        , parse: function(response) {
            this.updatePagination(response)
            return response.data
          }

        , updatePagination: function(response) {
            var data = _.pick(response, 'offset', 'total')
            this.pagination.set(data)
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/getAllPosts')
          }
        }
      )

  _.extend(engage.model, {
      'Asset': Asset
    , 'Assets': Assets
    , 'Case': Case
    , 'Cases': Cases
    , 'Conversation': Conversation
    , 'Post': Post
    , 'Posts': Posts
    }
  )

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
        if ($.isFunction(callback)) callback(newEl, el)
      }
    })
  }

  function loadTemplates(el, filter) {
    filter = filter || DEFAULT_TEMPLATE_FILTER
    var callback = function(el, placeholder) {
          loadTemplates(el, filter)
          tmplLoader.trigger('load:' + placeholder.attr('tmpl'), el, placeholder)
        }
      , load = function(i, it) {
          var el = $(it)

          if (!filter) loadTemplate(el, callback)
          filter(el) && loadTemplate(el, callback)
        }

    if (el.hasClass('tmpl')) load(0, el)
    else el.find('[tmpl]').each(load)
  }

  tmplLoader.load = loadTemplates
})()