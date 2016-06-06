<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr" />
<%@ page contentType="text/html;charset=UTF-8"%>
</head>
<body>
	<s:form action="SearchSecondTokenforDeedEntry" validate="true"
		namespace="/" method="post">

		<div align="center" class="formCaption">Search Second Token</div>
		<s:actionerror cssClass="errorMsg" />
		<s:actionmessage cssClass="infoMsg" />
		<div align="center"
			style="height: 100px; width: 100%; overflow-x: hidden">
			<s:if test="%{!tokenModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Token
						Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_No')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.first_party_name')" /></TD>
					</tr>
					<s:iterator value="tokenModelList" id="tokenModelListList">
						<tr>
							<td class="fieldrowwise" align="center"><s:url
									action="DeedDetailEntryAction.action" id="deedDetail">

									<s:param name="token_date">
										<s:property value="token_date" />
									</s:param>

									<s:param name="token_time">
										<s:property value="token_time" />
									</s:param>

									<s:param name="token_no">
										<s:property value="token_no" />
									</s:param>
									<s:param name="presenter_name">
										<s:property value="presenter_name" />
									</s:param>

									<s:param name="first_party_executant_name">
										<s:property value="first_party_executant_name" />
									</s:param>

									<s:param name="first_party_executant_capacity">
										<s:property value="first_party_executant_capacity" />
									</s:param>


									<s:param name="district_id">
										<s:property value="district_id" />
									</s:param>

									<s:param name="dsr_location">
										<s:property value="dsr_location" />
									</s:param>
									
									<s:param name="considered_amount">
										<s:property value="considered_amount" />
									</s:param>
									
										
									<s:param name="no_total_pages">
										<s:property value="original_deed_total_page_no" />
									</s:param>
									
									<s:param name="e_registration_code">
										<s:property value="e_registration_id" />
									</s:param>
									
									<s:param name="presented_stamp_value">
										<s:property value="stamp_no_with_val" />
									</s:param>
									

								</s:url> <s:a href="%{deedDetail}">
									<font color="BLUE"><s:property value="token_no" /></font>
								</s:a></td>
							<td class="longfieldrowwise" align="left"><s:property
									value="presenter_name" /></td>

							<td class="longfieldrowwise" align="left"><s:property
									value="first_party_executant_name" /></td>


						</tr>
					</s:iterator>
				</table>
			</s:if>


			<br> <br>
			<div align="center">
				<s:submit method="exitSearchSecondTokenForDeedEntry"
					cssClass="button" value="Exit" theme="simple" />
			</div>
		</div>
		<s:hidden name="event" />
	</s:form>
</body>

</html>
<%@include file="../commonJsp/footer.inc"%>
