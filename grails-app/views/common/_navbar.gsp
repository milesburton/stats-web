<%@ page contentType="text/html;charset=UTF-8" %>
<div class="navbar navbar-inverse navbar-fixed-top" id="nav-bar">

    <div class="navbar-inner">

        <div class="container">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <i class="icon-cog"></i>
            </a>

            <g:link mapping="home" class="brand">
                ${pageProperty(name: 'page.heading', default: 'Razer Folding@Home Statistics')}
            </g:link>

        </div><!--/.nav-collapse -->

    </div> <!-- /container -->

</div> <!-- /navbar-inner -->

</div> <!-- /navbar -->