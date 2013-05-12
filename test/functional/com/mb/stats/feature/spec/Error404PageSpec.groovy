package com.mb.stats.feature.spec

import com.mb.stats.feature.page.Error404Page
import geb.spock.GebSpec

class Error404PageSpec extends GebSpec {

    def 'use is shown 404 page'() {

        when:
        to Error404Page

        then:
        at Error404Page
    }
}