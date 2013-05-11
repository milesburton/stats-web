package com.mb.stats.feature.page.module

import geb.Module

class SubNavbarModule extends Module {

    static content = {

        links      { $('ul.mainnav > li > a') }
        active     { $('ul.mainnav > li.active > a') }
    }
}
