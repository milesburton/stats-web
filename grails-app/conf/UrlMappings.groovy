class UrlMappings {

    static mappings = {


        "/"         (controller: 'teams', action: 'list')
        "404"       (view: '/errors/404')
    }
}
