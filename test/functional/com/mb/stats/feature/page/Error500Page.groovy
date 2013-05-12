package com.mb.stats.feature.page

import com.mb.stats.feature.base.MainTemplatePage

class Error500Page extends MainTemplatePage {

    static url = 'BANG'

    static at = {
        assert title == 'Oops, an error occurred'

            assert heading == 'Oops!'
            assert subheading == '500 Internal Server Error'
            assert details == 'Sorry, an error has occurred,'

            return true
        }

        static content = {

            heading         { $('.error-container h1').text() }
            subheading      { $('.error-container h2').text() }
            details         { $('.error-container .error-details').text() }
        }
}
