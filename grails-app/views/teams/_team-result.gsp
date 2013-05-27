<%@ page contentType="text/html;charset=UTF-8" %>
<tr>
    <td>
        <span class="rank"><g:formatNumber number="${team.rank}" type="number"
                                           maxFractionDigits="0"/></span> (<span
            class="rankDelta"><g:formatNumber number="${team.rankDelta}" type="number"
                                              maxFractionDigits="0"/></span>)
    </td>
    <td class="teamId"><g:formatNumber number="${team.teamId}" type="number"
                                       maxFractionDigits="0"/></td>
    <td class="alias"><g:link mapping="teamDetails" params="[teamId:team.teamId.toLong()]"><%=team.alias%></g:link></td>

    <td class="ptsDelta"><g:formatNumber number="${team.ptsDelta}" type="number"
                                         maxFractionDigits="0"/></td>
    <td class="ptsDay"><g:formatNumber number="${team.ptsDay}" type="number"
                                       maxFractionDigits="0"/></td>
    <td class="ptsWeek"><g:formatNumber number="${team.ptsWeek}" type="number"
                                        maxFractionDigits="0"/></td>
    <td class="ptsTotal"><g:formatNumber number="${team.ptsTotal}" type="number"
                                         maxFractionDigits="0"/></td>
    <td class="wuTotal"><g:formatNumber number="${team.wuTotal}" type="number"
                                        maxFractionDigits="0"/></td>
</tr>