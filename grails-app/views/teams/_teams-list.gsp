<%@ page contentType="text/html;charset=UTF-8" %>
<div class="widget stacked widget-table">

    <div class="widget-header">
        <span class="icon-list-alt"></span>

        <h3>Teams</h3>
    </div> <!-- .widget-header -->

    <div class="widget-content">
        <table class="table table-bordered table-striped">

            <thead><tr>
                <th>Rank</th>
                <th>Team ID</th>
                <th>Alias</th>
                <th>Points (Last Update)</th>
                <th>Points (Day)</th>
                <th>Points (Week)</th>
                <th>Points (Total)</th>
                <th>Work Units (Total)</th>
            </tr></thead>

            <tbody>

            <g:each in="${teams.results}" var="team">

                <tr>
                    <td>
                        <span class="rank"><%=team.rank %></span> (<span class="rankDelta"><%=team.rankDelta%></span>)
                    </td>
                    <td class="teamId"><%=team.teamId%></td>
                    <td class="alias"><%=team.alias%></td>
                    <td class="ptsDelta"><%=team.ptsDelta%></td>
                    <td class="ptsDay"><%=team.ptsDay%></td>
                    <td class="ptsWeek"><%=team.ptsWeek%></td>
                    <td class="ptsTotal"><%=team.ptsTotal%></td>
                    <td class="wuTotal"><%=team.wuTotal%></td>
                </tr>

            </g:each>

            </tbody></table>

    </div> <!-- .widget-content -->
</div> <!-- /widget -->