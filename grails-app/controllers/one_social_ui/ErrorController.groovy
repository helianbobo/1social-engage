package one_social_ui

import java.util.concurrent.TimeoutException

class ErrorController {

    def restJson() {

        def status = 500
        def code
        def json

        Exception exception = request.exception
        if (exception.cause instanceof TimeoutException) {
            code = 408
            json = """{"code":${code}, "message":"${message(code: 'brandtology.error.timeout')}"}"""
        } else {
            code = 500
            log.error(exception.message, exception)
            json = """{"code":${code}, "message":"${exception.message}"}"""
        }

        response.status = status
        render json

    }
}
