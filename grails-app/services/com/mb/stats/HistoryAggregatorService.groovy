package com.mb.stats


class HistoryAggregatorService {

    def aggregate(BulkHistorySource bulkHistorySource) {

        bulkHistorySource.historyMap.results.collect { [it.timestamp,it.ptsTotal] }.sort { it[0] }
    }
}
