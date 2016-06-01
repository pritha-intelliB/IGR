<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix = "sx" uri = "/struts-dojo-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" type="text/css" 	href="<s:url value="/include/ams.css"/>"> 
<link rel="stylesheet" type="text/css" 	href="<s:url value="/include/menu.css"/>">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script language="JavaScript1.2" src="../js/AMS.js"></script>
<body style="margin-top: 5px; margin-left: 10px;">

	<%
		String dispName = (String) request.getSession().getAttribute(
				"_DISPLAYNAME");
		String branchName = (String) request.getSession().getAttribute(
				"_BRANCHNAME");
		
		String groupName = (String) request.getSession().getAttribute(
				"_USERGROUP");
		
		
		javax.servlet.http.Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("DISPLAYNAME")) {
					dispName = cookies[i].getValue();
				} else if (cookies[i].getName().equals("BRANCHNAME")) {
					branchName = cookies[i].getValue();
				}
				 else if (cookies[i].getName().equals("GROUPID")) {
					 groupName = cookies[i].getValue();
					}
			}
		}
	%>


	<div align="left">
		<div id="appContainer"
			style="width: 100%; border: 1px solid midnightblue; background-color: #FFDDDD;">
			<div align="center" class="appHeader">
				<I><U>KIBSL - Business Unit :: General Insurance</U></I>
			</div>
			