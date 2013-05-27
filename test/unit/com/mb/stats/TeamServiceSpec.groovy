package com.mb.stats

import com.popcornteam.restclient.RestClient
import com.popcornteam.restclient.response.StubRestResponse
import spock.lang.Specification

import static com.test.QueryStringHelper.asQueryString

class TeamServiceSpec extends Specification {

    def service
    def mockRazerClient
    def mockQueryStringBuilderService

    def 'setup'() {

        service = new TeamService()

        mockRazerClient = Mock(RestClient)
        service.razerClient = mockRazerClient

        mockQueryStringBuilderService = Mock(QueryStringBuilderService)
        service.queryStringBuilderService = mockQueryStringBuilderService
    }

    def 'list'() {

        given:
        def params = [offset: 0, order: 'ptsWeek', limit: 1000]

        and:
        def expectedResults = [total: 2, results:
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
        def results = service.list(params)

        then:
        results == expectedResults

        and:
        1 * mockQueryStringBuilderService.asResource('teams', params) >> teamResourceWith(params)
        1 * mockRazerClient.get(teamResourceWith(params)) >> new StubRestResponse(200, expectedResults)
        0 * _._
    }

    def 'get'() {

        given:
        def teamId = 62

        and:
        def expectedTeam = [
                "teamId": 0,
                "alias": "Default (includes all those WU returned without valid team number)",
                "ptsTotal": 29605774170,
                "ptsDelta": 4442714,
                "wuTotal": 107440067,
                "rank": 1,
                "rankDelta": 0,
                "ptsDay": 27983419,
                "ptsWeek": 215813611
        ]


        when:
        def results = service.get(teamId)

        then:
        results == expectedTeam

        and:
        1 * mockRazerClient.get("teams/${teamId}") >> new StubRestResponse(200, expectedTeam)
        0 * _._
    }

    private String teamResourceWith(Map params) {
        "teams?${asQueryString(params)}"
    }


}
