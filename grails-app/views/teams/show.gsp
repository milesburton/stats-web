<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Team ${params.teamId}</title>
    <r:require modules="pageReports"/>
    <parameter name="heading" value="${team.alias}"/>
</head>

<body>
<div class="row">

    <div class="span12">

        <div class="widget big-stats-container stacked">

            <div class="widget-content">

                <div id="big_stats" class="cf">
                    <div class="stat">
                        <h4>Rank</h4>
                        <span class="value"><g:formatNumber number="${team.rank}" type="number"
                                                            maxFractionDigits="0"/></span>
                    </div> <!-- .stat -->

                    <div class="stat">
                        <h4>Points (Last Update)</h4>
                        <span class="value"><g:formatNumber number="${team.ptsDelta}" type="number"
                                                            maxFractionDigits="0"/></span>
                    </div> <!-- .stat -->

                    <div class="stat">
                        <h4>Points (Day)</h4>
                        <span class="value"><g:formatNumber number="${team.ptsDay}" type="number"
                                                            maxFractionDigits="0"/></span>
                    </div> <!-- .stat -->

                    <div class="stat">
                        <h4>Points (Week)</h4>
                        <span class="value"><g:formatNumber number="${team.ptsWeek}" type="number"
                                                            maxFractionDigits="0"/></span>
                    </div> <!-- .stat -->

                    <div class="stat">
                        <h4>Points (Total)</h4>
                        <span class="value"><g:formatNumber number="${team.ptsTotal}" type="number"
                                                            maxFractionDigits="0"/></span>
                    </div> <!-- .stat -->

                    <div class="stat">
                        <h4>Work Units (Total)</h4>
                        <span class="value"><g:formatNumber number="${team.wuTotal}" type="number"
                                                            maxFractionDigits="0"/></span>
                    </div> <!-- .stat -->
                </div>

            </div> <!-- /widget-content -->

        </div> <!-- /widget -->

    </div> <!-- /span12 -->

</div> <!-- /row -->

</div> <!-- /container -->

</div> <!-- /main -->

</body>
</html>