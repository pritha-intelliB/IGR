<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body>
	<s:form action="IssueFirstTokenAction" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">Issue First Token</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />




				<td class="tdLabel"><s:property value="getText('global.name')" />*:</td>
				<td class="field"><s:textfield name="presenterName"
						cssClass="field" required="true" key="global.username"
						theme="simple" maxlength="20"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="presenterName" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.token_for')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="tokenForValueList" listKey="typeDesc" listValue="typeCode"
							name="tokenFor" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="tokenFor"
							theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.date_time')" />*:</td>
					<td class="field"><s:textfield name="currentDateTime"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="2">
						</s:textfield>
						<s:fielderror fieldName="currentDateTime" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr>
			</table>

			<div align="center">
				<s:submit method="addFirstToken" cssClass="button" value="Submit"
					theme="simple" />
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitSecondToken';">
			</div>
	</s:form>
</body>
</html>
<%@include file="../commonJsp/footer.inc"%>
