<!DOCTYPE html>
<html>
<head>
    <title>Grails Runtime Exception</title>
    <meta name="layout" content="main">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}"
          type="text/css">
</head>

<body>

<div class="row">

    <div class="span12">

        <g:renderException exception="${exception}"/>

    </div> <!-- /span12 -->

</div> <!-- /row -->
</body>
</html>
