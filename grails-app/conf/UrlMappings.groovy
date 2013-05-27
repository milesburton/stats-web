class UrlMappings {

    static mappings = {

        name home: "/" {
            controller = 'teams'
            action = 'list'
        }

        name teamsList: "/teams" {
            controller = 'teams'
            action = 'list'
        }

        name teamDetails: "/teams/$teamId" {
            controller = 'teams'
            action = 'show'
        }

        "404"(view: '/errors/404')
    }
}
