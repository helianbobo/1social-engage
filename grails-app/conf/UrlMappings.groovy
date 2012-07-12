class UrlMappings {

    static mappings = {

        "/socialEngage/posts"(controller: 'socialEngage', action: 'posts')
        "/socialEngage/cases"(controller: 'socialEngage', action: 'cases')
        "/socialEngage/getCaseHistory"(controller: 'socialEngage', action: 'getCaseHistory')
        "/socialEngage/case/$caseId"(controller: 'socialEngage') {
            action = [GET: 'getCaseByIdReal', PUT: 'updateCaseReal', DELETE: 'closeCaseReal', POST: 'createCaseReal']
//            action = [GET: 'getCaseById', PUT: 'updateCase', DELETE: 'closeCase', POST: 'createCase']
        }
        "/socialEngage/$remoteAction"(controller: 'socialEngage', action: 'passThrough')


        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/$version/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: 'index')
        "/sandbox"(view: "/sandbox")
        "500"(view: '/error')
    }
}
