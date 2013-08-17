package com.mb.stats.controller

import com.mb.stats.*
import com.mb.stats.controller.helper.MockCacheCall
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TeamsController)
class TeamsControllerSpec extends Specification {

    def fakeResult
    MockCacheCall mockCache = new MockCacheCall()

    def setup() {

        controller.teamsService = Mock(TeamsService)
        controller.listParamSanitizerService = Mock(ListParamSanitizerService)
        controller.cachableTillNextUpdateService = Mock(CachableTillNextUpdateService)
        controller.historyAggregatorService = Mock(HistoryAggregatorService)

        fakeResult = [:]
        mockCache.mockCacheCall(controller)

        config.stats.teams = [:]

    }

    def 'list'() {

        when:
        def model = controller.list()

        then:
        model.teams == [:]

        and:
        mockCache.verifyCacheCalled(controller)
        1 * controller.cachableTillNextUpdateService.tillNextUpdate() >> [:]
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.teamsService.list(['offset': null, 'limit': null, 'sort': null, 'order': null]) >> fakeResult
        0 * _._
    }

    def 'get'() {

        given:
        def teamId = 62

        when:
        def model = controller.show(teamId)

        then:
        model.team == [:]

        and:
        mockCache.verifyCacheCalled(controller)
        1 * controller.cachableTillNextUpdateService.tillNextUpdate() >> [:]
        1 * controller.teamsService.get(teamId) >> fakeResult
        0 * _._
    }

    def 'history'() {

        given:
        def teamId = 62
        params.timestampBegin = 0
        params.timestampEnd = 0

        and:
        def historyResult = [:]

        when:
        controller.history(teamId)

        then:
        response.json == [series:[[name:"Points", data:[:], type:"area"]]]

        and:
        mockCache.verifyCacheCalled(controller)
        1 * controller.cachableTillNextUpdateService.tillNextUpdate() >> [:]
        1 * controller.teamsService.fetchHistory(new RequestHistory(teamId: teamId, timestampBegin: params.timestampBegin, timestampEnd: params.timestampEnd)) >> historyResult
        1 * controller.historyAggregatorService.aggregate(new BulkHistorySource(historyMap: historyResult)) >> [:]
        0 * _._

    }
}