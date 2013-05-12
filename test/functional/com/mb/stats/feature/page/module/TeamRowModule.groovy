package com.mb.stats.feature.page.module

import geb.Module

class TeamRowModule extends Module {

    boolean hasCorrectColumns() {
        columns.size() == 9
    }

    boolean isTeam(Map team) {

        teamId.text() == team.teamId &&
                alias.text() == team.alias &&
                ptsTotal.text() == team.ptsTotal &&
                ptsDelta.text() == team.ptsDelta &&
                wuTotal.text() == team.wuTotal &&
                rank.text() == team.rank &&
                rankDelta.text() == team.rankDelta &&
                ptsDay.text() == team.ptsDay &&
                ptsWeek.text() == team.ptsWeek

    }

    static content = {

        columns { $('td') }

        teamId          { $('.teamId') }
        alias           { $('.alias') }
        ptsTotal        { $('.ptsTotal') }
        ptsDelta        { $('.ptsDelta') }
        wuTotal         { $('.wuTotal') }
        rank            { $('.rank') }
        rankDelta       { $('.rankDelta') }
        ptsDay          { $('.ptsDay') }
        ptsWeek         { $('.ptsWeek') }
    }
}
