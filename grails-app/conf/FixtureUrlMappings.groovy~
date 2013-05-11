import grails.util.GrailsUtil

class FixtureUrlMappings {

    static mappings = {

        if (["test", "development"].contains(GrailsUtil.getEnvironment())) {

            '/fixture/teams'(controller: 'TeamFixture', action: 'create')
            '/fixture/teams/custom'(controller: 'TeamFixture', action: 'custom')

            '/fixture/users'(controller: 'UsersFixture', action: 'create')
            '/fixture/users/custom'(controller: 'UsersFixture', action: 'custom')

            '/fixture/users/history'(controller: 'UserHistoryFixture', action: 'create')

            '/fixture/teams/history'(controller: 'TeamHistoryFixture', action: 'create')

        }
    }
}
