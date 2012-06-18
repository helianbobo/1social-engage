class UrlMappings {

    static mappings = {


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

        "/"(controller: 'socialAnalytics', action: 'index')
        "/sandbox"(view: "/sandbox")
        "500"(view: '/error')
    }
}
