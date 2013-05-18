package com.mb.stats.feature.spec.base

import com.popcornteam.restclient.RestClient
import com.popcornteam.restclient.factory.HttpClientFactory
import geb.spock.GebSpec
import net.xelnaga.httpimposter.remote.HttpImposterRemote
import org.apache.http.client.HttpClient

class ApiSpec extends GebSpec {

    HttpImposterRemote imposterRemote

    HttpClientFactory httpClientFactory
    HttpClient httpClient

    RestClient jsonClient

    void setup() {

        httpClientFactory = new HttpClientFactory()
        httpClient = httpClientFactory.makeThreadSafeHttpClient(2)

        imposterRemote = new HttpImposterRemote("${baseUrl}fake")
        imposterRemote.reset()

        jsonClient = new RestClient(baseUrl, [], httpClient)

        injectBaseUrlIntoFixtures()
    }

    private void injectBaseUrlIntoFixtures() {

        def fixturesWithBaseUrl = properties.findAll { it.value instanceof UsesBaseUrlTag }.collect { it.value }

        if (fixturesWithBaseUrl) {
            fixturesWithBaseUrl*.baseUrl = baseUrl
        }
    }

}
