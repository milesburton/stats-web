package com.mb.stats.feature.page.module

import geb.Module

class SubNavbarModule extends Module {


    boolean hasCorrectNumberOfLinks() {
        links.size() == 1
    }

    boolean isActive(String title) {
        active.text() == title
    }

    static content = {

        links { $('ul.mainnav > li > a') }
        active { $('ul.mainnav > li.active > a') }
    }
}
