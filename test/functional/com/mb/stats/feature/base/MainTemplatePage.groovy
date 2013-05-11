package com.mb.stats.feature.base

import com.mb.stats.feature.page.module.FooterModule
import com.mb.stats.feature.page.module.NavbarModule
import com.mb.stats.feature.page.module.SubNavbarModule
import geb.Page

abstract class MainTemplatePage extends Page {

    static content = {

        navbar     { module NavbarModule,     $('#nav-bar') }
        subnavbar  { module SubNavbarModule,  $('#sub-nav-bar') }
        footer     { module FooterModule,     $('#footer') }
    }
}