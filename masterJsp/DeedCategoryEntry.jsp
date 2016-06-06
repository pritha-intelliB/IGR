<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr" />
<%@ page contentType="text/html;charset=UTF-8"%>
<sx:head />
</head>
<body>
	<s:form action="DeedCategoryEntry" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">Deed Category Entry</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="deedList" listKey="typeCode"
							listValue="typeDesc" name="deedID" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="deedID" theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Deed_Category')" />*:</td>
					<td class="field"><s:textfield name="category_name"
							cssClass="field" id="category_name" required="true" theme="simple"
							maxlength="20" onblur="this.value=this.value.toUpperCase();">
						</s:textfield> <s:fielderror fieldName="category_name" theme="igr"
							cssClass="smallErrorMsg" />
				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Stamp_Value')" />*:</td>
					<td class="field"><s:textfield name="stamp_fee" cssClass="field"
							id="fee_val" required="true" theme="simple" maxlength="10">
							<s:fielderror fieldName="stamp_fee" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="stampValueList" listKey="typeCode"
							listValue="typeDesc" name="stamp_unit" id="stamp_unit" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="stamp_unit" theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>
						</table>





			<div align="center">
				<s:submit method="addDeedCategory" cssClass="button" value="Submit"
					theme="simple" />
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitDeedCategory';">
			</div>
		</div>	
			
	</s:form>
</body>

</html>
<%@include file="../commonJsp/footer.inc"%>
