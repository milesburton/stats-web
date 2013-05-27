package com.mb.stats.feature.page.module

import geb.Module

import java.text.DecimalFormat

class TeamRowModule extends Module {

    boolean hasCorrectColumns() {
        columns.size() == 9
    }

    void isTeam(Map team) {

        def df = new DecimalFormat('#,###')
        df.setMaximumFractionDigits(0)

       assert teamId.text() == df.format(team.teamId)
       assert alias.text() == team.alias
       assert ptsTotal.text() == df.format(team.ptsTotal)
       assert ptsDelta.text() == df.format(team.ptsDelta)
       assert wuTotal.text() == df.format(team.wuTotal)
       assert rank.text() == df.format(team.rank)
       assert rankDelta.text() == df.format(team.rankDelta)
       assert ptsDay.text() == df.format(team.ptsDay)
       assert ptsWeek.text() == df.format(team.ptsWeek)

    }

    static content = {

        columns         { $('td') }

        teamId          { $('.teamId') }
        alias           { $('.alias a') }
        ptsTotal        { $('.ptsTotal') }
        ptsDelta        { $('.ptsDelta') }
        wuTotal         { $('.wuTotal') }
        rank            { $('.rank') }
        rankDelta       { $('.rankDelta') }
        ptsDay          { $('.ptsDay') }
        ptsWeek         { $('.ptsWeek') }
    }
}
