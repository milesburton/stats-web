package com.mb.stats.feature.spec

import com.mb.stats.feature.fixture.TeamFixture
import com.mb.stats.feature.page.TeamsPage
import com.mb.stats.feature.spec.base.ApiSpec

class TeamsPageSpec extends ApiSpec {

    TeamFixture teamFixture = new TeamFixture()

    def 'user is shown teams page'() {

        given:
        def query = [offset: 0, limit: 50, sort: 'ptsTotal', order: 'desc']
        def teamsList = teamFixture.forQuery(query)

        and:
        imposterRemote.configure(
                teamFixture.get(query),
                teamFixture.andRespondWith(teamsList))

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
}