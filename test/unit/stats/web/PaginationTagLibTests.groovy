package stats.web

import grails.test.mixin.TestFor

@TestFor(PaginationTagLib)
class PaginationTagLibTests {

    void testPaginateTag() {
        def template = '<custom:paginate controller="book" total="" offset="" />'
        applyTemplate(template)
    }

    void testPaginateOmissionAttributes() {

        def template = '<custom:paginate next="Forward" prev="Backward" limit="5" total="20" offset="10" controller="book" action="list"/>'
        assertOutputEquals '<div class="pagination"><ul><li class="step prevLink"><a href="/book/list?offset=5&amp;limit=5">Backward</li></a><li class="step"><a href="/book/list?offset=0&amp;limit=5">1</a></li><li class="step"><a href="/book/list?offset=5&amp;limit=5">2</a></li><li class="active"><a>3</a></li><li class="step"><a href="/book/list?offset=15&amp;limit=5">4</a></li><li class="step nextLink"><a href="/book/list?offset=15&amp;limit=5">Forward</a></li></ul></div>', template

        template = '<custom:paginate next="Forward" prev="Backward" limit="5" total="20" offset="10" controller="book" action="list" omitPrev="true"/>'
        assertOutputNotContains 'Backward', template
        assertOutputContains 'Forward', template

        template = '<custom:paginate next="Forward" prev="Backward" limit="5" total="20" offset="10" controller="book" action="list" omitPrev="false"/>'
        assertOutputContains 'Backward', template
        assertOutputContains 'Forward', template

        template = '<custom:paginate next="Forward" prev="Backward" limit="5" total="20" offset="10" controller="book" action="list" omitNext="true"/>'
        assertOutputContains 'Backward', template
        assertOutputNotContains 'Forward', template

        template = '<custom:paginate next="Forward" prev="Backward" limit="5" total="20" offset="10" controller="book" action="list" omitNext="false"/>'
        assertOutputContains 'Backward', template
        assertOutputContains 'Forward', template

        template = '<custom:paginate  limit="2" total="20" offset="10" maxsteps="3" controller="book" action="list" omitPrev="true" omitNext="true" omitFirst="true" />'
        assertOutputNotContains '<a href="/book/list?offset=0&amp;limit=2">1</a>', template
        assertOutputContains '<a href="/book/list?offset=18&amp;limit=2">10</a>', template

        template = '<custom:paginate  limit="2" total="20" offset="2" maxsteps="3" controller="book" action="list" omitPrev="true" omitNext="true" omitFirst="true" />'
        assertOutputContains '<a href="/book/list?offset=0&amp;limit=2">1</a>', template

        template = '<custom:paginate  limit="2" total="20" offset="10" maxsteps="3" controller="book" action="list" omitPrev="true" omitNext="true" omitFirst="false" />'
        assertOutputContains '<a href="/book/list?offset=0&amp;limit=2">1</a>', template

        template = '<custom:paginate  limit="2" total="20" offset="10" maxsteps="3" controller="book" action="list" omitPrev="true" omitNext="true" omitLast="true" />'
        assertOutputContains '<a href="/book/list?offset=0&amp;limit=2">1</a>', template
        assertOutputNotContains '<a href="/book/list?offset=18&amp;limit=2">10</a>', template

        template = '<custom:paginate  limit="2" total="20" offset="16" maxsteps="3" controller="book" action="list" omitPrev="true" omitNext="true" omitLast="true" />'
        assertOutputContains '<a href="/book/list?offset=18&amp;limit=2">10</a>', template

        template = '<custom:paginate  limit="2" total="20" offset="10" maxsteps="3" controller="book" action="list" omitPrev="true" omitNext="true" omitLast="false" />'
        assertOutputContains '<a href="/book/list?offset=18&amp;limit=2">10</a>', template
    }

    void testPaginateGap() {

        def template = '<custom:paginate  limit="2" total="20" offset="10" maxsteps="3" controller="book" action="list" />'
        assertOutputContains '<li class="step"><a href="/book/list?offset=0&amp;limit=2">1</a></li><li class="step gap"><a>..</a></li><li class="step"><a href="/book/list?offset=8&amp;limit=2">5</a></li>', template
        assertOutputContains '<li class="step"><a href="/book/list?offset=12&amp;limit=2">7</a></li><li class="step gap"><a>..</a></li><li class="step"><a href="/book/list?offset=18&amp;limit=2">10</a></li>', template

        template = '<custom:paginate  limit="2" total="20" offset="4" maxsteps="3" controller="book" action="list" />'
        assertOutputContains '<li class="step"><a href="/book/list?offset=0&amp;limit=2">1</a></li><li class="step"><a href="/book/list?offset=2&amp;limit=2">2</a></li>', template

        template = '<custom:paginate  limit="2" total="20" offset="14" maxsteps="3" controller="book" action="list" />'
        assertOutputContains '<li class="step"><a href="/book/list?offset=16&amp;limit=2">9</a></li><li class="step"><a href="/book/list?offset=18&amp;limit=2">10</a></li>', template
    }


    void assertOutputContains(expected, template, params = [:]) {

        def result = applyTemplate(template, params)
        assertTrue "Output does not contain expected string [$expected]. Output was: [${result}]", result.indexOf(expected) > -1
    }

    void assertOutputNotContains(expected, template, params = [:]) {

        def result = applyTemplate(template, params)
        assertFalse "Output should not contain the expected string [$expected]. Output was: [${result}]", result.indexOf(expected) > -1
    }
}