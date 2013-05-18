<%@ page contentType="text/html;charset=UTF-8" %>
<div class="widget stacked widget-table">

    <div class="widget-header">
        <span class="icon-list-alt"></span>

        <h3>Teams</h3>
    </div> <!-- .widget-header -->

    <div class="widget-content">
        <table class="table table-bordered table-striped">

            <thead><tr>
                <th><teams:link sort="rank">Rank</teams:link></th>
                <th><teams:link sort="teamId">Team ID</teams:link></th>
                <th><teams:link sort="alias">Alias</teams:link></th>
                <th><teams:link sort="ptsDelta">Points (Last Update)</teams:link></th>
                <th><teams:link sort="ptsDay">Points (Day)</teams:link></th>
                <th><teams:link sort="ptsWeek">Points (Week)</teams:link></th>
                <th><teams:link sort="ptsTotal">Points (Total)</teams:link></th>
                <th><teams:link sort="wusTotal">Work Units (Total)</teams:link></th>
            </tr></thead>

            <tbody>

            <g:each in="${teams.results}" var="team">

                <tr>
                    <td>
                        <span class="rank"><g:formatNumber number="${team.rank}" type="number" maxFractionDigits="0" /></span> (<span class="rankDelta"><g:formatNumber number="${team.rankDelta}" type="number" maxFractionDigits="0" /></span>)
                    </td>
                    <td class="teamId"><g:formatNumber number="${team.teamId}" type="number" maxFractionDigits="0" /></td>
                    <td class="alias"><%=team.alias%></td>
                    <td class="ptsDelta"><g:formatNumber number="${team.ptsDelta}" type="number" maxFractionDigits="0" /></td>
                    <td class="ptsDay"><g:formatNumber number="${team.ptsDay}" type="number" maxFractionDigits="0" /></td>
                    <td class="ptsWeek"><g:formatNumber number="${team.ptsWeek}" type="number" maxFractionDigits="0" /></td>
                    <td class="ptsTotal"><g:formatNumber number="${team.ptsTotal}" type="number" maxFractionDigits="0" /></td>
                    <td class="wuTotal"><g:formatNumber number="${team.wuTotal}" type="number" maxFractionDigits="0" /></td>
                </tr>

            </g:each>

            </tbody></table>

    </div> <!-- .widget-content -->
</div> <!-- /widget -->