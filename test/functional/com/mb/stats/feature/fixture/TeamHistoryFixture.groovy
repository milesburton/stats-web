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

    ImposterRequest get(String teamId, Long timestampBegin, Long timestampEnd) {

        return new ImposterRequest(
                uri: "/stats-web/fake/api/teams/${teamId}/history?timestampBegin=${timestampBegin}&timestampEnd=${timestampEnd}",
                method: 'GET',
                headers: [new HttpHeader('accept', 'application/json')],
                body: ''
        )
    }

    ImposterResponse andRespondWith(def history) {

        return new ImposterResponse(
                status: SC_OK.value,
                headers: [],
                body: history as JSON

        )
    }

    def forQuery(String teamId, Long timestampBegin, Long timestampEnd) {

        JSON.parse(getClass().getResourceAsStream('teamHistory.json').text)
    }
}
