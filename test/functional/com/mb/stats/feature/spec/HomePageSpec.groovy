package com.mb.stats.feature.spec

import com.mb.stats.feature.page.HomePage
import geb.spock.GebSpec

class HomePageSpec extends GebSpec {

    def 'user is shown home page'() {

        given:
        def teamsList = [
                [rank: '1', id: '62', alias: 'AgileView', pointsDay: '1', pointsWeek: '2', pointsTotal: '3', wusTotal: '3'],
                [rank: '2', id: '63', alias: 'AgileView 2', pointsDay: '4', pointsWeek: '5', pointsTotal: '6', wusTotal: '7'],
        ]

        when:
        to HomePage

        then:
        at HomePage

        and:
        navbar.hasCorrectHeading()
        subnavbar.hasCorrectNumberOfLinks()
        subnavbar.isActive('Home')
        footer.isValidCopyright()

        and:
        teams.title == 'Teams'
        teams.rows.size() == teamsList.size()
        teams.containsTeams(teamsList)
    }
}