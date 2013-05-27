package com.mb.stats.feature.page.module

import geb.Module

class NavbarModule extends Module {

    boolean hasCorrectHeading(String expectedHeading = 'Razer Folding@Home Statistics'){
        brand.text() == expectedHeading
    }

    static content = {

        brand      { $('a.brand') }
    }
}