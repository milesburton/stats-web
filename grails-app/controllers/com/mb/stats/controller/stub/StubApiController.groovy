package com.mb.stats.controller.stub

import grails.converters.JSON

class StubApiController {

    def teams() {

        def teamFixtures = fetchTeamFixtures()

        def offset = params.offset.toLong()
        def offsetPlusLimit = offset + params.limit.toLong() - 1


        def teams = teamFixtures.results[offset..offsetPlusLimit].sort { it."${params.sort}" }

        if (params.order.equals('desc')) {
            teams = teams.reverse()
        }


        def j = [
                total: teamFixtures.total,
                results: teams
        ]

        render j as JSON
    }

    def team(Long teamId) {

        def team = fetchTeamFixtures().results.find { it.teamId == teamId }

        if (team) {
            render team as JSON
        } else {
            render status: 400
        }

    }

    def teamHistory(Long teamId){

        render fetchTeamHistoryFixtures() as JSON
    }

    private def fetchTeamFixtures() {
        JSON.parse(getClass().getResourceAsStream('teams.json').text)
    }

    private def fetchTeamHistoryFixtures() {
        JSON.parse(getClass().getResourceAsStream('teamhistory.json').text)
    }
}
