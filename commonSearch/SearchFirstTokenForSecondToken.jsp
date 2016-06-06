<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr" />
<%@ page contentType="text/html;charset=UTF-8"%>
</head>
<body>
	<s:form action="SearchFirstTokenforSecondToken" validate="true" namespace="/"
		method="post">

		<div align="center" class="formCaption">Search Provisional Token</div>
<s:actionerror cssClass="errorMsg"/>
<s:actionmessage cssClass="infoMsg"/>
		<div align="center"  style="height:100px; width: 100%; overflow-x: hidden">
			<s:if test="%{!tokenModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Provisional Token Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.Token_No')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.gurdianname')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.address')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.pin')" /></TD>
					</tr>
					<s:iterator value="tokenModelList" id="tokenModelListList">
						<tr>
							<td class="fieldrowwise" align="center">
							
										 						
									<s:url action="IssueSecondTokenAction.action"
										id="secondToken">
										<s:param name="token_no">
											<s:property value="token_no" />
										</s:param>
										<s:param name="presenter_name">
											<s:property value="presenter_name" />
										</s:param>										
									</s:url>
									<s:a href="%{secondToken}">
							<font color="BLUE"><s:property value="token_no" /></font>			
									</s:a>
							</td>
							<td class="longfieldrowwise" align="left"><s:property
									value="presenter_name" /></td>
							
								<td class="longfieldrowwise" align="left"><s:property
									value="presenter_fh_name" /></td>
									
									<td class="longfieldrowwise" align="left"><s:property
									value="presenter_address" /></td>
							
							<td class="fieldrowwise" align="center"><s:property
									value="presenter_pin" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>


			<br> <br>
			<div align="center">
				<s:submit method="exitSearchFirstTokenForSecondToken" cssClass="button" value="Exit"
					theme="simple" />
			</div>
		</div>
		<s:hidden name="event" />
	</s:form>
</body>

</html>
<%@include file="../commonJsp/footer.inc"%>
