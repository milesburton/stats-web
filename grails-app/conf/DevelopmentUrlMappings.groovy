import grails.util.Environment

class DevelopmentUrlMappings {

    static mappings = {

        if (["development"].contains(Environment.current.name)) {

            "500"                           (view: '/errors/RuntimeException')

            "/stub/api/teams"               (controller: 'stubApi', action: [ GET: 'teams' ])
            "/stub/api/teams/$teamId"       (controller: 'stubApi', action: [ GET: 'team' ])
        }

    }
}
