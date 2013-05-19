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

    <r:require modules="baseadmin, jquery191"/>

    <link rel="shortcut icon" href="${resource(dir: 'img', file: 'favicon.ico')}" type="image/x-icon">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" type="text/css" rel="screenshot" media="screen, projection" />
    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body>
<g:render template="/common/navbar"/>

<g:render template="/common/subnavbar"/>

<div class="main">

    <div class="container">
        <g:layoutBody/>
    </div>

</div>


<g:render template="/common/footer"/>
<r:layoutResources/>

</body>
</html>
