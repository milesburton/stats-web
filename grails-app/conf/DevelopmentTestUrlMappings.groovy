import grails.util.Environment

class DevelopmentTestUrlMappings {

    static mappings = {

        if (["development","test"].contains(Environment.current.name)) {

            "/BANG"(view: '/errors/500')
        }

    }
}
