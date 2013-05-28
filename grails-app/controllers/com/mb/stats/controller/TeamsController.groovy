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

        def result = teamsService.fetchHistory(new RequestHistory(teamId: teamId, timestampBegin: params.timestampBegin, timestampEnd: params.timestampEnd))

        render historyAggregatorService.aggregate(new BulkHistorySource(historyMap: result)) as JSON
    }

    private Map getConfig() {
        grailsApplication.config.stats.teams
    }
}
