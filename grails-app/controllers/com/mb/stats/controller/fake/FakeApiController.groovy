package com.mb.stats.controller.fake

import net.xelnaga.httpimposter.HttpImposter
import net.xelnaga.httpimposter.filter.HeaderNameExclusionFilter
import net.xelnaga.httpimposter.filter.HttpHeaderFilter

class FakeApiController {


    private static final HttpHeaderFilter FILTER = new HeaderNameExclusionFilter(['Host', 'User-Agent', 'Connection', 'Content-Length'])
    private static final HttpImposter IMPOSTER = new HttpImposter(filter: FILTER)

    def index() {

        String url = request.forwardURI

        if (request.queryString) {
            url += "?${request.queryString}"
        }

        print url
        IMPOSTER.respond(url, request, response)
    }

    def reset() {

        IMPOSTER.reset()
        render ''
    }

    def configure() {

        IMPOSTER.configure(request)
        render ''
    }
}
