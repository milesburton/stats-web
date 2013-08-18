package com.mb.stats.feature.page

import com.mb.stats.feature.base.MainTemplatePage
import com.mb.stats.feature.page.module.ChartModule
import com.mb.stats.feature.page.module.StatModule

import java.text.DecimalFormat

class TeamPage extends MainTemplatePage {

    static url = 'teams'
    Long teamId

    static at = {

        assert title.startsWith("Team")
        return true
    }

    boolean titleContains(String id){

        assert title.contains(id)
        return true
    }

    static content = {
        stats       { moduleList StatModule, $('#big_stats div.stat') }
        chartModule { module ChartModule, $('.widget.production')}
    }

    boolean hasCorrectHeadings(def team){

        def df = new DecimalFormat('#,###')
        df.setMaximumFractionDigits(0)

        assert stats*.title == ["Rank", "Points (Last Update)", "Points (Day)", "Points (Week)", "Points (Total)", "Work Units (Total)"]
        assert stats*.value == [team.rank, team.ptsDelta, team.ptsDay, team.ptsWeek, team.ptsTotal, team.wuTotal].collect { df.format(it) }

        true
    }

    String convertToPath(Object[] args) {

        teamId = (args[0] as Long)
        return super.convertToPath(args)
    }

    boolean hasProductionModule(){
        assert chartModule.title == 'Production'
        true
    }

}
