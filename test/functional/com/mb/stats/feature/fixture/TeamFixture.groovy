package com.mb.stats.feature.fixture

import com.mb.stats.feature.spec.base.UsesBaseUrlTag
import grails.converters.JSON
import net.xelnaga.httpimposter.model.HttpHeader
import net.xelnaga.httpimposter.model.ImposterRequest
import net.xelnaga.httpimposter.model.ImposterResponse
import com.test.QueryStringHelper

import static org.apache.http.HttpStatus.*

class TeamFixture implements UsesBaseUrlTag {

    String baseUrl

    ImposterRequest get(Map params) {

        String queryString = QueryStringHelper.asQueryString(params)

        return new ImposterRequest(
                uri: "/stats-web/fake/api/team?${queryString}",
                method: 'GET',
                headers: [new HttpHeader('accept', 'application/json')],
                body: ''
        )
    }

    ImposterResponse andRespondWith(def teams) {

        return new ImposterResponse(
                status: SC_OK.value,
                headers: [],
                body: teams as JSON

        )
    }

    def forQuery(Map query) {

        def teamFixtures = JSON.parse(getClass().getResourceAsStream('teams.json').text)

        def offset = query.offset
        def offsetPlusLimit = offset + query.limit - 1


        def teams = teamFixtures.results[offset..offsetPlusLimit]

        [
                total: teamFixtures.total,
                results: teams
        ]
    }
}
