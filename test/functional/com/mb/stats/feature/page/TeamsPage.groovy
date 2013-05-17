package com.mb.stats.feature.page

import com.mb.stats.feature.base.MainTemplatePage
import com.mb.stats.feature.page.module.TeamListTableModule

class TeamsPage extends MainTemplatePage {

    static url = 'teams'

    static at = {
        assert title == 'Home'
        return true
    }

    static content = {

        teams      { module TeamListTableModule, $('#teams') }
    }

}
