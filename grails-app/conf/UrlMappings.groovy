class UrlMappings {

    static mappings = {

        "/socialEngage/case/$caseId"(controller: 'socialEngage', action: 'getCaseById')


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
