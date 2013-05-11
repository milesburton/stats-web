package com.mb.stats.feature.spec

import com.mb.stats.feature.page.HomePage
import geb.spock.GebSpec

class HomePageSpec extends GebSpec {

    def 'user is shown home page'() {

        when:
        to HomePage

        then:
        at HomePage

        and:
        navbar.brand.text() == 'Razer Folding@Home Statistics'
        subnavbar.links.size() == 1
        subnavbar.active.text() == 'Home'
        footer.copyright.text() == '© 2013 Agile View Limited'
    }
}