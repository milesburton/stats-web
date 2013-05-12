package com.mb.stats

class NumberService {

    int applyDefault(def param, int d) {

        if (!param || !param.toString().isNumber()) {
            d
        } else {
            param.toInteger()
        }
    }

    int constrain(Integer param, int lowerBound, int upperBound) {
        Math.min(Math.max(param, lowerBound), upperBound)
    }

}