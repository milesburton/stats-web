package com.mb.stats.controller

import com.mb.stats.CachableTillNextUpdateService
import com.mb.stats.ListParamSanitizerService
import com.mb.stats.TeamService
import com.mb.stats.controller.helper.MockCacheCall
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TeamsController)
class TeamsControllerSpec extends Specification {

    def fakeResult
    MockCacheCall mockCache = new MockCacheCall()

    def setup() {

        controller.teamService = Mock(TeamService)
        controller.listParamSanitizerService = Mock(ListParamSanitizerService)
        controller.cachableTillNextUpdateService = Mock(CachableTillNextUpdateService)

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
        1 * controller.teamService.list(['offset':null, 'limit':null, 'sort':null, 'order':null]) >> fakeResult
        0 * _._
    }
}