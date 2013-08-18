package com.mb.stats


class HistoryAggregatorService {

    Double calculateMin(BulkHistorySource bulkHistorySource, List<String> keysToAggregate) {

        bulkHistorySource.historyMap.results.collect {
            def metric ->
                keysToAggregate.collect { metric."${it}" }.min()

        }.min()

    }

    def map(BulkHistorySource bulkHistorySource, String key) {

        bulkHistorySource.historyMap.results.collect { [it.timestamp, it."${key}"] }.sort { it[0] }
    }
}
