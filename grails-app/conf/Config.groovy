// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

grails.config.locations = [ "classpath:${appName}-config.properties",
                             "classpath:${appName}-config.groovy",
                             "file:${userHome}/${appName}-config.properties",
                             "file:${userHome}/${appName}-config.groovy"]

if (System.properties["${appName}.config.location"]) {
    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
}


grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [html: ['text/html', 'application/xhtml+xml'],
        xml: ['text/xml', 'application/xml'],
        text: 'text/plain',
        js: 'text/javascript',
        rss: 'application/rss+xml',
        atom: 'application/atom+xml',
        css: 'text/css',
        csv: 'text/csv',
        all: '*/*',
        json: ['application/json', 'text/json'],
        form: 'application/x-www-form-urlencoded',
        multipartForm: 'multipart/form-data'
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart = false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// enable query caching by default
grails.hibernate.cache.queries = true


brandtology.api.poolsize = 50
brandtology.api.request.timeout = 600

// set per-environment serverURL stem for creating absolute links
environments {

    development {
        grails.logging.jul.usebridge = true
       // brandtology.api.host = "http://192.168.52.152:8080/1-Social_API/"
          brandtology.api.host = "http://192.168.4.15:80/1-Social_API/"
//        brandtology.api.host = "http://192.168.1.135:8080/1-Social_API/"
    }
    production {
        grails.logging.jul.usebridge = false
        brandtology.api.host = "http://192.168.4.11:8080/1-Social_API/"
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    appenders {
        console name:'stdout', layout:pattern(conversionPattern: '[%d{dd MMM yyyy HH:mm:ss,SSS}] [%t] [%p] [%c{5}] %m%n')
    }

    /*appenders {
        rollingFile name: "stacktrace", maxFileSize: 1024,
                file: "/var/tmp/logs/1-social-ui-stacktrace.log"
    }*/

    debug 'com.brandtology',
          'grails.app.services.com.brandtology',
          'grails.app.controllers.com.brandtology',
          'org.apache.http.headers'


    error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
            'org.codehaus.groovy.grails.web.pages', //  GSP
            'org.codehaus.groovy.grails.web.sitemesh', //  layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping', // URL mapping
            'org.codehaus.groovy.grails.commons', // core / classloading
            'org.codehaus.groovy.grails.plugins', // plugins
            'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'
}



// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'com.brandtology.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'com.brandtology.UserRole'
grails.plugins.springsecurity.authority.className = 'com.brandtology.Role'

grails.plugins.springsecurity.providerNames = [
        'brandtologyApiAuthenticationProvider',
//        'fakeAuthenticationProvider',
        'anonymousAuthenticationProvider',
        'rememberMeAuthenticationProvider']

grails.plugins.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugins.springsecurity.interceptUrlMap = [
        '/**': ['IS_AUTHENTICATED_ANONYMOUSLY']
]

//grails.plugins.springsecurity.useSessionFixationPrevention = true
grails.plugins.springsecurity.successHandler.defaultTargetUrl = '/login/ajaxSuccess'
grails.plugins.springsecurity.successHandler.alwaysUseDefault = true


//Oauth

brandtology.oauth.sinaWeibo.requestTokenEndpointUrl="http://api.t.sina.com.cn/oauth/request_token"
brandtology.oauth.sinaWeibo.accessTokenEndpointUrl="http://api.t.sina.com.cn/oauth/access_token"
brandtology.oauth.sinaWeibo.authorizationWebsiteUrl="http://api.t.sina.com.cn/oauth/authorize"
brandtology.oauth.sinaWeibo.verifyCredentials="http://api.t.sina.com.cn/account/verify_credentials.json"
brandtology.oauth.sinaWeibo.callbackUrl="http://localhost:8080/One_Social_UI/socialAssets/sinaWeiboCallback"

brandtology.oauth.facebook.callbackUrl="http://127.0.0.1:8080/One_Social_UI/SocialAssets/facebookCallback"


//file image upload
brandtology.image.folder="/opt/image/"

//cache
springcache {
    defaults {
        // set default cache properties that will apply to all caches that do not override them
        eternal = false
        diskPersistent = false
    }
    caches {
        passthroughCache {
            timeToLive = 60*5
        }

        getClientListCache {
            timeToLive = 0
        }

        getDefaultDetailsCache {
            timeToLive = 0
        }

        getAssetsAllProfileCache {
            timeToLive = 1800
        }

    }
}


grails{
    redis {
        poolConfig {
            // jedis pool specific tweaks here, see jedis docs & src
            // ex: testWhileIdle = true
        }
        port = 6379
        host = "192.168.4.16"
        timeout = 2000 //default in milliseconds
//    password = "somepassword" //defaults to no password


    }
}