package com.mb.stats.feature.spec

import com.mb.stats.feature.fixture.TeamFixture
import com.mb.stats.feature.page.TeamsPage
import com.mb.stats.feature.spec.base.ApiSpec

class TeamsPageSpec extends ApiSpec {

    TeamFixture teamFixture = new TeamFixture()

    def defaultQuery = [offset: 0, limit: 50, sort: 'ptsTotal', order: 'desc']

    def 'user is shown teams page'() {

        given:
        def teamsList = buildTeamFixturesFor(defaultQuery)

        when:
        to TeamsPage

        then:
        at TeamsPage

        and:
        navbar.hasCorrectHeading()
        subnavbar.hasCorrectNumberOfLinks()
        subnavbar.isActive('Home')
        footer.isValidCopyright()

        and:
        teams.title == 'Teams'
        teams.rows.size() == teamsList.results.size()
        teams.hasCorrectHeadings()
        teams.rows*.hasCorrectColumns()
        teams.containsTeams(teamsList.results)
    }

    def 'user can sort table by alias'() {

        given:
        buildTeamFixturesFor(defaultQuery)

        and:
        to TeamsPage
        at TeamsPage

        when:
        def teamsList = buildTeamFixturesFor(offset: 0, limit: 50, sort: 'alias', order: 'desc')

        and:
        teams.alias.click()

        then:
        teams.rows.size() == teamsList.results.size()
        teams.containsTeams(teamsList.results)
    }

    def buildTeamFixturesFor(Map query){

        def teamsList = teamFixture.forQuery(query)

        imposterRemote.configure(
                teamFixture.get(query),
                teamFixture.andRespondWith(teamsList))

        teamsList
    }
}