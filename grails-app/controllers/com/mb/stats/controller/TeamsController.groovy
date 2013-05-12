package com.mb.stats.controller

import com.mb.stats.CachableTillNextUpdateService
import com.mb.stats.ListParamSanitizerService
import com.mb.stats.TeamService


class TeamsController {

    TeamService teamService
    ListParamSanitizerService listParamSanitizerService
    CachableTillNextUpdateService cachableTillNextUpdateService

    def list() {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        cache cachableTillNextUpdateService.tillNextUpdate()

        def query = [offset: params.offset, limit: params.limit, sort: params.sort, order: params.order]

        def teams = teamService.list(query)

        [teams: teams]
    }

    private Map getConfig() {
        grailsApplication.config.stats.teams
    }
}
