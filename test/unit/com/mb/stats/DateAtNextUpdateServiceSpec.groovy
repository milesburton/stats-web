package com.mb.stats

import org.joda.time.DateMidnight
import org.joda.time.DateTime
import org.joda.time.Duration
import spock.lang.Specification
import test.fixture.NextUpdateIntervalFixtures

class DateAtNextUpdateServiceSpec extends Specification {

    DateAtNextUpdateService dateAtNextUpdateService

    def setup(){
        dateAtNextUpdateService = new DateAtNextUpdateService()
    }

    def 'calculate'(){

        expect:
        dateAtNextUpdateService.calculate() == calculateNextUpdate()
    }

    DateTime calculateNextUpdate() {

        def midnight = new DateMidnight()
        Duration duration = new Duration(midnight, new DateTime())

        int minutesTillNextUpdate = (Math.ceil(duration.getStandardMinutes() / NextUpdateIntervalFixtures.updateIntervalInMinutes) * NextUpdateIntervalFixtures.updateIntervalInMinutes)

        midnight.toDateTime().plusMinutes(minutesTillNextUpdate + NextUpdateIntervalFixtures.updateDuration)
    }
}