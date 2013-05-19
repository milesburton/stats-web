modules = {

    baseadmin {
        dependsOn 'jquery191'

        resource url: 'css/font-awesome.min.css'
        resource url: 'css/bootstrap.min.css'
        resource url: 'css/bootstrap-responsive.min.css'
        resource url: 'css/ui-lightness/jquery-ui-1.10.0.custom.min.css'
        resource url: 'css/base-admin-2.css'
        resource url: 'css/base-admin-2-responsive.css'
        resource url: 'less/custom.less',                                                               attrs:[rel: "stylesheet/less", type:'css']

        resource url: 'js/libs/bootstrap.min.js',                                                       disposition: 'defer'

        resource url: 'js/Application.js',                                                              disposition: 'defer'
    }

    jquery191 {
        resource url: 'js/libs/jquery-1.9.1.min.js',                                                    disposition: 'defer'
        resource url: 'js/libs/jquery-ui-1.10.0.custom.min.js',                                         disposition: 'defer'
    }

    flot {
        resource url: 'js/plugins/flot/jquery.flot.js',                                                 disposition: 'defer'
        resource url: 'js/plugins/flot/jquery.flot.pie.js',                                             disposition: 'defer'
        resource url: 'js/plugins/flot/jquery.flot.resize.js',                                          disposition: 'defer'

        resource url: 'js/charts/area.js',                                                              disposition: 'defer'
        resource url: 'js/charts/donut.js',                                                             disposition: 'defer'
    }

}