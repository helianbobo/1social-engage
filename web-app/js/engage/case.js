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
        var id = options.parent.model.get('id')
          , conversation = new engage.model.Conversation({ id : id })

        this.tmpl = extractTemplate(this.$('.conversation-inner').children())
        this.model = conversation
        conversation.on('change', this.render, this)
        conversation.fetch()
      }

    , render: function(model, data) {
        this.$('.conversation-inner').html(
            Mustache.render(this.tmpl, model.toJSON())
          )
      }
    }
  )

  var CaseForm = CaseApp.CaseForm = Backbone.View.extend(
    {
      initialize: function(options) {
        if (!options.parent.model.get('caseCreated')) {
          this.$('.edit-case').addClass('hide')
          new CreateCase({ el: this.$('[name=create-case]'), parent: this })
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
        this.tmpl = extractTemplate(this.$el.children())
        this.model = options.parent.model
        this.render()
      }

    , render: function() {
        this.$el.html(Mustache.render(this.tmpl, this.model.toJSON()));
        this.$('img').lazyload({ effect: "fadeIn" })
      }
    }
  )

  var CreateCase = Backbone.View.extend(
        {
          initialize: function(options) {
            //options.parent.model.get('caseCreated')
            this.priority = 3
          }

        , events: {
            'click .prioritys a': 'setPriority'
          , 'mouseenter .prioritys a': 'showPriority'
          , 'mouseleave .prioritys a': 'resetPriority'
          }

        , resetPriority: function(evt) {
            this.updatePriority(this.$('.prioritys li:nth-child(' + this.priority + ')'))
          }

        , setPriority: function(evt) {
            var btn = $(evt.currentTarget).parent()

            this.updatePriority(btn)

            this.priority = btn.parent().find('.active').length
          }

        , showPriority: function(evt) {
            var btn = $(evt.currentTarget).parent()

            this.updatePriority(btn)
          }

        , updatePriority: function(li) {
            li.prevAll().addClass('active')
            li.addClass('active')
            li.nextAll().removeClass('active')
          }
        }
      )

  _.extend(CaseForm
  , {
      'CreateCase': CreateCase
    }
  )

  function extractTemplate(el) {
    return $('<div></div>').append(el).html()
  }
})()