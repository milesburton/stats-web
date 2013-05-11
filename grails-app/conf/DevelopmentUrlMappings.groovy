import grails.util.Environment

class DevelopmentUrlMappings {

    static mappings = {

        if (["production"].contains(Environment.current.name)) {

            "500"(view: '/errors/RuntimeException')
        }

    }
}
