class UrlMappings {

    static mappings = {


        "/"                 (controller: 'teams', action: 'list')
        "/teams"            (controller: 'teams', action: 'list')
        "404"               (view: '/errors/404')
    }
}
