// Case
define(['engage'], function(engage) {


// Models
// -----
;(function() {

  var CaseApp = engage.CaseApp = Backbone.View.extend(
        {
          initialize: function(options) {
            var _t = this
              , details = this.$('.case-details')

            this.model = engage.posts.get(this.$el.attr('post-id'))

            this.childs = _.map(
              {
                'post-info': '.post-info'
              , 'case-form': '.case-wrap'
              }
            , function(selector, name) {
                return new CaseApp[_.capitalize(_.toCamelCase(name))](
                  {
                    el: _t.$(selector)
                  , parent: _t
                  }
                )
              }
            )

            details.find('.nav-tabs a').one('show', function() {
              var tab = $(this)
                , name = tab.attr('href').split('#')[1]
                , loaded = function(el, placeholder) {
                    _t.childs[name] = new CaseApp[_.capitalize(_.toCamelCase(name))](
                      {
                        parent: _t
                      , el: el
                      }
                    )
                  }

              tmplLoader.one('load:' + name, loaded)
              tmplLoader.load(_t.findPane(tab.attr('href')), function() { return true })
            })

            if (!this.model.get('caseId')) {
              var el = details.find('.nav-tabs li:first')
              el.nextAll().addClass('hide')

              this.model.on('change:caseId', function() { el.nextAll().removeClass('hide') })
            }

            // load the content of first tab
            details.find('.nav-tabs a:first').click();
          }
        , destroy: function() {
            _.each(this.childs, function(it) { it.destroy() })
            
            this.$el.remove()
            this.reset()
          }
        , findPane: function(id) {
            var el = $(id)

            return (el.length > 0) ? el : this.$('.case-details [name=' + id.split('#')[1] + ']:first')
          }
        }
      )

  CaseApp.CaseConversation = Backbone.View.extend(
    {
      initialize: function(options) {
        var comments = options.parent.model.get('comment')
          , commentId = comments[0] ? comments[0].fbId : 0
          , id = options.parent.model.get('fbId')
          , conversation = new engage.model.Conversation(
              {
                id: id
              , articleId: id
              , commentId: commentId
              }
            )

        this.tmpl = this.extractTemplate(this.$('.conversation-inner').children())
        this.model = conversation
        conversation.on('change', this.render, this)
        conversation.on('sync', function() {
            var _case = engage.cases.get(options.parent.model.get('caseId'))
            if (_case && _case.get('updateCount') > 0) {
              $.ajax(
                {
                  url: _.absolutePath($.contextPath, 'socialEngage/markCaseRead')
                , data: { caseId: _case.id }
                , dataType: 'json'
                , success: function(response) {
                    if (response.response == 'ok') {
                      _case.set({ 'updateCount' : 0, 'readStatus': 'read'})
                    }
                  }
                }
              )
            }
          }
        )
        conversation.fetch()
      }

    , events: {
        'click [data-filter]': 'filter'
      }

    , filter: function(evt) {
        var el = $(evt.currentTarget)
          , type = el.attr('data-filter')

        el.closest('ul').find('li').removeClass('active')
        el.parent().addClass('active')

        if (type == 'all') {
          this.$('.comment').removeClass('hide')
        } else {
          var original = this.$('.original').parent().find('.user-name').attr('title')
          this.$('.comment').each(function(i, it) {
            if ($(it).find('.user-name').attr('title') != original) {
              $(it).addClass('hide')
            }
          })
        }
      }

    , render: function(model, data) {
        var ctn = this.$('.conversation-inner')
          , data = model.toJSON()

        data.commentCount = data.comments.length
        _.each(data.comments, function(it) {
          it.isOriginal = it.isOriginal || 0
        })

        // format datetime
        data.format = function() {
          return function(text, render) {
            return engage.formatDateTime(render(text), 'h:mm:ss tt MMM dd yyyy')
          }
        }

        ctn.html(Mustache.render(this.tmpl, data))
        this.$('img').lazyload({ container: ctn, effect: "fadeIn" })

        var original = ctn.find('.original:first').closest('li')
        if (original.length > 0) {
          ctn.animate({ scrollTop: $.relativeOffset(original, ctn).top }, 'slow')
        }
      }
    }
  )

  var CaseForm = CaseApp.CaseForm = Backbone.View.extend(
        {
          initialize: function(options) {
            var _t = this
              , model = this.model = getOrCreateCase(options.parent.model)

            this.childs = {
              'add-response': this.createChild('AddResponse', '.reponse-wrap')
            , 'add-memo': this.createChild('AddMemo', '.memo-wrap')
            }

            model.one('change:caseId'
            , function(model) {
                _.each(['add-response', 'add-memo'], function(it) {
                    this.childs[it].switchMode('edit').save()
                    this.trigger('display:'+ it, false)
                  }
                , this
                )
                this.switchMode('edit')
              }
            , this
            )

            this.switchMode(this.model.id ? 'edit' : 'create')
          }

        , createChild: function(className, selector) {
            return new CaseForm[className](
              {
                el: this.$(selector)
              , model: this.model
              , parent: this
              }
            )
          }

        , switchMode: function(mode) {
            if (mode === 'create') {
              this.$('.create-case').removeClass('hide')
              this.$('.edit-case').addClass('hide')
              if (!this.childs['create-case']) {
                this.childs['create-case'] = this.createChild('CreateCase', '[name=create-case]')
              }
              this.$('.create-case a').click()
            } else {
              this.$('.create-case').addClass('hide')
              this.$('.edit-case').removeClass('hide')

              if (!this.model.get('caseId')) {
                this.model.set('caseId', this.options.parent.model.get('caseId'))
              }

              if (!this.childs['edit-case']) {
                this.childs['edit-case'] = this.createChild('EditCase', '[name=edit-case]')
              }
              // change:caseId maybe fired more than once
              this.$('.edit-case a').click().find('.case-id').html(this.model.id)
            }
            return this
          }
        }
      )

  CaseApp.CaseHistory = Backbone.View.extend(
    {
      initialize: function(options) {
        this.li = this.extractTemplate(this.$('ul li'))
        this.model = new engage.model.CaseRecords()

        var _case = this.model._case = 
            engage.cases.get(options.parent.model.get('caseId'))
        _case.on('change', this.refresh, this)

        this.model.on('sync', this.render, this)
        this.refresh()
      }

    , refresh: function(model, evt) {
        this.model.fetch(
          {
            data: { caseId: this.model._case.id }
          }
        )
      }

    , render: function(collection) {
        var li = this.li

        function format() {
          return function(text, render) {
            return engage.formatDateTime(render(text), 'HH:mm:ss MMM dd yyyy')
          }
        }
        
        this.$('ul').html(
          collection.map(
            function(model) {
              var data = model.toJSON()

              data.format = format
              return Mustache.render(li, data)
            }
          ).join('')
        )
      }
    }
  )

  CaseApp.CaseSocialProfile = Backbone.View.extend(
    {
      initialize: function(options) {
        var _t = this

        this.tmpls = {}

        this.$('.tab-pane').each(function() {
            var el = $(this)

            _t.tmpls[el.attr('name')] = _t.extractTemplate(el.children())
          }
        )
        
        this.model = new engage.model.Profile({
          id: engage.cases.get(options.parent.model.get('caseId')).get('voiceId')
        })

        this.model.on('sync', this.render, this)
        this.model.fetch()
      }

    , events: {
        'click .btn-cancel': 'changeMode'
      , 'click .btn-edit': 'changeMode'
      , 'click .btn-save-contact': 'saveContact'
      , 'click .btn-save-social': 'saveSocial'
      }

    , changeMode: function(evt) {
        function reverse(mode) {
          return mode == 'read' ? 'edit': 'read'
        }

        var el = $(evt.currentTarget).closest('.tab-pane')
          , mode = reverse(el.attr('data-status') || 'read')


        _.each(['read', 'edit'], function(it) {
            el.find('[data-mode=' + it + ']')[it == mode ? 'removeClass' : 'addClass']('hide')
          }
        )

        el.attr('data-status', mode)
      }

    , render: function(model, part) {
        var data = model.toJSON()
          , tmpls = (part in this.tmpls) ? _.pick(this.tmpls, part) : this.tmpls

        function fill(tmpl, name) {
          this.$('[name=' + name + ']').html(Mustache.render(tmpl, data))
        }
        _.each(tmpls, _.bind(fill, this))

        this.$('[data-mode=read]').removeClass('hide')
        this.$('[data-mode=edit]').addClass('hide')
      }

    , collectInputs: function(el) {
        var data = {}

        el.find('input').each(function(i, it) {
            var input = $(it)

            data[input.attr('name')] = input.val()
          }
        )
        return data
      }

    , saveContact: function(evt) {
        var el = $(evt.currentTarget).closest('.tab-pane')
          , data = this.collectInputs(el)
          , model = this.model
          , _t = this

        data.voiceId = model.id

        $.ajax(
          {
            url: _.absolutePath($.contextPath, 'socialEngage/updateVoiceDetails')
          , data: data
          , dataType: 'json'
          , success: function(response) {
              if (response.response == 'ok') {
                model.set(data)
                _t.render(model, el.attr('name'))
              }
            }
          }
        )
      }

    , saveSocial: function(evt) {
        var el = $(evt.currentTarget).closest('.tab-pane')
          , data = this.collectInputs(el)
          , model = this.model
          , _t = this

        data.voiceId = model.id

        $.ajax(
          {
            url: _.absolutePath($.contextPath, 'socialEngage/updateSocialProfile')
          , data: data
          , dataType: 'json'
          , success: function(response) {
              if (response.response == 'ok') {
                model.set(data.type, data)
                _t.render(model, el.attr('name'))
              }
            }
          }
        )
      }
    }
  )

  CaseApp.PostInfo = Backbone.View.extend(
    {
      initialize: function(options) {
        this.tmpl = this.extractTemplate(this.$el.children())
        this.model = options.parent.model
        this.render()
      }

    , render: function() {
        var data = this.model.toJSON()
        data.postContent = data.content
        data.postVoiceId = data.voiceId
        data.postVoiceName = data.voiceName
        data.postVoicePic = data.voicePic
        data.postVoiceURL = data.voiceURL
        if (data.comment && data.comment.length > 0) {
          data.postContent = data.comment[0].content
          data.postVoiceId = data.comment[0].voiceId
          data.postVoiceName = data.comment[0].voiceName
          data.postVoicePic = data.comment[0].voicePic
          data.postVoiceURL = data.comment[0].voiceURL
        }
        this.$el.html(Mustache.render(this.tmpl, data))
        this.$('img').lazyload({ effect: "fadeIn" })
        this.$('a').copyAttr('data-url', 'href')
      }
    }
  )

  var AddMemo = Backbone.View.extend(
        {
          initialize: function(options) {
            options.parent.on('display:add-memo', this.display, this)
            this.model.on('change:note', this.render, this)
            // this.refCase = this.model
            // this.resetModel()
            this.switchMode(!this.model.id ? 'create' : 'edit')
          }

        , events: {
            'click .btn-cancel': 'cancel'
          , 'click .btn-ok': 'cancel'
          , 'click .btn-save': 'save'
          }

        , cancel: function() {
            this.options.parent.trigger('display:add-memo', false)
            return false
          }

        , display: function(visiable) {
            if (visiable) this.$el.removeClass('hide')
            else this.$el.addClass('hide')
          }

        , render: function(model) {
            this.$('[name=memo]').val(model.get('note'))
          }

        , resetModel: function() {
            if (!this.refCase.id) {
              return this.model = null
            }
            this.model = new engage.model.Case.Memo(
              {
                caseId: this.refCase.id
              , type: 'facebook'
              }
            )
          }

        , save: function(evt) {
            var input = this.$('[name=memo]')
            var val = $.trim(input.val())

            if (val) {
              this.model.save(
                { note: val }
              , {
                  success: function() {
                    if (evt) showMsg('Memo saved', $(evt.currentTarget).parent())
                  }
                }
              )
            }
            return evt ? false : this
          }

        , switchMode: function(mode) {
            this.$('[data-mode]').each(function(i, it) {
                var el = $(it)

                el[el.attr('data-mode') === mode ? 'removeClass': 'addClass']('hide')
              }
            )
            return this
          }
        }
      )

    , AddResponse = Backbone.View.extend(
        {
          initialize: function(options) {
            options.parent.on('display:add-response', this.display, this)
            this.refCase = this.model
            this.resetModel()
            this.switchMode(this.model == null ? 'create' : 'edit')
          }

        , events: {
            'click .btn-cancel': 'cancel'
          , 'click .btn-ok': 'cancel'
          , 'click .btn-save': 'save'
          , 'keydown [name=response]': 'editing'
          , 'keyup [name=response]': 'editing'
          }

        , cancel: function() {
            this.options.parent.trigger('display:add-response', false)
            return false
          }

        , display: function(visiable) {
            if (visiable) this.$el.removeClass('hide')
            else this.$el.addClass('hide')
          }

        , editing: function(evt) {
            var el = $(evt.currentTarget)
            this.$('.char-left').html(140 - el.val().length)
          }

        , resetModel: function() {
            if (!this.refCase.id) {
              return this.model = null
            }
            this.model = new engage.model.Case.Response(
              {
                caseId: this.refCase.id
              , type: 'facebook'
              }
            )
          }

        , save: function(evt) {
            var input = this.$('[name=response]')
            var val = $.trim(input.val())

            if (val) {
              if (!this.model) this.resetModel()

              var _t = this

              this.model.save(
                { 'response': val }
              , {
                  success: function(model, response) {
                    if (response.caseId) {
                      input.val('')
                      _t.resetModel()
                      if (evt) showMsg('Response sent', $(evt.currentTarget).parent())
                      _t.refCase.increase('version')
                      _t.refCase.updateStatus(response.caseStatus || 2)
                    }
                  }
                }
              )
            }
            return evt ? false : this
          }

        , switchMode: function(mode) {
            this.$('[data-mode]').each(function(i, it) {
                var el = $(it)

                el[el.attr('data-mode') === mode ? 'removeClass': 'addClass']('hide')
              }
            )
            return this
          }
        }
      )

    , CreateCase = Backbone.View.extend(
        {
          initialize: function(options) {
            var _t = this

            _.each(['add-memo', 'add-response'], function(it) {
                options.parent.on('display:' + it, function(visiable) {
                    var method = visiable ? 'addClass' : 'removeClass'

                    _t.$('[data-panel=' + it + ']')[method]('btn-active')
                  } 
                )
              }
            )

            rates(this.$('.prioritys'), this.model.get('priority'))
              .on('change', function(evt, value) {
                  _t.model.set('priority', value)
                }
              )
            
          }

        , events: {
            'click .add-action': 'displayPanel'
          , 'click .btn-create-case': 'createCase'
          }

        , createCase: function() {
            this.model.set('name', this.$('[name=title]').val())
            this.model.save()
          }

        , displayPanel: function(evt) {
            var btn = $(evt.currentTarget)
              , active = btn.hasClass('btn-active')
              , parent = this.options.parent

            btn.parent().find('.add-action').each(function(i, it) {
              it = $(it)
              parent.trigger('display:' + it.attr('data-panel')
                , btn.attr('data-panel') == it.attr('data-panel') ? !active : false
                )
            })
          }

        }
      )

    , EditCase = Backbone.View.extend(
        {
          initialize: function(options) {
            var _t = this

            _.each(['add-memo', 'add-response'], function(it) {
                options.parent.on('display:' + it, function(visiable) {
                    var method = visiable ? 'addClass' : 'removeClass'

                    _t.$('[data-panel=' + it + ']')[method]('btn-active')
                  }
                )
              }
            )

            var prioritys = this.$('.prioritys')
            rates(prioritys, this.model.get('priority'), false)
              .on('change', function(evt, value) {
                  _t.model.set({ 'newPriority': value }, { silent: true })
                }
              )

            this.changeMode('read')
            this.model.on('sync', this.render, this)
            this.model.on('change:caseStatus', this.render, this)
            this.model.on('change:priority', function(model, data) {
                prioritys.trigger('change', data)
              }
            )

            if (this.model.get('title')) this.render(this.model)
          }

        , events: {
            'click .add-action': 'displayPanel'
          , 'click .btn-close-case': 'close'
          , 'click .btn-edit-case': 'changeMode'
          , 'click .btn-cancel': 'cancel'
          , 'click .btn-save-case': 'save'
          }

        , cancel: function(evt) {
            this.model.unset('newPriority', { silent: true})
            this.changeMode(evt)
          }

        , changeMode: function(evt) {
            var btn
              , editable

            if (typeof evt == 'string') {
              editable = /edit/.test(evt)
            } else {
              btn = this.$('.btn-edit-case')
              editable = !btn.hasClass('btn-active')
            }

            this.$('[data-mode]').each(function(i, it) {
                var el = $(it)
                  , mode = editable ? 'edit' : 'read'

                el[el.attr('data-mode') === mode ? 'removeClass' : 'addClass']('hide')
              }
            )

            if (!editable) this.render(this.model)
            this.$('.prioritys').trigger('enable', editable)
            this.editable = editable
            if (btn) btn.toggleClass('btn-active')
          }

        , close: function() {
            if (this.editable) this.$('.btn-edit-case').click()
            this.model.destroy(
                {
                  success: function(model, response) {
                    // the model is not actually deleted
                    // should be a PUT with { caseStatus: 0 }
                    model.set(model.parse(response), { silent: true })
                  }
                }
              )
          }

        , displayPanel: function(evt) {
            var btn = $(evt.currentTarget)
              , active = btn.hasClass('btn-active')
              , parent = this.options.parent

            btn.parent().find('.add-action').each(function(i, it) {
              it = $(it)
              parent.trigger('display:' + it.attr('data-panel')
                , btn.attr('data-panel') == it.attr('data-panel') ? !active : false
                )
            })
          }

        , render: function(model) {
            this.$('.title').html(model.get('title'))
            this.$('[name=title]').val(model.get('title'))

            this.$('.case-status').html(model.get('statusText'))

            this.$('.prioritys').trigger('change', model.get('priority'))

            if (parseInt(model.get('caseStatus')) === 0) {
              this.$('.control-actions').addClass('hide')
            }
          }

        , save: function(evt) {
            var _t = this
              , data = {
                  'title': this.$('[name=title]').val()
                }

            if (this.model.get('newPriority')) {
              data.priority = this.model.get('newPriority')
              this.model.unset('newPriority', { silent: true })
            }
            this.model.save(data
              , {
                  // the wait:true will make unexpected change events
                  // wait: true
                  success: function() { _t.changeMode(evt) } 
                }
              )
          }

        }
      )
  
  function getOrCreateCase(post) {
    var id = post.get('caseId')
      , model = null

    if (id) {
      model = engage.cases.get(id)
      if (!model) {
        model = new engage.model.Case({caseId: id})
        model.one('sync', function() { engage.cases.add(model) })
        model.fetch()
      }
    } else {
      var comment = post.get('comment')[0]
        , data = {
            'articleId': post.get('fbId')
          , 'caseId': post.get('caseId')
          , 'type': 'facebook'
          }

      if (comment) data.commentId = comment.fbId
      model = new engage.model.Case(data)
      model.on('change:caseId'
        , function(model, id) {
            post.set('caseId', id)
            engage.cases.add(model)
          }
        )
    }
    return model
  }

  function rates(el, _default, enable) {
    _default = _default || 1
    if (typeof enable == 'undefined') enable = true

    function reset(evt, value) {
      if (typeof value == 'number') el.attr('data-prev', value)
      else value = el.attr('data-prev') || _default
      engage.updatePriority(el.find('li:nth-child(' + value + ')'))
    }

    el.on('enable', function(evt, value) {
      enable = !!value
      el[enable ? 'removeClass': 'addClass']('disabled')
    })
    el.on('change', reset)

    el.delegate('a', 'click', function() {
        enable && el.trigger('change', $(this).parent().index() + 1) 
      }
    )
    el.delegate('a', 'mouseenter', function() { 
      enable && engage.updatePriority($(this).parent())
    })
    el.delegate('a', 'mouseleave', function() { enable && reset() })

    reset()
    return el
  }

  function showMsg(msg, parent) {
    var el = $('<span>' + msg + '</span>')
    parent.prepend(el)
    setTimeout(function() {
        el.fadeOut('slow', function() { el.remove() })
      }
    , 2500
    )
  }

  _.extend(CaseForm
  , {
      'AddMemo': AddMemo
    , 'AddResponse': AddResponse
    , 'CreateCase': CreateCase
    , 'EditCase': EditCase
    }
  )
})()

})