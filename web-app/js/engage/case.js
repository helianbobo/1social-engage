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
        var comments = options.parent.model.get('comments');
        var commentId = comments?comments[0].fbId:0;
        var id = options.parent.model.get('id')
          , conversation = new engage.model.Conversation({ id:id, articleId : id, commentId:commentId })

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

  var CaseForm = CaseApp.CaseForm = Backbone.View.extend(
    {
      initialize: function(options) {
        var _t = this
          , model = this.model = new engage.model.Case()
          , post = options.parent.model

        model.set(
          {
            'articleId': post.get('fbId')
          , 'type': 'facebook'
          }
        )
        if (post.get('comment').length > 0) {
          model.set('commentId', post.get('comment')[0].fbId)
        }

        function createChild(className, selector) {
          return new CaseForm[className]({ el: _t.$(selector), model: model, parent: _t })
        }

        this.childs = {
          'add-response': createChild('AddResponse', '.reponse-wrap')
        , 'add-memo': createChild('AddMemo', '.memo-wrap')
        }
        
        if (!options.parent.model.get('caseCreated')) {
          this.$('.edit-case').addClass('hide')
          this.childs['create-case'] = createChild('CreateCase', '[name=create-case]')
          this.$('.create-case a').click()
        } else {
          this.$('.create-case').addClass('hide')
          model.set('id', post.get('caseId'))
          this.childs['edit-case'] = createChild('EditCase', '[name=edit-case]')
          this.$('.edit-case a').append('<span>' + model.get('id') + '</span>').click()
        }
      }
    }
  )

  CaseApp.CaseHistory = Backbone.View.extend(
    {
      initialize: function(options) {
        engage.repeat(this.$('ul'), 50)
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
          display: function(visiable) {
            if (visiable) this.$el.removeClass('hide')
            else this.$el.addClass('hide')
          }
        }
      )

    , AddResponse = Backbone.View.extend(
        {
          display: function(visiable) {
            if (visiable) this.$el.removeClass('hide')
            else this.$el.addClass('hide')
          }
        }
      )

    , CreateCase = Backbone.View.extend(
        {
          initialize: function(options) {
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
            this.model.set('name', this.$('[name=case-name]').val())
            this.model.save(null, { url : joinPath($.contextPath, 'socialEngage/createCase') })
          }

        , displayPanel: function(evt) {
            var btn = $(evt.currentTarget)
              , btns = this.$('.add-action')
              , active = btn.hasClass('btn-active')
              , childs = this.options.parent.childs

            btns.removeClass('btn-active')
            if (!active) btn.addClass('btn-active')

            btns.each(function(i, it) {
              var el = $(it)

              childs[el.attr('data-panel')].display(el.hasClass('btn-active'))
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
            this.changeMode('read')
            this.model.on('sync', this.render, this)
            this.model.fetch()
          }

        , events: {
            'click .btn-edit-case': 'changeMode'
          , 'click .btn-cancel': 'changeMode'
          , 'click .prioritys a': 'setPriority'
          , 'mouseenter .prioritys a': 'showPriority'
          , 'mouseleave .prioritys a': 'resetPriority'
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

            if (editable) {
              this.oldModel = this.model
              this.model = new engage.model.Case(this.model.toJSON())
              this.$('.case-name').addClass('hide')
              this.$('[name=case-name]').removeClass('hide')

              this.$('.form-actions').removeClass('hide')
            } else {
              if (this.oldModel) this.model = this.oldModel
              delete this.oldModel
              this.$('.case-name').removeClass('hide')
              this.$('[name=case-name]').addClass('hide')

              this.$('.form-actions').addClass('hide')

              this.render(this.model)
            }
            this.editable = editable
            if (btn) btn.toggleClass('btn-active')
          }

        , render: function(model) {
            this.$('.case-name').html(model.get('caseName'))
            this.$('[name=case-name]').val(model.get('caseName'))

            this.$('.case-status').html(model.get('statusText'))

            this.resetPriority()
          }

        , resetPriority: function(evt) {
            if (!this.editable && evt) return;

            updatePriority(
              this.$('.prioritys li:nth-child(' + this.model.get('priority') + ')')
            )
          }

        , setPriority: function(evt) {
            if (!this.editable) return;

            var btn = $(evt.currentTarget).parent()

            updatePriority(btn)

            this.model.set('priority', btn.parent().find('.active').length)
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
  
  _.extend(CaseForm
  , {
      'AddMemo': AddMemo
    , 'AddResponse': AddResponse
    , 'CreateCase': CreateCase
    , 'EditCase': EditCase
    }
  )
})()