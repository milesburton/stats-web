package com.mb.stats.feature.fixture

import com.mb.stats.feature.spec.base.UsesBaseUrlTag
import grails.converters.JSON
import net.xelnaga.httpimposter.model.HttpHeader
import net.xelnaga.httpimposter.model.ImposterRequest
import net.xelnaga.httpimposter.model.ImposterResponse

import static org.apache.http.HttpStatus.SC_NOT_FOUND
import static org.apache.http.HttpStatus.SC_OK

class TeamFixture implements UsesBaseUrlTag {

    String baseUrl

    ImposterRequest get(String teamId) {

        return new ImposterRequest(
                uri: "/stats-web/fake/api/teams/${teamId}",
                method: 'GET',
                headers: [new HttpHeader('accept', 'application/json')],
                body: ''
        )
    }

    ImposterResponse andRespondWith(def team) {

        return new ImposterResponse(
                status: SC_OK.value,
                headers: [],
                body: team as JSON

        )
    }

    ImposterResponse andRespondWith404() {

        return new ImposterResponse(
                status: SC_NOT_FOUND.value,
                headers: [],
                body: ''

        )
    }

    def forQuery(String teamId) {

        JSON.parse(getClass().getResourceAsStream('teams.json').text).results.find { it.teamId.toString() == teamId }
    }
}
