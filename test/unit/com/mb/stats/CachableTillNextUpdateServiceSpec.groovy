package com.mb.stats



import org.joda.time.DateTime
import spock.lang.Specification

class CachableTillNextUpdateServiceSpec extends Specification {

    CachableTillNextUpdateService cachableTillNextUpdateService

    def setup(){
        cachableTillNextUpdateService = new CachableTillNextUpdateService()

        cachableTillNextUpdateService.dateAtNextUpdateService = Mock(DateAtNextUpdateService)
    }

    def 'tillNextUpdate'(){

        given:
        DateTime d = new DateTime()

        when:
        def a =cachableTillNextUpdateService.tillNextUpdate()

        then:
        a == [shared: true, validUntil: d.toDate()]

        and:
        1 * cachableTillNextUpdateService.dateAtNextUpdateService.calculate() >> d
        0 * _._
    }
}