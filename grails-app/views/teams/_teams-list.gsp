<%@ page contentType="text/html;charset=UTF-8" %>
<div class="widget stacked">
    <div class="widget-header">
        <span class="icon-list-alt"></span>
        <h3>Teams</h3>
    </div>
    <div class="widget-content">
        <section>
            <table class="table table-bordered table-striped table-highlight">
                <thead><tr>
                    <th><teams:link sort="rank">Rank</teams:link></th>
                    <th><teams:link sort="teamId">Team ID</teams:link></th>
                    <th><teams:link sort="alias">Alias</teams:link></th>
                    <th><teams:link sort="ptsDelta">Points (Last Update)</teams:link></th>
                    <th><teams:link sort="ptsDay">Points (Day)</teams:link></th>
                    <th><teams:link sort="ptsWeek">Points (Week)</teams:link></th>
                    <th><teams:link sort="ptsTotal">Points (Total)</teams:link></th>
                    <th><teams:link sort="wuTotal">Work Units (Total)</teams:link></th>
                </tr></thead>
                <tbody>
                <g:each in="${teams.results}" var="team">
                    <g:render template="team-result" model="['team':team]" />
                </g:each>
                </tbody></table>
        </section>
        <section>
            <custom:paginate next="Forward" prev="Back"
                             maxsteps="5" max="100"
                             action="list" total="${teams.total}"/>
        </section>
    </div>
</div>