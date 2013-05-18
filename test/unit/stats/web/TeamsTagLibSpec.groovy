package stats.web

import com.mb.stats.ListParamSanitizerService
import com.mb.stats.QueryStringBuilderService
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll


@TestFor(TeamsTagLib)
class TeamsTagLibSpec extends Specification {

    ListParamSanitizerService mockListParamSanitizerService
    QueryStringBuilderService mockQueryStringBuilderService

    def 'setup'() {

        tagLib.grailsApplication = fakeConfig()

        mockListParamSanitizerService = Mock(ListParamSanitizerService)
        tagLib.listParamSanitizerService = mockListParamSanitizerService

        mockQueryStringBuilderService = Mock(QueryStringBuilderService)
        tagLib.queryStringBuilderService = mockQueryStringBuilderService
    }


    def "generate default link"() {

        given:
        def requestedSort = 'teamId'
        def currentSort = 'alias'

        and:
        def attrs = [sort: requestedSort]
        params.sort = currentSort

        when:
        String generatedLink = tagLib.link(attrs) { 'link' }

        then:
        generatedLink == '<a href="fakelink" class="teamId">link</a>'

        and:
        1 * mockListParamSanitizerService.sanitizePaginationParams([sort: 'teamId', order: 'desc'], fakeConfig().config.stats.teams)
        1 * mockQueryStringBuilderService.asResource('teams', [sort: requestedSort, order: 'desc']) >> 'fakelink'
        0 * _._
    }

    @Unroll
    def "expect new order #expectedOrder when sorting by #sortField #currentOrder if current sort is #currentSortField"() {

        given:
        def attrs = [sort: sortField]
        params.order = currentOrder
        params.sort = currentSortField

        when:
        String generatedLink = tagLib.link(attrs) { 'link' }

        then:
        generatedLink == """<a href="fakelink" class="${sortField} ${currentOrder}">link</a>"""

        and:
        1 * mockListParamSanitizerService.sanitizePaginationParams([order: expectedOrder, sort: sortField], fakeConfig().config.stats.teams)
        1 * mockQueryStringBuilderService.asResource('teams', [order: expectedOrder, sort: sortField]) >> 'fakelink'
        0 * _._

        where:
        currentSortField | sortField | currentOrder | expectedOrder
        'teamId'         | 'teamId'  | 'desc'       | 'asc'
        'teamId'         | 'teamId'  | 'asc'        | 'desc'
    }

    def "expect anchor class to be teamId"() {

        given:
        def requestedSort = 'alias'
        def currentSort = 'teamId'

        and:
        def attrs = [sort: requestedSort]
        params.sort = currentSort

        when:
        String generatedLink = tagLib.link(attrs) { 'link' }

        then:
        generatedLink == """<a href="fakelink" class="${requestedSort}">link</a>"""

        and:
        1 * mockListParamSanitizerService.sanitizePaginationParams([order: 'desc', sort: attrs.sort], fakeConfig().config.stats.teams)
        1 * mockQueryStringBuilderService.asResource('teams', [order: 'desc', sort: attrs.sort]) >> 'fakelink'
        0 * _._

    }

    private Map fakeConfig() {

        [config:
                [stats:
                        [
                                teams:
                                        [
                                                order: [
                                                        options: ['asc', 'desc'],
                                                        defaultValue: 'desc'
                                                ],
                                                sort: [

                                                ]
                                        ]
                        ]
                ]
        ]
    }
}