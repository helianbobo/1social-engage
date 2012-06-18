package one_social_ui

import javax.servlet.AsyncContext
import grails.converters.JSON

class SocialEngageController {


    def index() {redirect(action: 'posts')}


    def getPostDetails() {

    }


    def getAllPosts() {


    }

    def getAllCase() {

    }

    def createCase() {

    }

    def getCaseHistory() {

    }

    def closeCase() {

    }

    def post() {

    }

    def cases() {
        def currentSubModule = 'cases'

        [currentSubModule: currentSubModule]
    }

    def posts() {
        def currentSubModule = 'posts'

        [currentSubModule: currentSubModule]
    }


}
