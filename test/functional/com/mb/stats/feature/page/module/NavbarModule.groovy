package com.mb.stats.feature.page.module

import geb.Module

class NavbarModule extends Module {

    boolean hasCorrectHeading(){
        brand.text() == 'Razer Folding@Home Statistics'
    }

    static content = {

        brand      { $('a.brand') }
    }
}