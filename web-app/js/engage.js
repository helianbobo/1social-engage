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

      , update: function(response) {
          this.set(_.pick(response, 'offset', 'total'))
        }
      }
    )

// Global Objects
// -----

var tmplLoader = _.extend(
      {
        addListeners: function(options) {
          _.each(options, function(callback, key) {
                // key = 'tmplName[:one]'
                var arr = key.split(':') 

                tmplLoader[arr[1] || 'on']('load:' + arr[0], callback)
              }
            )
        }
      }
    , Backbone.Events
    )

function updatePriority(li) {
  li.prevAll().addClass('active')
  li.addClass('active')
  li.nextAll().removeClass('active')
}

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
            caseStatus: 1
          , priority: 3
          , version: 0
          }

        , idAttribute: 'caseId'

        , updateStatus: function(status) {
            this.set({ 'caseStatus': status, 'statusText': Case.statusMap[status] })
          }

        , parse: function(response) {
            var data = response

            if (response.data) {
              data = response.data
            }

            data.statusText = Case.statusMap[data.caseStatus]
            return data
          }

        , increase: function(attr, step) {
            this.set(attr, (this.get(attr) || 0) + (step || 1))
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/case/' + (this.id || 'new'))
          }
        }
      , {
          statusMap: {
            '0': 'Closed'
          , '1': 'Open'
          , '2': 'Responsed'
          }

        , Memo: Backbone.Model.extend(
            {
              url: function() {
                return joinPath($.contextPath, 'socialEngage/addNotes')
              }
            }
          )
        , Response: Backbone.Model.extend(
            {
              url: function() {
                return joinPath($.contextPath, 'socialEngage/responseCase')
              }
            }
          )
        }
      )
    
    , Cases = Backbone.Collection.extend(
        {
          initialize: function(models, options) {
            options = options || {}
            this.params = new Parameters(_.pick(options, 'order', 'sort', 'platform'))
            this.pagination = new Pagination(_.pick(options, 'offset', 'pageSize'))
          }

        , model: Case

        , collectParams: function() {
            var params = this.params.toJSON()
              , pagination = this.pagination.toJSON()

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
            this.pagination.update(response)
            return _.map(response.data, Case.prototype.parse)
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/getAllCase')
          }
        }
      )

    , CaseRecord = Backbone.Model.extend({})

    , CaseRecords = Backbone.Collection.extend(
        {
          model: CaseRecord

        , parse: function(response) {
            var attrs = ['datetime', 'userName', 'msg']
            function toObject(keys, values) {
              var obj = {}

              _.each(keys, function(key, i) { obj[key] = values[i] })
              return obj
            }
            return response.data.map(function(str) {
                return toObject(attrs, str.split(/\s+\-\s+/, 3))
              }
            )
          }

        , url: function() {
            return joinPath($.contextPath, 'socialEngage/getCaseHistory')
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
            this.pagination.update(response)
            return response.data
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
    , 'CaseRecord': CaseRecord
    , 'CaseRecords': CaseRecords
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