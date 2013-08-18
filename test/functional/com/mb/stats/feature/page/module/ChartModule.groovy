package com.mb.stats.feature.page.module

import geb.Module

class ChartModule extends Module {

    static content = {

        title                           { $('h3').text() }
    }

}