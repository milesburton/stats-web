package com.mb.stats.feature.page.module

import geb.Module

class NavbarModule extends Module {

    static content = {

        brand      { $('a.brand') }
    }
}