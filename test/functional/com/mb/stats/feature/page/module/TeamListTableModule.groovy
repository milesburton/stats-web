package com.mb.stats.feature.page.module

import geb.Module

class TeamListTableModule extends Module {

    boolean containsTeam(Map team){

        rows.find { it.isTeam(team) }

    }

    boolean containsTeams(List<Map> teams){

       !teams.find { !containsTeam(it) }

    }

    boolean hasCorrectHeadings(){

        headings.size() == 8
        
        headings*.text() == [
                'Rank',
                'Team ID',
                'Alias',
                "Points (Last Update)",
                "Points (Day)",
                "Points (Week)",
                "Points (Total)",
                "Work Units (Total)"
        ]
    }


    static content = {

        title      { $('.widget-header').text() }

        headings   { $('table > th') }
        rows       { moduleList TeamRowModule, $('table > tbody > tr') }
    }

}
