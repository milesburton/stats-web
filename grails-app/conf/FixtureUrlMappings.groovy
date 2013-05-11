import grails.util.GrailsUtil

class FixtureUrlMappings {

    static mappings = {

        if (["test", "development"].contains(GrailsUtil.getEnvironment())) {


        }
    }
}
