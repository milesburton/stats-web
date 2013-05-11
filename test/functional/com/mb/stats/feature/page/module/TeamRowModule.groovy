package com.mb.stats.feature.page.module

import geb.Module

class TeamRowModule extends Module {

    boolean hasCorrectColumns() {
        columns.size() == 7
    }

    boolean isTeam(Map team) {

        rank.text() == team.rank &&
                teamId.text() == team.id &&
                alias.text() == team.alias &&
                pointsDay.text() == team.pointsDay &&
                pointsWeek.text() == team.pointsWeek &&
                wuTotal.text() == team.wusTotal
    }

    static content = {

        columns         {  $('td') }

        rank            {  $('.rank') }
        teamId          {  $('.id') }
        alias           {  $('.alias') }
        pointsDay       {  $('.points-day') }
        pointsWeek      {  $('.points-week') }
        pointsTotal     {  $('.points-total') }
        wuTotal         {  $('.wu-total') }
    }
}
