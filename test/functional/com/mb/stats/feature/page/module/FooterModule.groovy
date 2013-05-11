package com.mb.stats.feature.page.module

import geb.Module

class FooterModule extends Module {

    boolean isValidCopyright(){
        copyright.text() == '© 2013 Agile View Limited'
    }

    static content = {

        copyright { $('#footer-copyright') }

    }
}
