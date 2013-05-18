import grails.util.Environment

class TestUrlMappings {

    static mappings = {

        if (["test"].contains(Environment.current.name)) {


            '/fake/reset'           (controller: 'fakeApi', action: [ POST: 'reset' ])
            '/fake/configure'       (controller: 'fakeApi', action: [ POST: 'configure' ])

            '/fake/**'              (controller: 'fakeApi', action: [ GET: 'index' ])
        }
    }
}
