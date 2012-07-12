import groovyx.net.http.ContentType
import groovyx.net.http.ContentEncoding

beans = {
    asyncHttpBuilder(groovyx.net.http.AsyncHTTPBuilder, [
            poolSize: application.config.brandtology.api.poolsize,
            uri: application.config.brandtology.api.host,
            contentType: ContentType.TEXT]) {
        contentEncoding = ContentEncoding.Type.GZIP

    }

}
