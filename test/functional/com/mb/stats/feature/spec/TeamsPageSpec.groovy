package com.mb.stats.feature.spec

import com.mb.stats.feature.fixture.TeamFixture
import com.mb.stats.feature.page.TeamsPage
import com.mb.stats.feature.spec.base.ApiSpec
import spock.lang.Unroll

class TeamsPageSpec extends ApiSpec {

    TeamFixture teamFixture = new TeamFixture()

    def defaultQuery = [offset: 0, limit: 50, sort: 'rank', order: 'desc']

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

        and: 'validate pagination'
        teams.pagination.pages.size() == 8
        teams.pagination.pages*.text() == ["1", "2", "3", "4", "5", "..", "20", "Forward"]
        !teams.pagination.prevLink.displayed
        teams.pagination.nextLink.displayed

    }

    @Unroll
    def "user can sort table by #requestedSort"() {

        given:
        def initialQuery = [offset: 0, limit: 50, sort: 'rank', order: 'desc']
        buildTeamFixturesFor(initialQuery)

        when:
        to TeamsPage, initialQuery

        then:
        at TeamsPage

        when:
        def teamsList = buildTeamFixturesFor(offset: 0, limit: 50, sort: requestedSort, order: 'desc')

        and:
        teams."${requestedSort}".click()

        then:
        teams.rows.size() == teamsList.results.size()
        teams.containsTeams(teamsList.results)

        where:
        requestedSort << [
                'teamId',
                'alias',
                'ptsDelta',
                'ptsDay',
                'ptsWeek',
                'ptsTotal',
                'wuTotal',
        ]
    }

    @Unroll
    def "user can order table by #requestedSort"() {

        given:
        def initialQuery = [offset: 0, limit: 50, sort: requestedSort, order: 'desc']
        buildTeamFixturesFor(initialQuery)

        when:
        to TeamsPage, initialQuery

        then:
        at TeamsPage

        when:
        def teamsList = buildTeamFixturesFor(offset: 0, limit: 50, sort: requestedSort, order: 'asc')

        and:
        teams."${requestedSort}".click()

        then:
        teams.rows.size() == teamsList.results.size()
        teams.containsTeams(teamsList.results)

        where:
        requestedSort << [
                'rank',
                'teamId',
                'alias',
                'ptsDelta',
                'ptsDay',
                'ptsWeek',
                'ptsTotal',
                'wuTotal',
        ]
    }

    @Unroll
    def "user can paginate through pages"() {

        given:
        buildTeamFixturesFor(defaultQuery)

        when:
        to TeamsPage

        then:
        at TeamsPage

        and:
        teams.pagination.activePage.text() == '1'

        when:
        buildTeamFixturesFor([offset: 50, limit: 50, sort: 'rank', order: 'desc'])

        and:
        teams.pagination.nextLink.click()

        then:
        teams.pagination.activePage.text() == '2'


        when:
        buildTeamFixturesFor(defaultQuery)

        and:
        teams.pagination.prevLink.click()

        then:
        teams.pagination.activePage.text() == '1'
    }


    def buildTeamFixturesFor(Map query) {

        def teamsList = teamFixture.forQuery(query)

        imposterRemote.reset()
        imposterRemote.configure(
                teamFixture.get(query),
                teamFixture.andRespondWith(teamsList))

        teamsList
    }
}