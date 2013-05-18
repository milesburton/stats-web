package com.test

class QueryStringHelper {

    def static asQueryString(Map params) {

        params.collect { k, v ->

            def encodedValue = URLEncoder.encode(v.toString(), 'UTF8')
            "${k}=${encodedValue}"

        }.sort().join("&")
    }
}
