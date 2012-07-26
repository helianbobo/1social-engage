modules = {
    application {
        //resource url: 'js/application.js'
    }

    requirejs {
        resource url: 'js/lib/require.js'
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


        //resource url: 'v1/css/fontface.less', attrs: [rel: "stylesheet/less", type: 'css']
        //resource url: 'v1/css/layout.less', attrs: [rel: "stylesheet/less", type: 'css']

        //resource url: 'v1/js/helper.js'
        //resource url: 'v1/js/layout.js'
        //resource url: 'v1/js/date.js'
        
        //resource url: 'v1/js/jquery.uniform.min.js'
        
        //resource url: 'v1/js/jquery.tipTip.minified.js'
        //resource url: 'v1/css/tipTip.css'
    }

    analytics {
        dependsOn 'requirejs'

        resource url: 'less/social-analytics.less', attrs: [rel: "stylesheet/less", type: 'css']
        resource url: 'css/redmond/jquery-ui-1.7.1.custom.css'
        resource url: 'css/accordion.css'
        resource url: 'css/jquery.treeview.css'
        resource url: 'css/uniform.default.css'

        resource url: 'js/config.js'
    }

    engage {
        dependsOn 'requirejs'

        resource url: 'less/engage.less', attrs: [rel: "stylesheet/less", type: 'css']

        resource url: 'js/config.js'
    }

    'engage-posts' {
        dependsOn 'engage'
        
        resource url: 'less/app-posts.less', attrs: [rel: "stylesheet/less", type: 'css']
    }

    'engage-case' {
        dependsOn 'engage'

        resource url: 'less/app-case.less', attrs: [rel: "stylesheet/less", type: 'css']
    }

    'engage-cases' {
        dependsOn 'engage'

        resource url: 'less/app-cases.less', attrs: [rel: "stylesheet/less", type: 'css']
    }

}
