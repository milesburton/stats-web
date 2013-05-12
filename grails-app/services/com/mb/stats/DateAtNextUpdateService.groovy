package com.mb.stats

import org.joda.time.DateMidnight
import org.joda.time.DateTime
import org.joda.time.Duration

class DateAtNextUpdateService {

    int updateIntervalInMinutes = 180
    int updateDuration = 20

    DateTime calculate() {

        def midnight = new DateMidnight()
        Duration duration = new Duration(midnight, new DateTime())

        int minutesTillNextUpdate = (Math.ceil(duration.getStandardMinutes() / updateIntervalInMinutes) * updateIntervalInMinutes)

        midnight.toDateTime().plusMinutes(minutesTillNextUpdate + updateDuration)
    }
}