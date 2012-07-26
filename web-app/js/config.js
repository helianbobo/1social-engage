requirejs.config({
  baseUrl: (CONTEXT_PATH || '') + '/js'
, paths: {
    jquery: 'lib/jquery-1.7.2.min'
  , underscore: 'lib/underscore-min'
  , backbone: 'lib/backbone'
  , mustache: 'lib/mustache'
  , 'jquery.lazyload': 'lib/jquery.lazyload'
  , 'jquery.uniform': 'lib/jquery.uniform.min'
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
  , 'bootstrap.dropdown': ['jquery']
  , 'bootstrap.modal': ['jquery']
  , 'bootstrap.tab': ['jquery']
  }
})