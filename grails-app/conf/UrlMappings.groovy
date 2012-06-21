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

        "/"(view: 'index')
        "/sandbox"(view: "/sandbox")
        "500"(view: '/error')
    }
}
