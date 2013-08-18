package com.mb.stats.controller

import com.mb.stats.*
import grails.converters.JSON

class TeamsController {

    TeamsService teamsService
    ListParamSanitizerService listParamSanitizerService
    CachableTillNextUpdateService cachableTillNextUpdateService
    HistoryAggregatorService historyAggregatorService

    def list() {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        cache cachableTillNextUpdateService.tillNextUpdate()

        def query = [offset: params.offset, limit: params.limit, sort: params.sort, order: params.order]

        def teams = teamsService.list(query)

        [teams: teams]
    }

    def show(Long teamId) {

        cache cachableTillNextUpdateService.tillNextUpdate()

        def team = teamsService.get(teamId)

        [team: team]

    }

    def history(Long teamId) {

        cache cachableTillNextUpdateService.tillNextUpdate()

        def result = teamsService.fetchHistory(new RequestHistory(teamId: teamId, timestampBegin: params.timestampBegin.toLong(), timestampEnd: params.timestampEnd.toLong()))
        def datasource = new BulkHistorySource(historyMap: result)

        def j = [
                series: [
                        [
                                name: 'Points',
                                data: historyAggregatorService.map(datasource, 'ptsTotal'),
                                type: 'area'
                        ],
                        [
                                name: 'Work Units',
                                data: historyAggregatorService.map(datasource, 'wuTotal'),
                                type: 'area'
                        ],
                ],
                yAxis: [
                        min: historyAggregatorService.calculateMin(datasource, ['wuTotal','ptsTotal'])
                ]
        ]

        render j as JSON
    }

    private Map getConfig() {
        grailsApplication.config.stats.teams
    }
}
