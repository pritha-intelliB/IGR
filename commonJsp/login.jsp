<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IGR Login</title>
</head>
<body bgcolor="#CCCCFF">
	
	<div align=center>
<s:actionerror theme="igr" cssClass="errorMsg" />
<s:actionmessage theme="igr" cssClass="infoMsg" />
<s:form action="LoginAction">
<table width="300" height="100" cellspacing="0" cellpadding="0"
				border="2"  bgcolor="#D0EDFD">
				<tr>
				<td align="center" width=300 colspan="2"><b>User Login</b></td>
				</tr>
				<tr>
	<TD align="center">
<s:textfield name="userName" label="Enter Username" />
</TD></tr>
<tr>
	<TD align="center">
<s:password name="password" label="Enter Password" />
</TD></tr>
<tr>
<TD align="center">
<s:select label="Language" 
		headerKey="1" headerValue="English"
		list="#{'2':'Hindi'}" 
		name="language" />
		</TD>
		</tr>
</table>		
<br>
<s:submit value="Login" align="center" />

 </s:form>
 </div>
 
 </body>
</html>
