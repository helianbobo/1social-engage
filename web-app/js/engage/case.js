// Case

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
                return new CaseApp[capitalize(toCamelCase(name))](
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
                    _t.childs[name] = new CaseApp[capitalize(toCamelCase(name))](
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
        var comments = options.parent.model.get('comment');
        var commentId = comments[0]?comments[0].fbId:0;
        var id = options.parent.model.get('fbId')
          , conversation = new engage.model.Conversation(
              {
                id: id
              , articleId: id
              , commentId:commentId
              }
            )

        this.tmpl = this.extractTemplate(this.$('.conversation-inner').children())
        this.model = conversation
        conversation.on('change', this.render, this)
        conversation.fetch()
      }

    , render: function(model, data) {
        this.$('.conversation-inner').html(
            Mustache.render(this.tmpl, model.toJSON())
          )
        this.$('img').lazyload({ effect: "fadeIn" })
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
        
        this.switchMode(this.model.id ? 'eidt' : 'create')
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
          this.$('.edit-case a').append('<span>' + this.model.id + '</span>').click()
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
        
        this.$('ul').html(
          collection.map(
            function(model) {
              var obj = model.toJSON()
                , datetime = obj.datetime.split(/[TZ]/)

              obj.date = datetime[0]
              obj.time = datetime[1]

              return Mustache.render(li, obj) 
            }
          ).join('')
        )
      }
    }
  )

  CaseApp.CaseSocialProfile = Backbone.View.extend(
    {
      initialize: function(options) {

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
        this.$el.html(Mustache.render(this.tmpl, this.model.toJSON()));
        this.$('img').lazyload({ effect: "fadeIn" })
      }
    }
  )

  var AddMemo = Backbone.View.extend(
        {
          initialize: function(options) {
            options.parent.on('display:add-memo', this.display, this)
            this.refCase = this.model
            this.resetModel()
            this.switchMode(this.model == null ? 'create' : 'edit')
          }

        , events: {
            'click .btn-cancel': 'cancel'
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
              if (!this.model) this.resetModel()

              var _t = this

              this.model.save(
                { 'memo': val }
              , {
                  success: function(model, response) {
                    if (response.response == 'ok') {
                      input.val('')
                      _t.resetModel()
                      if (evt) showMsg('Memo saved', $(evt.currentTarget).parent())
                      _t.refCase.increase('version')
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
                    if (response.response == 'ok') {
                      input.val('')
                      _t.resetModel()
                      if (evt) showMsg('Response saved', $(evt.currentTarget).parent())
                      _t.refCase.increase('version')
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
            
            this.resetPriority()
          }

        , events: {
            'click .add-action': 'displayPanel'
          , 'click .btn-create-case': 'createCase'
          , 'click .prioritys a': 'setPriority'
          , 'mouseenter .prioritys a': 'showPriority'
          , 'mouseleave .prioritys a': 'resetPriority'
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

        , resetPriority: function() {
            updatePriority(
              this.$('.prioritys li:nth-child(' + this.model.get('priority') + ')')
            )
          }

        , setPriority: function(evt) {
            var btn = $(evt.currentTarget).parent()

            updatePriority(btn)

            this.model.set('priority', btn.parent().find('.active').length)
          }

        , showPriority: function(evt) {
            var btn = $(evt.currentTarget).parent()

            updatePriority(btn)
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

            this.changeMode('read')
            this.model.on('sync', this.render, this)

            if (this.model.get('title')) this.render()
            else this.model.fetch()
          }

        , events: {
            'click .add-action': 'displayPanel'
          , 'click .btn-close-case': 'close'
          , 'click .btn-edit-case': 'changeMode'
          , 'click .btn-cancel': 'cancel'
          , 'click .btn-save-case': 'save'
          , 'click .prioritys a': 'setPriority'
          , 'mouseenter .prioritys a': 'showPriority'
          , 'mouseleave .prioritys a': 'resetPriority'
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

            if (!editable) {
              this.render(this.model)
            }
            this.editable = editable
            if (btn) btn.toggleClass('btn-active')
          }

        , close: function() {
            if (this.editable) this.$('.btn-edit-case').click()
            this.model.destroy()
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

            this.resetPriority()
          }

        , resetPriority: function(evt) {
            if (!this.editable && evt) return;
            var priority = this.model.get('newPriority') || this.model.get('priority')

            updatePriority(
              this.$('.prioritys li:nth-child(' + priority + ')')
            )
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
                  wait: true
                , success: function() { _t.changeMode(evt) } 
                }
              )
          }

        , setPriority: function(evt) {
            if (!this.editable) return;

            var btn = $(evt.currentTarget).parent()

            updatePriority(btn)

            this.model.set('newPriority', btn.parent().find('.active').length
              , { silent: true }
              )
          }

        , showPriority: function(evt) {
            if (!this.editable) return;

            var btn = $(evt.currentTarget).parent()

            updatePriority(btn)
          }
        }
      )
  
  function updatePriority(li) {
    li.prevAll().addClass('active')
    li.addClass('active')
    li.nextAll().removeClass('active')
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