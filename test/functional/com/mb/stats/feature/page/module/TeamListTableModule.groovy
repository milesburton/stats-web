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
        pagination { module PaginationModule, $('.pagination') }
        rows       { moduleList TeamRowModule, $('table > tbody > tr') }

        rank       { $('th a.rank') }
        teamId     { $('th a.teamId') }
        alias      { $('th a.alias') }
        ptsDelta   { $('th a.ptsDelta') }
        ptsDay     { $('th a.ptsDay') }
        ptsWeek    { $('th a.ptsWeek') }
        ptsTotal   { $('th a.ptsTotal') }
        wuTotal    { $('th a.wuTotal') }
    }

}
