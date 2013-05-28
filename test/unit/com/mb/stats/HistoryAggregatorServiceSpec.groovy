package com.mb.stats

import spock.lang.Specification

class HistoryAggregatorServiceSpec extends Specification {

    HistoryAggregatorService historyAggregatorService

    def 'setup'() {

        historyAggregatorService = new HistoryAggregatorService()
    }

    def 'aggregate team history'() {

        given:
        def historyResult = [
                "total": 1, "results":
                [
                        ["teamId": 62, "alias": "futuremark.com", "ptsTotal": 222954209, "ptsDelta": 3009, "wuTotal": 845065, "wuDelta": 5, "rank": 145, "rankDelta": 0, "ptsDay": 56876, "ptsWeek": 418592, "timestamp": 1369736406000],
                        ["teamId": 62, "alias": "futuremark.com", "ptsTotal": 222954210, "ptsDelta": 3009, "wuTotal": 845065, "wuDelta": 5, "rank": 145, "rankDelta": 0, "ptsDay": 56876, "ptsWeek": 418592, "timestamp": 1369736406001]
                ]
        ]

        when:
        def aggregatedList = historyAggregatorService.aggregate(new BulkHistorySource(historyMap: historyResult))

        then:
        aggregatedList == aggregateAndSort(historyResult)

    }

    def aggregateAndSort(def results){

        results.results.collect { [it.timestamp,it.ptsTotal] }.sort { it[0] }
    }
}
