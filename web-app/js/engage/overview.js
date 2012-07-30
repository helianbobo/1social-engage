;define(['engage', 'jquery-ui.datepicker', 'lib/highcharts/brandtology'], function(engage) {

  var DateRange = Backbone.Model.extend({
        set: function(name, value) {
          var set = Backbone.Model.prototype.set

          if (_.isObject(name)) {
            return set.apply(this, arguments)
          }

          function diff(a, b) {
            return Date.parse(a).getTime() - Date.parse(b).getTime()
          }

          if (name == 'toDate') {
            if (diff(value, this.get('fromDate')) > 0) {
              set.apply(this, arguments)
            } else {
              set.apply(this, [{fromDate: value, toDate : value}])
            }
          } else {
            if (diff(this.get('toDate'), value) > 0) {
              set.apply(this, arguments)
            } else {
              set.apply(this, [{ fromDate: value, toDate: value }])
            }
          }
        }
      })

    , Overview = Backbone.View.extend({
        initialize: function(options) {
          this.childs = {}

          this.tmpl = this.extractTemplate(this.$('.asset-item'))
          this.model.on('sync', this.render, this)
          if (this.model.length > 0) {
            this.render(this.model)
          }
        }

      , render: function(model) {
          var _t = this
            , tmpl = this.tmpl

          _.each(this.childs, function(it) { it.destroy() })

          model.map(function(asset) {
            var el = $(Mustache.render(tmpl, asset.toJSON()))

            _t.$('#facebook').append(el)
            
            var item = new OverviewItem({ el: el, model: asset})
            _t.childs[asset.id] = item
          })
        }
      })

    , OverviewItem = Backbone.View.extend({
        initialize: function(options) {
          var _t = this

          function format(date, offset) {
            if (offset) {
              date = new Date(date.getTime() + 1000* 60 * 60 * 24 * offset)
            }
            return date.toString('yyyy-MM-dd')
          }

          var range = this.range = new DateRange({
            fromDate: format(new Date(), -7)
          , toDate: format(new Date())
          })

          range.on('change', function(model, data) {
            _t.initDates(model.toJSON())
            _t.refresh()
          })

          this.initDates(range.toJSON())

          this.$el.find('.date-dropdown input').datepicker({
            dateFormat: 'yy-mm-dd'
          , changeMonth: true
          , maxDate: 0
          , numberOfMonths: 1
          , onSelect: function(txt, evt) {
              range.set($(evt.input).attr('name'), txt)
            }
          })

          this.$('.nav-tabs a').on('show', function(evt) {
            var target = $(evt.target).attr('href')

            _t.$('.toolbar')[target == '#case-breakdown' ? 'addClass' : 'removeClass']('hide')
            _t.refresh(target)
          })

          this.$el.delegate('.date-dropdown', 'click', function() {
            $(this).find('input').datepicker('show')
          })

          this.$('img').lazyload()

          this.refresh()
        }

      , initDates: function(range) {
          var el = this.$el
          _.each(range, function(it, name) { el.find('[name=' + name + ']').val(it) })
        }

      , refresh: function(target) {
          var _t = this
            , map = {
                '#read-stats': function() {
                  _t.fetchReadStats('Article', _t.$('.article-read .pie')[0])
                  _t.fetchReadStats('Comment', _t.$('.comment-read .pie')[0])
                }
              , '#case-stats': function() {
                  _t.fetchCaseStats('Article', _t.$('.article-case .pie')[0])
                  _t.fetchCaseStats('Comment', _t.$('.comment-case .pie')[0])
                }
              , '#case-breakdown': function() {
                  _t.fetchCaseBreakdown(_t.$('.case-breakdown .stack')[0])
                }
              }
          
          map[target || this.$('.active a').attr('href')]()
        }

      , fetchCaseBreakdown: function(ctn) {
          var assetId = this.model.id
          $.ajax({
            url: _.absolutePath($.contextPath, 'socialEngage/getCaseBreakDown')
          , data: {
              clientAccountId: 969
            , assetsId: assetId
            }
          , dataType: 'json'
          , success: function(data) {
              createStack(ctn, data)
            }
          })
        }

      , fetchCaseStats: function(postType, ctn) {
          var assetId = this.model.id
          $.ajax({
            url: _.absolutePath($.contextPath, 'socialEngage/getCaseStatus')
          , data: _.extend({
              postType: postType
            , clientAccountId: 969
            , assetsId: assetId
            }, this.range.toJSON())
          , dataType: 'json'
          , success: function(data) {
              createPie(ctn, data)
            }
          })
        }

      , fetchReadStats: function(postType, ctn) {
          var assetId = this.model.id
          $.ajax({
            url: _.absolutePath($.contextPath, 'socialEngage/getReadStatus')
          , data: _.extend({
              postType: postType
            , clientAccountId: 969
            , assetsId: assetId
            }, this.range.toJSON())
          , dataType: 'json'
          , success: function(data) {
              createPie(ctn, data)
            }
          })
        }

      , render: function(model) {
        }
      })

  function createPie(container, data) {
    return new Highcharts.Chart({
      chart: {
        renderTo: container,
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false
      },
      title: {
        text: ''
      },
      tooltip: {
        formatter: function() {
          return '<b>'+ this.point.name +'</b>: '+ this.y +'( '+Highcharts.numberFormat((this.percentage))+'%) '+'<br/>'+'Total: '+this.total;
        }
      },
      series: [{
        type: 'pie',
        data: data.data
      }]
    });
  }

  function createStack(container, data) {
    new Highcharts.Chart({
      chart: {
        renderTo: container,
        type: 'bar'
      },
      title: {
        text: ''
      },
      xAxis: {
        categories: data.categories
      },
      yAxis: {
        min: 0,
        title : ''
      },
      legend: {
        backgroundColor: '#FFFFFF',
        reversed: true
      },
      tooltip: {
        formatter: function() {
          return ''+
            this.series.name +': '+ this.y +'';
        }
      },
      plotOptions: {
        series: {
          stacking: 'normal'
        }
      },
        series: [{
        name: 'Reopen',
        data: data.caseReOpenArray
      }, {
        name: 'Closed',
        data: data.caseCloseArray
      }, {
        name: 'Responded',
        data: data.caseResponseArray
      }, {
        name: 'Open',
        data: data.caseOpenArray
      }]
    });
  }

  var assets = new engage.model.Assets()

    , templateListeners = {
        'engage-overview:one': function(el, placeholder) {
          new Overview({
            model: assets
          , el: el
          })
        }
      }


  // Page setup
  // -----
  $(document.body).ready(function() {
    //$(window).resize(updateListHeight)
    engage.showAjax()

    assets.fetch()
  
    tmplLoader.addListeners(templateListeners)
    tmplLoader.load($('#page'))
  })
})