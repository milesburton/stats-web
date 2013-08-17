package com.mb.stats.feature.spec

import com.mb.stats.feature.fixture.TeamFixture
import com.mb.stats.feature.fixture.TeamHistoryFixture
import com.mb.stats.feature.page.TeamPage
import com.mb.stats.feature.spec.base.ApiSpec

import static com.test.QueryStringHelper.asQueryString

class TeamPageSpec extends ApiSpec {

    TeamFixture teamFixture = new TeamFixture()
    TeamHistoryFixture teamHistoryFixture = new TeamHistoryFixture()

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

    def 'highcharts expects history of daily point peaks'() {

        given:
        def teamId = 62
        def timestampBegin = 0
        def timestampEnd = 10

        and:
        def history = buildTeamHistoryFixturesFor(teamId, timestampBegin, timestampEnd)
        def expectedResponse = [series: [[name: "Points", data: history.results.collect { [ it.timestamp, it.ptsTotal] }.sort { it[0]}, type: "area"]]]

        when:
        def response = jsonClient.get("teams/${teamId}/history?" + asQueryString([timestampBegin: timestampBegin, timestampEnd: timestampEnd])).bodyAsJsonMap

        and:
        response.series[0].data = response.series[0].data.collect {
            it*.toLong()
        }


        then:
        response == expectedResponse

    }

    def buildTeamFixturesFor(String teamId) {

        def team = teamFixture.forQuery(teamId)

        imposterRemote.reset()
        imposterRemote.configure(
                teamFixture.get(teamId),
                teamFixture.andRespondWith(team))

        team
    }

    def buildTeamHistoryFixturesFor(Long teamId, Long timestampBegin, Long timestampEnd) {

        def history = teamHistoryFixture.forQuery(teamId, timestampBegin, timestampEnd)

        imposterRemote.reset()
        imposterRemote.configure(
                teamHistoryFixture.get(teamId, timestampBegin, timestampEnd),
                teamHistoryFixture.andRespondWith(history))

        history

    }
}
