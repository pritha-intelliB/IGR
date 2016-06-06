<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body>
	<s:form action="IssueSecondTokenAction" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">Issue Second Token</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />


				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Token_No')" />*:</td>
					<td class="field"><s:textfield name="token_no"
							cssClass="shortfieldrowwise readOnlyField" readonly="true"
							theme="simple" maxlength="20">
							<s:fielderror fieldName="token_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


					<td class="tdLabel"><s:property value="getText('global.name')" />*:</td>
					<td class="field"><s:textfield name="presenter_name"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="presenter_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.first_party_name')" />*:</td>
					<td class="field"><s:textfield
							name="first_party_executant_name" cssClass="field"
							required="true" theme="simple" maxlength="20"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="first_party_executant_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.first_capacity')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="firstPartyCapacityList" listKey="typeCode"
							listValue="typeDesc" name="first_party_executant_capacity"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="first_party_executant_capacity" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.district')" />*:</td>
					<td><s:select list="districtList" listKey="typeCode"
							listValue="typeDesc" name="district_id" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
					</td>

					<td class="tdLabel"><s:property
							value="getText('global.sub_register_office')" />*:</td>
					<td><s:select list="dsrLocationList" listKey="typeCode"
							listValue="typeDesc" name="dsr_location" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="dsr_location" theme="igr" cssClass="smallErrorMsg" />
					</td>
				</tr>
				<tr>
				<td class="tdLabel"><s:property
							value="getText('global.stamp_type')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="stampTypeList" listKey="typeCode"
							listValue="typeDesc" name="stamp_type"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="stamp_type" theme="igr"
							cssClass="smallErrorMsg" /></td>
							
							
							<td class="tdLabel"><s:property
							value="getText('global.stamp_pages')" />*:</td>
					<td class="field"><s:textfield name="stamp_pages_no" id="stamp_pages_no"
							cssClass="shortfieldrowwise" required="true"
							theme="simple" maxlength="2" onblur="setValue(this);">
							<s:fielderror fieldName="stamp_pages_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.dummy_pages_no')" />*:</td>
					<td class="field"><s:textfield name="dummy_pages_no"
							cssClass="shortfieldrowwise" required="true"
							theme="simple" maxlength="2">
							<s:fielderror fieldName="dummy_pages_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
							<td class="tdLabel"><s:property
							value="getText('global.support_doc_total_page_no')" />*:</td>
					<td class="field"><s:textfield name="support_doc_total_page_no"
							cssClass="shortfieldrowwise" required="true"
							theme="simple" maxlength="2">
							<s:fielderror fieldName="support_doc_total_page_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>
				
				<tr>
				<td class="tdLabel"><s:property
							value="getText('global.considered_amount')" />*:</td>
					<td class="field"><s:textfield
							name="considered_amount" cssClass="field"
							required="true" theme="simple" maxlength="20">
							<s:fielderror fieldName="considered_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
						
						
					<td class="tdLabel"><s:property
							value="getText('global.paid_amount')" />*:</td>
					<td class="field"><s:textfield
							name="paid_amount" cssClass="field"
							required="true" theme="simple" maxlength="20">
							<s:fielderror fieldName="paid_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
				
				</tr>
				<tr><td class="tdLabel" colspan="2"><s:property
							value="getText('global.e_registration_id')" />*:</td>
				<td class="field" colspan="2"><s:textfield
							name="e_registration_id" cssClass="field"
							required="true" theme="simple" maxlength="22">
							<s:fielderror fieldName="e_registration_id" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>				
					
				
				</tr>
				
			</table>
			
			<div align="center"
				style="height: 200px; overflow-x: hidden" id="results">
				<table id="stampNoValue" class="shortAppFormBlock" align="center"
					cellspacing="2px" cellpadding="1px">
					<caption class="formBlockCaption">Stamp No and Stamp Value</caption>
					<s:if test="%{!stampNoValueList.isEmpty()}">
					<tr>
					<td class="tdLabel" align="center"><s:property value="getText('global.stamp_no')" />*:</td>
					<td class="tdLabel" align="center"><s:property value="getText('global.stamp_value')" />*:</td>		
					</tr>		
					
                  <s:iterator value="stampNoValueList" id="stampNoValueListID">
					<tr>
						<TD>  
						<s:textfield name="stamp_no"
							cssClass="field" id="stamp_no" value="%{typeCode}"  theme="simple"
							maxlength="10"></s:textfield>
						<TD>  
						<s:textfield name="stamp_value"
							cssClass="field" id="stamp_value" value="%{typeCode}"  theme="simple"
							maxlength="10"></s:textfield>
						</TD>
						
						
					</TR>
					</s:iterator>
                  </s:if>
                  
				</table>
			</div>
			
			
<s:hidden name="rowNumber" id="rownumber"/>

			<div align="center">
				<s:submit method="addSecondToken" cssClass="button" value="Submit"
					theme="simple" />
				<input type="button" name="Back" value="Bacck" class="button"
					onClick="window.location.href='SearchFirstTokenforSecondToken.action';">		
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitSecondToken';">
				
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
	function setValue(noOfPages) {
		
	var formInput = 'stamp_pages_no='+ noOfPages.value;
	var options= ' ';
	if((!isNaN(noOfPages.value))&&(noOfPages.value>0)){
		$.getJSON('loadStampNoValue.action', formInput, function(data) {
			if(data.rowNumber>0){
			options= '<caption class="formBlockCaption">Stamp No and Stamp Value</caption>';
			options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.stamp_no')" />*:</td><td class="tdLabel" align="center"><s:property value="getText('global.stamp_value')" />*:</td></tr>';		
			
			
			for(var i=0;i<data.rowNumber;i++ )
				{
				options+='<tr><td><input type="text" name="stamp_no" id="stamp_no" maxlength="10" class="field"></td><td><input type="text" name="stamp_value" id="stamp_value" maxlength="5" class="field"></td></tr>';
				}
			}
			 document.getElementById("rownumber").value=data.rowNumber;
			$("#stampNoValue").html(options);
			});
	}
	else{
		alert("No. of Stamp Value Sholud be greater than 1");
		 document.getElementById("stamp_pages_no").value="";
		 document.getElementById("stamp_pages_no").focus();
	}
			
		
		}
</script>	
</html>
<%@include file="../commonJsp/footer.inc"%>
