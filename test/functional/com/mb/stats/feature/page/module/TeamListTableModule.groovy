package com.mb.stats.feature.page.module

import geb.Module

class TeamListTableModule extends Module {

    boolean containsTeam(Map team){

        rows.find { it.isTeam(team) }

    }

    boolean containsTeams(List<Map> teams){

       !teams.find { !containsTeam(it) }

    }


    static content = {

        title      { $('.widget-header').text() }

        headings   { $('table > th') }
        rows       { moduleList TeamRowModule, $('table > tbody > tr') }
    }

}
