package com.brandtology

import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class BrandtologyApiService{

    def asyncHttpBuilder
    def grailsApplication

    def sendRequest(path, data, callback) {

        sendRequest(path, data, callback, groovyx.net.http.Method.GET)

    }

    def sendRequest(path, data, callback, method) {

        def start = System.currentTimeMillis()

        if(log.debugEnabled){
            if(path.indexOf('login') < 0)
                log.debug("sending request to " + "\n\t[path:$path]\n\t[data:$data]\n\t[method:$method]")
            else
                log.debug("sending request to " + "\n\t[path:$path]\n\t[data:******]\n\t[method:$method]")
        }

        try {

            Future future

            if(method == groovyx.net.http.Method.GET){
                future = asyncHttpBuilder.request( method ) {
                    uri.path = path
                    uri.query = data
                    response.success = callback
                }
            }else{
                future = asyncHttpBuilder.post(path:path,body:data, callback)
            }


            def timeout = grailsApplication.config.brandtology.api.request.timeout
            def result = future.get(timeout, TimeUnit.SECONDS)

            if(log.debugEnabled)
                log.debug("got response within ${System.currentTimeMillis() - start} ms")

            return result
        } catch (e) {
            log.error(" got error:${e.message}", e)
            throw e
        }

    }

    def passThroughInvoke(url, data) {
        passThroughInvoke(url, data, 'GET')
    }
    def passThroughInvokePost(url, data) {
        passThroughInvoke(url, data, 'POST')
    }

    def passThroughInvoke(url, data, method){

        return sendRequest(url, data, { resp, json ->
            return json.getText()
        }, groovyx.net.http.Method."$method")
    }

}