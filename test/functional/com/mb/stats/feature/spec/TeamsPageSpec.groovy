package com.mb.stats.feature.spec

import com.mb.stats.feature.page.TeamsPage
import geb.spock.GebSpec

class TeamsPageSpec extends GebSpec {

    def 'user is shown teams page'() {

        given:
        def teamsList = [total: 2, results:
                [
                        [
                                "teamId": 0,
                                "alias": "Default (includes all those WU returned without valid team number)",
                                "ptsTotal": 29605774170,
                                "ptsDelta": 4442714,
                                "wuTotal": 107440067,
                                "rank": 1,
                                "rankDelta": 0,
                                "ptsDay": 27983419,
                                "ptsWeek": 215813611],
                        [
                                "teamId": 33,
                                "alias": "[H]ardOCP",
                                "ptsTotal": 25219646506,
                                "ptsDelta": 7014649,
                                "wuTotal": 18026795,
                                "rank": 2,
                                "rankDelta": 0,
                                "ptsDay": 41105775,
                                "ptsWeek": 304415648]
                ]
        ]

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
        teams.rows.size() == teamsList.size()
        teams.hasCorrectHeadings()
        teams.rows*.hasCorrectColumns()
        teams.containsTeams(teamsList.results)
    }
}