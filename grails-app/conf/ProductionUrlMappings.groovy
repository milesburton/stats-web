import grails.util.Environment

class ProductionUrlMappings {

    static mappings = {

        if (["production"].contains(Environment.current.name)) {

            "500"   (view: '/errors/500')
        }

    }
}
