requirejs.config({
  baseUrl: (CONTEXT_PATH || '') + '/js'
, paths: {
    jquery: 'lib/jquery-1.7.2.min'
  , underscore: 'lib/underscore-min'
  , backbone: 'lib/backbone'
  , mustache: 'lib/mustache'
  , 'jquery.lazyload': 'lib/jquery.lazyload'
  , 'jquery-ui': 'lib/jquery.ui.core'
  , 'jquery-ui.widget': 'lib/jquery.ui.widget'
  , 'jquery-ui.datepicker': 'lib/jquery.ui.datepicker'
  , 'bootstrap.dropdown': 'lib/bootstrap-dropdown'
  , 'bootstrap.modal': 'lib/bootstrap-modal'
  , 'bootstrap.popover': 'lib/bootstrap-popover'
  , 'bootstrap.tab': 'lib/bootstrap-tab'
  , 'bootstrap.tooltip': 'lib/bootstrap-tooltip'
  , 'highcharts': 'lib/highcharts/2.2.5/highcharts'
  , 'highcharts-more': 'lib/highcharts/2.2.5/highcharts-more'
  , 'highcharts-exporting': 'lib/highcharts/2.2.5/modules/exporting.src'
  , 'highcharts-theme': 'lib/highcharts/theme-brandtology'
  }
, shim: {
    backbone: {
      deps: ['jquery', 'underscore']
    , exports: 'Backbone'
    }
  , 'jquery.lazyload': ['jquery']
  , 'jquery-ui': ['jquery']
  , 'jquery-ui.widget': ['jquery-ui']
  , 'jquery-ui.datepicker': ['jquery-ui.widget']
  , 'bootstrap.dropdown': ['jquery']
  , 'bootstrap.modal': ['jquery']
  , 'bootstrap.popover': ['bootstrap.tooltip']
  , 'bootstrap.tab': ['jquery']
  , 'bootstrap.tooltip': ['jquery']
  , 'highcharts-more': ['highcharts']
  , 'highcharts-exporting': ['highcharts-more']
  , 'highcharts-theme': ['highcharts-more']
  }
})