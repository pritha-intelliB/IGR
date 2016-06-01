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


				<tr>
				<td class="tdLabel"><s:property value="getText('global.name')" />*:</td>
				<td class="field"><s:textfield name="presenter_name"
						cssClass="field" required="true"
						theme="simple" maxlength="20"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="presenter_name" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
			<td class="tdLabel"><s:property value="getText('global.relation')" />*:</td>
				<td class="field">
					<s:select headerKey="" headerValue="Select"
					list="relationList" required="true"
					name="presenter_fh_rel" cssClass="field" theme="simple"/>
					<s:fielderror fieldName="presenter_fh_rel" theme="igr"
							cssClass="smallErrorMsg" />
				</td>
				</tr>
				<tr>
				<td class="tdLabel"><s:property value="getText('global.gurdianname')" />*:</td>
				<td class="field"><s:textfield name="presenter_fh_name"
						cssClass="field" required="true"
						theme="simple" maxlength="20"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="presenter_fh_name" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
				
				<td class="tdLabel"><s:property value="getText('global.address')" />*:</td>
				<td class="field"><s:textfield name="presenter_address"
						cssClass="field" required="true"
						theme="simple" maxlength="40"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="presenter_address" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.state')" />*:</td>
					<td class="field"><s:select headerKey="0" headerValue="Select"
							list="stateList" listKey="typeCode" listValue="typeDesc"
							name="presenter_state" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="presenter_state"
							theme="igr" cssClass="smallErrorMsg" /></td>
							
				  <td class="tdLabel"><s:property value="getText('global.pin')" />*:</td>
				<td class="field"><s:textfield name="presenter_pin"
						cssClass="field" required="true"
						theme="simple" maxlength="6">
						<s:fielderror fieldName="presenter_pin" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
							
				</tr>
				
				<tr>
 <td class="tdLabel"><s:property value="getText('global.district')" />*:</td>
<td>
<s:select 				list="districtList" listKey="typeCode" listValue="typeDesc"
							name="district_id" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="district_id"
							theme="igr" cssClass="smallErrorMsg" />
</td>
				
 <td class="tdLabel"><s:property value="getText('global.sub_register_office')" />*:</td>
<td>
<s:select 				list="dsrLocationList" listKey="typeCode" listValue="typeDesc"
							name="dsr_location" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="dsr_location"
							theme="igr" cssClass="smallErrorMsg" />
</td>
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
