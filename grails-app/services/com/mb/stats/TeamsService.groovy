package com.mb.stats

import com.popcornteam.restclient.RestClient

class TeamsService {

    RestClient razerClient
    QueryStringBuilderService queryStringBuilderService

    Map list(Map query) {

        def resource = queryStringBuilderService.asResource('teams', query)
        razerClient.get(resource).bodyAsJsonMap
    }

    Map get(Long teamId) {
        razerClient.get("teams/${teamId}").bodyAsJsonMap
    }

    Map fetchHistory(RequestHistory requestHistory) {

        def resource = queryStringBuilderService.asResource("teams/${requestHistory.teamId}/history", [timestampBegin: requestHistory.timestampBegin, timestampEnd: requestHistory.timestampEnd])
        razerClient.get(resource).bodyAsJsonMap
    }
}
