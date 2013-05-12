package com.mb.stats



import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(NumberService)
class NumberServiceSpec extends Specification {


    @Unroll
    def 'constrain #param to be #expectation when min #min and max #max'() {

        expect:
        service.constrain(param, min, max) == expectation

        where:
        param | min | max | expectation
        1     | 1   | 10  | 1
        0     | 1   | 10  | 1
        11    | 1   | 10  | 10
    }


    @Unroll
    def 'applyDefault when param #param and default #defaultNum then expect #expectation'() {

        expect:
        service.applyDefault(param, defaultNum) == expectation

        where:
        param | defaultNum | expectation
        null  | 1          | 1
        "one" | 1          | 1
        10    | 1          | 10
    }
}