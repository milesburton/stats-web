package com.mb.stats

class CachableTillNextUpdateService {

    DateAtNextUpdateService dateAtNextUpdateService

    Map tillNextUpdate() {
        [shared: true, validUntil: dateAtNextUpdateService.calculate().toDate()]
    }
}