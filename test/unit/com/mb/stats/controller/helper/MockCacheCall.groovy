package com.mb.stats.controller.helper

class MockCacheCall {

    def mockCacheCall(def controller) {

        controller.metaClass.wasCacheCalled = false

        controller.metaClass.cache = {
            Map m ->
                assert m == [:]
                controller.metaClass.wasCacheCalled = true
        }

    }

    void verifyCacheCalled(def controller) {
        assert controller.metaClass.wasCacheCalled
    }

}