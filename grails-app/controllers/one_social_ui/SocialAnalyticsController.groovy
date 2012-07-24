package one_social_ui

import javax.servlet.AsyncContext

import grails.converters.JSON
import net.sf.json.JSONObject

class SocialAnalyticsController {

    def brandtologyApiService

    def index() { redirect(action: 'overview', params: params) }

    def overview() {

        def currentSubModule = 'overview'

        if (params.version) {
            render(view: "overview_${params.version}", model: [currentSubModule: currentSubModule])
        } else {
            render(view: 'overview', model: [currentSubModule: currentSubModule])
        }

    }

    def buzz() {
        def currentSubModule = 'buzz'

        [currentSubModule: currentSubModule]
    }

    def sentiment() {
        def currentSubModule = 'sentiment'

        [currentSubModule: currentSubModule]

    }

    def growth() {
        def currentSubModule = 'growth'

        [currentSubModule: currentSubModule]

    }

    def channels() {
        def currentSubModule = 'channels'

        [currentSubModule: currentSubModule]

    }

}
