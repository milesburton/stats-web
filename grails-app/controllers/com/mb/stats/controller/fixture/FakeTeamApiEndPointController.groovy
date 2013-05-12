package com.mb.stats.controller.fixture

import grails.converters.JSON

class FakeTeamApiEndPointController {

    def list = {

        def expectedResults = [total: 2, results:
                [
                        [
                                "teamId": 0,
                                "alias": "Default (includes all those WU returned without valid team number)",
                                "ptsTotal": 29605774170,
                                "ptsDelta": 4442714,
                                "wuTotal": 107440067,
                                "rank": 1,
                                "rankDelta": 0,
                                "ptsDay": 27983419,
                                "ptsWeek": 215813611],
                        [
                                "teamId": 33,
                                "alias": "[H]ardOCP",
                                "ptsTotal": 25219646506,
                                "ptsDelta": 7014649,
                                "wuTotal": 18026795,
                                "rank": 2,
                                "rankDelta": 0,
                                "ptsDay": 41105775,
                                "ptsWeek": 304415648]
                ]
        ]

        render expectedResults as JSON


    }
}
