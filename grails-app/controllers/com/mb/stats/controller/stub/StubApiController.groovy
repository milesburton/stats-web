package com.mb.stats.controller.stub

import grails.converters.JSON

class StubApiController {

    def team() {


        def teamFixtures = JSON.parse(getClass().getResourceAsStream('teams.json').text)

        def offset = params.offset.toLong()
        def offsetPlusLimit = offset + params.limit.toLong() - 1


        def teams = teamFixtures.results[offset..offsetPlusLimit]

        def j = [
                total: teamFixtures.total,
                results: teams
        ]

        render j as JSON
    }
}
