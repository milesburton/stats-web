package com.mb.stats



import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

@TestFor(ListParamSanitizerService)
class ListParamSanitizerServiceSpec extends Specification {


    final String OPTIONS_ASC = "asc"
    final String OPTIONS_DESC = "desc"
    final String SORT_DEFAULT = "ptsTotal"


    def setup() {

        config.stats.teams.order = [
                options: [OPTIONS_ASC, OPTIONS_DESC],
                defaultValue: OPTIONS_DESC
        ]

        config.stats.teams.sort = [
                defaultValue: SORT_DEFAULT,
                options: ["teamId", "alias", SORT_DEFAULT, "ptsDelta", "wuTotal", "wuDelta", "rank", "rankDelta", "ptsDay", "ptsWeek"]
        ]

        config.stats.teams.offset = [defaultValue: 0]
        config.stats.teams.limit = [
                min: 1,
                max: 1000,
                defaultValue: 50
        ]

        service.numberService = Mock(NumberService)

    }

    def 'sanitizePaginationParams should set defaults'() {

        given:
        Map params = [:]

        when:
        service.sanitizePaginationParams(params, config.stats.teams)

        then:
        params == [
                order: config.stats.teams.order.defaultValue,
                sort: config.stats.teams.sort.defaultValue,
                offset: config.stats.teams.offset.defaultValue,
                limit: config.stats.teams.limit.defaultValue
        ]

        and:
        1 * service.numberService.applyDefault(null, config.stats.teams.offset.defaultValue) >> config.stats.teams.offset.defaultValue

        and:
        1 * service.numberService.applyDefault(null, config.stats.teams.limit.defaultValue) >> config.stats.teams.limit.defaultValue
        1 * service.numberService.constrain(config.stats.teams.limit.defaultValue, config.stats.teams.limit.min, config.stats.teams.limit.max) >> config.stats.teams.limit.defaultValue

        and:
        0 * _._
    }

    def 'sanitizePaginationParams with valid params'() {

        given:
        Map params = [
                order: OPTIONS_ASC,
                sort: 'teamId',
                offset: 10,
                limit: 10
        ]

        when:
        service.sanitizePaginationParams(params, config.stats.teams)

        then:
        params == [
                order: OPTIONS_ASC,
                sort: 'teamId',
                offset: 10,
                limit: 10
        ]


        and:
        1 * service.numberService.applyDefault(params.offset, config.stats.teams.offset.defaultValue) >> params.offset

        and:
        1 * service.numberService.applyDefault(params.limit, config.stats.teams.limit.defaultValue) >> params.limit
        1 * service.numberService.constrain(params.limit, config.stats.teams.limit.min, config.stats.teams.limit.max) >> params.limit

        and:
        0 * _._
    }


}