requirejs.config({
  baseUrl: (CONTEXT_PATH || '') + '/js'
, paths: {
    jquery: 'lib/jquery-1.7.2.min'
  , underscore: 'lib/underscore-min'
  , backbone: 'lib/backbone'
  , jsrender: 'lib/jsrender'
  , mustache: 'lib/mustache'
  , 'jquery.lazyload': 'lib/jquery.lazyload'
  , 'jquery.observable': 'lib/jquery.observable'
  , 'jquery.uniform': 'lib/jquery.uniform.min'
  , 'jquery.views': 'lib/jquery.views'
  , 'bootstrap.dropdown': 'lib/bootstrap-dropdown'
  , 'bootstrap.modal': 'lib/bootstrap-modal'
  , 'bootstrap.tab': 'lib/bootstrap-tab'
  }
, shim: {
    backbone: {
      deps: ['jquery', 'underscore']
    , exports: 'Backbone'
    }
  , 'jquery.lazyload': ['jquery']
  , 'jquery.uniform': ['jquery']
  , 'jquery.views': ['jquery', 'jsrender', 'jquery.observable']
  , 'bootstrap.dropdown': ['jquery']
  , 'bootstrap.modal': ['jquery']
  , 'bootstrap.tab': ['jquery']
  }
})