package com.mb.stats.feature.page

import com.mb.stats.feature.base.MainTemplatePage

class HomePage extends MainTemplatePage {

    static url = ''

    static at = {
        assert title == 'Home'
        return true
    }

}
