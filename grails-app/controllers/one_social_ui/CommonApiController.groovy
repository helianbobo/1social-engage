package one_social_ui

import javax.servlet.AsyncContext

import grails.converters.JSON

class CommonApiController {



    def getCurrentUserData() {

        render '''{
    "isClientAdmin":0,
    "username":"Chao Liu",
    "accessRights":["ROLE_ENGAGE_READ", "ROLE_ENGAGE_WRITE"],
    "clientAccountId":null,
    "profilePicture":"371902_1138236818_1870452111_n.jpg",
    "userid":771,
    "emailAddress":"chao.liu@brandtology.com",
    "isClientAgent":0,
    "isClientTeamlead":0,
    "isClient":0,
    "from_date":"2012-06-10",
    "to_date":"2012-06-16",
    "grouping":"topic",
    "scope":"6709,6708",
    "channel_language":"en_US",
    "clientDateEnd":"2012-05-26",
    "countryList":["SG"],
    "clientName":"Brandtology R&D",
    "languageList":["en_US"],
    "dateEnd":"2012-06-16",
    "dateStart":"2012-06-10",
    "type":"DEMO",
    "clientId":969,
    "clientDateStart":"2012-04-26",
    "client_details": []
}
'''
    }


}
