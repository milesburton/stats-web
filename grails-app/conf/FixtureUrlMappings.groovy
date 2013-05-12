import grails.util.Environment

class FixtureUrlMappings {

    static mappings = {

        if (["test", "development"].contains(Environment.current.name)) {

            "/fixture/api/team"  (controller: 'fakeTeamApiEndPoint', action: 'list')
        }
    }
}
