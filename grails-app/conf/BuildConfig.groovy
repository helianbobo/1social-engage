grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
//        mavenCentral()
//        mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "http://oss.sonatype.org/content/groups/signpost/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'
        runtime 'org.codehaus.groovy.modules.http-builder:http-builder:0.5.2'
//        runtime 'oauth.signpost:signpost-core:1.1'
//        runtime 'commons-httpclient:commons-httpclient:3.1'

        runtime 'redis.clients:jedis:2.1.0'


        //Export PPT
        runtime('org.apache.poi:poi-ooxml:3.8','org.apache.poi:poi-excelant:3.8','org.apache.poi:poi-scratchpad:3.8'){
            excludes ([group:'org.apache.xmlbeans', name:'xmlbeans'])
        }

        runtime 'batik:batik-xml:1.6'
        runtime 'batik:batik-transcoder:1.6'
        runtime 'batik:batik-util:1.6'
        runtime 'batik:batik-svggen:1.6'
        runtime 'batik:batik-svg-dom:1.6'
        runtime 'batik:batik-dom:1.6'
        runtime 'batik:batik-slideshow:1.6'



        runtime 'com.google.code.gson:gson:1.4'
        runtime 'rhino:js:1.7R2'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"

        runtime ":redis:1.3"
    }
}
