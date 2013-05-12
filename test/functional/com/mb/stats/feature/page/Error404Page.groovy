package com.mb.stats.feature.page

import com.mb.stats.feature.base.MainTemplatePage

class Error404Page extends MainTemplatePage {

    static url = 'AMISSINGPAGE'

    static at = {

        assert title == 'Couldn\'t find that page'
        assert heading == 'Oops!'
        assert subheading == '404 Not Found'
        assert details == 'Sorry, an error has occured, Requested page not found!'

        return true
    }

    static content = {

        heading         { $('.error-container h1').text() }
        subheading      { $('.error-container h2').text() }
        details         { $('.error-container .error-details').text() }
    }

}
