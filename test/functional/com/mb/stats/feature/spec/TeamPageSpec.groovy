package com.mb.stats.feature.spec

import com.mb.stats.feature.fixture.TeamFixture
import com.mb.stats.feature.page.TeamPage
import com.mb.stats.feature.spec.base.ApiSpec

class TeamPageSpec extends ApiSpec {

    TeamFixture teamFixture = new TeamFixture()

    def 'user is shown team page'() {

        given:
        def team = buildTeamFixturesFor('0')

        when:
        to TeamPage, team.teamId

        then:
        at TeamPage

        and:
        titleContains(team.teamId.toString())
        navbar.hasCorrectHeading(team.alias)
        subnavbar.hasCorrectNumberOfLinks()
        subnavbar.isActive('Home')
        footer.isValidCopyright()

        and:
        hasCorrectHeadings(team)
    }

    def buildTeamFixturesFor(String teamId) {

        def team = teamFixture.forQuery(teamId)

        imposterRemote.reset()
        imposterRemote.configure(
                teamFixture.get(teamId),
                teamFixture.andRespondWith(team))

        team
    }
}
