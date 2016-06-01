<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr" />
<%@ page contentType="text/html;charset=UTF-8"%>
<sx:head />
</head>
<body>
	<s:form action="FeeMasterEntry" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">Fee Master Entry</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Deed_Category')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="deedList" listKey="typeCode"
							listValue="typeDesc" name="deedCategoryID" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="deedCategoryID" theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.fee_name')" />*:</td>
					<td class="field"><s:textfield name="fee_name"
							cssClass="field" id="fee_name" required="true" theme="simple"
							maxlength="20" onblur="this.value=this.value.toUpperCase();">
						</s:textfield> <s:fielderror fieldName="fee_name" theme="igr"
							cssClass="smallErrorMsg" />
				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.fee_rate')" />*:</td>
					<td class="field"><s:textfield name="fee_rate" cssClass="field"
							id="fee_val" required="true" theme="simple" maxlength="10">
							<s:fielderror fieldName="fee_rate" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="stampValueList" name="fee_unit" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="fee_unit" theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>
				
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.on_value')" />*:</td>
					<td class="field"><s:textfield name="on_value"
							cssClass="field" id="on_value" required="true" theme="simple"
							maxlength="20" onblur="this.value=this.value.toUpperCase();">
						</s:textfield> <s:fielderror fieldName="on_value" theme="igr"
							cssClass="smallErrorMsg" />
				</tr>
						</table>





			<div align="center">
				<s:submit method="addFeeMaster" cssClass="button" value="Submit"
					theme="simple" />
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitFeeMaster';">
			</div>
			
	</s:form>
</body>

</html>
<%@include file="../commonJsp/footer.inc"%>
