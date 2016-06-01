<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet" type="text/css"
	href="<s:url value="/include/ams.css"/>">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/include/menu.css"/>">
<script language="JavaScript1.2"
	src="<s:url value="/include/jquery.min.js"/>"></script>
<script language="JavaScript1.2" src="<s:url value="/include/AMS.js"/>"></script>
<body style="margin-top: 5px; margin-left: 10px;">

	<%
	
		String dispName = (String) request.getSession().getAttribute(
				"DISPLAYNAME");
		String branchName = (String) request.getSession().getAttribute(
				"LOCATIONNAME");

		String groupName = (String) request.getSession().getAttribute(
				"_USERGROUP");
		
			
	%>


	<div align="center">
		<div id="appContainer"
			style="width: 90%; border: 1px solid midnightblue; background-color: #CCCCFF;">
			<div align="center" class="appHeader">
				<font face="Curlz MT" size="15"><b><I>e</I></b></font><font face="Blackadder ITC" size="6"><b><i>-Nibandhan</i></b></font> 
			</div>
			<div class="userIntro" style="width: 100%;">
				<table cellpadding="0" cellspacing="0" style="width: 90%;">
					<tr>
						<td class="userIntroText">Welcome : <%
							out.print(dispName);
						%>, Location : <%
							out.print(branchName);
						%>
						</td>
						<td class="userIntroText"
							style="text-align: right; color: white;"><a
							style="color: white;" href="'logOut';"><B><I>Logout</I></B></a></td>
							
					</tr>
				</table>
			</div>
			<div align="left">
				<%
					if (groupName.equals("1")) {
				%>
				<%@include file="menu_all.html"%>
				<%
					} %>
						
						
			</div>