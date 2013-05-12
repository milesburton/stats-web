package com.mb.stats.feature.page.module

import geb.Module

class TeamListTableModule extends Module {

    void containsTeams(List<Map> teams){

       teams.eachWithIndex { Map team, int i ->
            rows[i].isTeam(team)
       }

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

        title      { $('.widget-header h3').text() }

        headings   { $('th') }
        rows       { moduleList TeamRowModule, $('table > tbody > tr') }
    }

}
