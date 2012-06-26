modules = {
    application {
        //resource url: 'js/application.js'
    }

    backbone {
        dependsOn 'jquery, underscore'

        resource id: 'backbone', url: 'js/backbone.js'
    }

    underscore {
        resource id: 'underscore', url: 'js/underscore-min.js', exclude:'minify'
    }

    requirejs{
        //resource url: 'v1/js/require.min.js'
        //resource url: 'v1/js/text.js'
    }

    jsViews {
        dependsOn "jquery"

        //resource url: 'js/jsrender.js'
        //resource url: 'js/jquery.observable.js'
        //resource url: 'js/jquery.views.js'
    }

    preloader {
        //resource url: 'v1/js/preloader.js'
    }

    highcharts {
        //resource url: 'js/highchart/2.2.5/highcharts.js'
        //resource url: 'js/highchart/2.2.5/highcharts-more.js'
        //resource url: 'js/highchart/2.2.5/modules/exporting.src.js'
        //resource url: 'js/highcharts_theme_brandtology.js'
        //resource url: 'js/highchart/brandtology.js'
    }

    brandtology_v1 {
        dependsOn 'jquery, jsViews, preloader, highcharts' // , jquery-ui

        //resource url: 'v1/js/ajax.js'
        //resource url: 'js/json2.js'

		//resource url: 'js/jquery.treeview.js'
        //resource url: 'js/jquery.ui.core.js'
        //resource url: 'js/jquery.ui.widget.js'
        //resource url: 'js/jquery.ui.tabs.js'

		//resource url: 'css/accordion.css'
        //resource url: 'css/redmond/jquery-ui-1.7.1.custom.css'
        //resource url: 'css/jquery.treeview.css'

        //resource url: 'v1/css/fontface.less', attrs: [rel: "stylesheet/less", type: 'css']
        //resource url: 'v1/css/layout.less', attrs: [rel: "stylesheet/less", type: 'css']

        //resource url: 'v1/js/helper.js'
        //resource url: 'v1/js/layout.js'
        //resource url: 'v1/js/date.js'
        
        //resource url: 'v1/js/jquery.uniform.min.js'
        //resource url: 'v1/css/uniform.default.css'
        
        //resource url: 'v1/js/jquery.tipTip.minified.js'
        //resource url: 'v1/css/tipTip.css'
    }

    engage {
        dependsOn 'backbone'
        //TODO: new social engage resources

        resource url: 'less/engage.less', attrs: [rel: "stylesheet/less", type: 'css']//, bundle: 'bundle_ui'

        resource url: 'js/bootstrap-dropdown.js'
        resource url: 'js/bootstrap-tab.js'
        resource url: 'js/bootstrap-modal.js'
        resource url: 'js/mustache.js'
        resource url: 'js/jquery.lazyload.js'
        resource url: 'js/jquery-x.js'
        //resource url: 'engage/js/engage.js'
        //resource url: 'engage/css/engage.css'
    }

    'engage-post' {
        dependsOn 'engage'
        
        resource url: 'less/app-posts.less', attrs: [rel: "stylesheet/less", type: 'css']

        resource url: 'js/engage/posts.js'
    }

    'engage-case' {
        dependsOn 'engage'

        resource url: 'less/app-case.less', attrs: [rel: "stylesheet/less", type: 'css']

        resource url: 'js/engage/case.js'
    }


}
