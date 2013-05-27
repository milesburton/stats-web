package com.mb.stats.feature.page.module

import geb.Module

class StatModule extends Module {

    static content = {

        title                           { $('h4').text() }
        value                           { $('span.value').text() }
    }

}