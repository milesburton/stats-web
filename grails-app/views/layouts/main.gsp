<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <title><g:layoutTitle default="Razer Folding@Home Statistics"/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <link href="${resource(dir: 'css', file: 'bootstrap.min.css')}" rel="stylesheet">
    <link href="${resource(dir: 'css', file: 'bootstrap-responsive.min.css')}" rel="stylesheet">

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
    <link href="${resource(dir: 'css', file: 'font-awesome.min.css')}" rel="stylesheet">

    <link href="${resource(dir: 'css/ui-lightness', file: 'jquery-ui-1.10.0.custom.min.css')}" rel="stylesheet">

    <link href="${resource(dir: 'css', file: 'base-admin-2.css')}" rel="stylesheet">
    <link href="${resource(dir: 'css', file: 'base-admin-2-responsive.css')}" rel="stylesheet">

    <link href="${resource(dir: 'css', file: 'custom.css')}" rel="stylesheet">

    <link rel="shortcut icon" href="${resource(dir: 'img', file: 'favicon.ico')}" type="image/x-icon">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body>
<g:render template="/common/navbar" />

<g:render template="/common/subnavbar" />

<div class="main">

    <div class="container">

        <g:layoutBody/>
    </div> <!-- /container -->

</div> <!-- /main -->


<g:render template="/common/footer" />

<script src="${resource(dir: 'js/libs', file: 'jquery-1.8.3.min.js')}"></script>
<script src="${resource(dir: 'js/libs', file: 'jquery-ui-1.10.0.custom.min.js')}"></script>
<script src="${resource(dir: 'js/libs', file: 'bootstrap.min.js')}"></script>

<script src="${resource(dir: 'js/plugins/flot', file: 'jquery.flot.js')}"></script>
<script src="${resource(dir: 'js/plugins/flot', file: 'jquery.flot.pie.js')}"></script>
<script src="${resource(dir: 'js/plugins/flot', file: 'jquery.flot.resize.js')}"></script>

<g:javascript library="application"/>
<r:layoutResources/>

<script src="./js/charts/area.js"></script>
<script src="./js/charts/donut.js"></script>

</body>
</html>
