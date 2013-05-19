package com.mb.stats.feature.page.module

import geb.Module

class PaginationModule extends Module {

    void atPage(String page){
        assert activePage.text() == page
    }

    static content = {

        pages                           { $('ul > li a') }
        activePage                      { $('ul > li.active a') }
        steps(required:false)           { $('ul > li.gap a') }
        nextLink(required:false)        { $('ul > li.nextLink a') }
        prevLink(required:false)        { $('ul > li.prevLink a') }
    }

}