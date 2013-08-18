package com.mb.stats

import spock.lang.Specification

class HistoryAggregatorServiceSpec extends Specification {

    HistoryAggregatorService historyAggregatorService

    def 'setup'() {

        historyAggregatorService = new HistoryAggregatorService()
    }

    def 'map team history'() {

        given:
        def historyResult = [
                "total": 1, "results":
                [
                        ["teamId": 62, "alias": "futuremark.com", "ptsTotal": 222954209, "ptsDelta": 3009, "wuTotal": 845065, "wuDelta": 5, "rank": 145, "rankDelta": 0, "ptsDay": 56876, "ptsWeek": 418592, "timestamp": 1369736406000],
                        ["teamId": 62, "alias": "futuremark.com", "ptsTotal": 222954210, "ptsDelta": 3009, "wuTotal": 845065, "wuDelta": 5, "rank": 145, "rankDelta": 0, "ptsDay": 56876, "ptsWeek": 418592, "timestamp": 1369736406001]
                ]
        ]

        when:
        def aggregatedList = historyAggregatorService.map(new BulkHistorySource(historyMap: historyResult),'ptsTotal')

        then:
        aggregatedList == remapAndSort(historyResult, 'ptsTotal')
    }

    def 'calculate min over keys'() {
        given:
        def historyResult = [
                "total": 1, "results":
                [
                        ["teamId": 62, "alias": "futuremark.com", "ptsTotal": 222954209, "ptsDelta": 3009, "wuTotal": 845065, "wuDelta": 5, "rank": 145, "rankDelta": 0, "ptsDay": 56876, "ptsWeek": 418592, "timestamp": 1369736406000],
                        ["teamId": 62, "alias": "futuremark.com", "ptsTotal": 222954210, "ptsDelta": 3009, "wuTotal": 845064, "wuDelta": 5, "rank": 145, "rankDelta": 0, "ptsDay": 56876, "ptsWeek": 418592, "timestamp": 1369736406001]
                ]
        ]

        when:
        def calculatedMin = historyAggregatorService.calculateMin(new BulkHistorySource(historyMap: historyResult), ['ptsTotal', 'wuTotal'])

        then:
        calculatedMin == 845064
    }

    def remapAndSort(def fakeJson, String keyToMap){

        fakeJson.results.collect { [it.timestamp,it."${keyToMap}"] }.sort { it[0] }
    }
}
