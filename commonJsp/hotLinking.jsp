<%@include file="header.jsp" %>
<table align="center" height="400px">
  <tr valign="top" align="left">
    <td>
<font color="RED"><%= request.getAttribute("error") %></font>
</td>
  </tr>
</table>
<%@include file="footer.inc" %>