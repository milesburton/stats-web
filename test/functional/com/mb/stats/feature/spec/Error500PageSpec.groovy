package com.mb.stats.feature.spec

import com.mb.stats.feature.page.Error500Page
import geb.spock.GebSpec

class Error500PageSpec extends GebSpec {

    def 'use is shown 500 page'() {

        when:
        to Error500Page

        then:
        at Error500Page
    }
}