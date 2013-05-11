package com.mb.stats.feature.page.module

import geb.Module

class FooterModule extends Module {

    static content = {

        copyright { $('#footer-copyright') }

    }
}
