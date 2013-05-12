package com.mb.stats

import com.popcornteam.restclient.RestClient

class TeamService {

    RestClient razerClient
    QueryStringBuilderService queryStringBuilderService

    Map list(Map query) {

        def resource = queryStringBuilderService.asResource('/team', query)
        razerClient.get(resource).bodyAsJsonMap
    }

}
