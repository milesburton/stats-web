package com.mb.stats

class QueryStringBuilderService {

    def asResource(String resource, Map query) {

        if (query) {

            def queryString = mergeAndJoinParams(query)
            "${resource}?${queryString}"

        } else {
            resource
        }

    }

    private String mergeAndJoinParams(Map query) {

        query.collect { k, v ->

            def encodedValue = URLEncoder.encode(v.toString(), 'UTF8')
            "${k}=${encodedValue}"

        }.sort().join("&")
    }
}
