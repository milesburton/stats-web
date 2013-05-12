package com.mb.stats

import spock.lang.Specification
import spock.lang.Unroll

class QueryStringBuilderServiceSpec extends Specification {

    def queryStringBuilderService

    def 'setup'() {
        queryStringBuilderService = new QueryStringBuilderService()
    }

    @Unroll
    def 'resource path should be #expectedPath when resource is #resource with params #params'() {


        when:
        def actualPath = queryStringBuilderService.asResource(resource, params)

        then:
        actualPath == expectedPath

        where:
        resource | params                         | expectedPath
        'test'   | ["pie": "weeble"]              | "test?pie=weeble"
        'test'   | [:]                             | "test"
        'test'   | ["pie": "weeble", bob: 'pie']  | "test?pie=weeble&bob=pie"
        'test'   | ["pie": "weeble", bob: 'pie?'] | "test?pie=weeble&bob=pie%3F"

    }
}
