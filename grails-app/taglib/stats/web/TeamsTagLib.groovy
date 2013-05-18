package stats.web

import com.mb.stats.ListParamSanitizerService
import com.mb.stats.QueryStringBuilderService

class TeamsTagLib {

    static namespace = "teams"

    ListParamSanitizerService listParamSanitizerService
    QueryStringBuilderService queryStringBuilderService
    def grailsApplication

    def link = { attrs, body ->

        Map newParams = createNewParamsForRequestedSort(attrs.sort)

        listParamSanitizerService.sanitizePaginationParams(newParams, config)

        String url = queryStringBuilderService.asResource(namespace, newParams)

        out << buildAnchor(url, withCssClassesFor(attrs), body)
    }

    private GString buildAnchor(String url, classes, body) {
        """<a href="${url}" class="${classes}">${body()}</a>"""
    }

    private def withCssClassesFor(Map attrs) {

        def classes = [attrs.sort, attrs.class]

        if (isCurrentSort(attrs.sort)) {
            classes << params.order
        }

        classes.findAll { it }.join(' ')
    }

    private String determineOrderWhenSortIs(String sortOrder) {

        if (isCurrentSort(sortOrder)) {
            config.order.options.find { it != params.order }
        } else {
            config.order.defaultValue
        }
    }

    private boolean isCurrentSort(String newSort) {
        params.sort?.equals(newSort)
    }

    private Map createNewParamsForRequestedSort(String requestedSort) {

        Map validParamsCopy = findAllValidParametersOfCurrentRequest()

        validParamsCopy.sort = requestedSort
        validParamsCopy.order = determineOrderWhenSortIs(requestedSort)
        validParamsCopy
    }

    private Map findAllValidParametersOfCurrentRequest() {

        Map paramsCopy = [:]
        params.findAll { k, v -> config.keySet().contains(k) }.each { k, v -> paramsCopy.put(k, v) }
        paramsCopy

    }

    private Map getConfig() {
        grailsApplication.config.stats.teams
    }

}
