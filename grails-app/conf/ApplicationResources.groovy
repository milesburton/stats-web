modules = {

    // Vendor
    baseadmin {

        resource url: 'css/font-awesome.min.css'

        resource url: 'css/base-admin-2.css'
        resource url: 'css/base-admin-2-responsive.css'
        resource url: 'less/custom.less', attrs: [rel: "stylesheet/less", type: 'css']

        resource url: 'js/vendor/base-admin/base-admin-core.js', disposition: 'defer'
    }



    highcharts {

        resource url: 'js/vendor/highcharts/highcharts.src.js'
        resource url: 'js/vendor/highcharts/highcharts-more.src.js'

    }

    // Application
    core {
        dependsOn 'jquery', 'jquery-ui', 'bootstrap', 'baseadmin', 'modernizr'

        resource url: 'js/vendor/html5.js', wrapper: { s -> "<!--[if lt IE 9]>$s<![endif]-->" }    // HTML 5 shin for < IE 9
        resource url: 'js/vendor/json3.js', wrapper: { s -> "<!--[if lt IE 8]>$s<![endif]-->" }    // JSON shim for < IE 8

    }

    'page-reports' {
        dependsOn 'highcharts', 'graph-module'

        resource url: 'css/pages/reports.css'
    }

    'graph-module' {
        dependsOn 'highcharts'

        resource url: 'cs/modules/graph/theme.coffee'
        resource url: 'cs/modules/graph/core.coffee'
    }

}