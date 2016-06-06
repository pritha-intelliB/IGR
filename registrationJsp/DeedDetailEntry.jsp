<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body>
	<s:form action="DeedDetailEntryAction" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">Deed Detail Entry</div>

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
							name="first_party_executant_name" 
							cssClass="field readOnlyField" readonly="true"
							theme="simple" maxlength="20"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="first_party_executant_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.first_capacity')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="firstPartyCapacityList" listKey="typeCode"
							listValue="typeDesc" name="first_party_executant_capacity"
							cssClass="largecombobox" theme="simple" editable="false" /> <s:fielderror
							fieldName="first_party_executant_capacity" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr>
				<tr>
								<tr>
					<td class="tdLabel"><s:property
							value="getText('global.district')" />*:</td>
					<td><s:select list="districtList" listKey="typeCode"
							listValue="typeDesc" name="district_id" cssClass="combobox readOnlyField"
							theme="simple" required="true" /> <s:fielderror
							fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
					</td>

					<td class="tdLabel"><s:property
							value="getText('global.sub_register_office')" />*:</td>
					<td><s:select list="dsrLocationList" listKey="typeCode"
							listValue="typeDesc" name="dsr_location" cssClass="combobox readOnlyField"
							theme="simple" required="true" /> <s:fielderror
							fieldName="dsr_location" theme="igr" cssClass="smallErrorMsg" />
					</td>
				</tr>
				<tr>
			
				<td class="tdLabel"><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td class="field"><s:select headerKey="0" headerValue="Select"
							list="deedTypeList" listKey="typeCode" onchange="loadDeedCategory(this.value);"
							listValue="typeDesc" name="deed_type_id" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="deed_type_id" theme="igr" cssClass="smallErrorMsg" /></td>		
			
			
				<td class="tdLabel"><s:property
							value="getText('global.Deed_Category')" />*:</td>
					<td class="field"><s:select headerKey="0" headerValue="Select"
							list="deedCategoryList" listKey="typeCode" id="deed_category"
							listValue="typeDesc" name="deed_category_id" cssClass="combobox"
							theme="simple" required="true" onchange="loadStampValue(this.value);" /> <s:fielderror
							fieldName="deed_category_id" theme="igr" cssClass="smallErrorMsg" /></td>
							
				
				</tr>
				
				<tr>
				<td class="tdLabel"><s:property value="getText('global.considered_amount')" />*:</td>
					<td class="field"><s:textfield name="considered_amount" id="considered_amount"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="considered_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
						<td class="tdLabel"><s:property value="getText('global.applicable_stamp_value')" />*:</td>
					<td class="field"><s:textfield name="applicable_stamp_value" id="applicable_stamp_value"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="applicable_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				
			
				</tr>
				
				
				<tr>
				
				<td class="tdLabel"><s:property value="getText('global.presented_stamp_value')" />*:</td>
					<td class="field"><s:textfield name="presented_stamp_value"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="presented_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		
				
				<td class="tdLabel"><s:property value="getText('global.no_total_pages')" />*:</td>
					<td class="field"><s:textfield name="no_total_pages"
							cssClass="shortfieldrowwise readOnlyField" readonly="true" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="no_total_pages" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				
				
				</tr>
				
				
				<tr>
				
				<td class="tdLabel"><s:property value="getText('global.special_deed_detail')" />*:</td>
					<td class="field"><s:textfield name="special_deed_detail"
							cssClass="field" required="true" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="special_deed_detail" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		
						
						
				<td class="tdLabel"><s:property value="getText('global.rel_last_reg_record')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_record"
							cssClass="field"  theme="simple"
							maxlength="20">
							<s:fielderror fieldName="rel_last_reg_record" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		
						
				</tr>
				
				
				<tr>
				
				<td class="tdLabel"><s:property value="getText('global.rel_last_reg_date')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_date"
							cssClass="field"  theme="simple"
							maxlength="20">
							<s:fielderror fieldName="rel_last_reg_date" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
						
						
			<td class="tdLabel"><s:property value="getText('global.rel_last_reg_no')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_no"
							cssClass="field"  theme="simple"
							maxlength="20">
							<s:fielderror fieldName="rel_last_reg_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>			
							
				</tr>
				
				
					<tr>
				
				<td class="tdLabel"><s:property value="getText('global.rel_last_reg_pow_of_atr')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_pow_of_atr"
							cssClass="field"  theme="simple"
							maxlength="20">
							<s:fielderror fieldName="rel_last_reg_pow_of_atr" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
						
						
				<td class="tdLabel"><s:property value="getText('global.rel_last_reg_pow_of_atr_date')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_pow_of_atr_date"
							cssClass="field"  theme="simple"
							maxlength="20">
							<s:fielderror fieldName="rel_last_reg_pow_of_atr_date" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		
							
				</tr>
				
				
				<tr>
				<td class="tdLabel"><s:property value="getText('global.rel_last_reg_pow_of_atr_reg_no')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_pow_of_atr_reg_no"
							cssClass="field" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="rel_last_reg_pow_of_atr_reg_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
						<td class="tdLabel"><s:property
							value="getText('global.e_registration_id')" />*:</td>
				<td class="field" colspan="2"><s:textfield
							name="e_registration_code" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="22">
							<s:fielderror fieldName="e_registration_code" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>			
						
						
								
				</tr>	
<s:hidden name="language" id="language"/>							
			</table>
			
			
			
			<div align="center">
				<s:submit method="addDeedDetail" cssClass="button" value="Submit"
					theme="simple" />
				
				<input type="button" name="Back" value="Bacck" class="button"
					onClick="window.location.href='SearchSecondTokenforDeedEntry.action';">		
					
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitDeedDetail';">
				
			</div>
		</div>
	</s:form>
</body>
<script>
function loadDeedCategory(value)  
{
	
	  try{
	    var formInput= 'deed_type_id='+value+"&language="+document.getElementById("language").value;  
	    var options='';   
	      $("#deed_category").html(options);  
	      $.getJSON('loadCategory.action', formInput,function(data) {
	    	options = '<option selected value="">Select</option>';
	    	$.each(data.deedTypeList, function(i,item){
	    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
	        });  
	          
	        $("#deed_category").html(options);   
	    });  
	  }
	  catch(Exception)
	  {
		  alert("Error" + Exception);
	  }
	
	
}
function loadStampValue(value){
	
	  try{
		    var formInput= 'deed_category_id='+value+"&considered_amount="+document.getElementById("considered_amount").value;  
		      $.getJSON('loadStampValue.action', formInput,function(data) {
		    	  document.getElementById("applicable_stamp_value").value=data.applicable_stamp_value;
		    });  
		  }
		  catch(Exception)
		  {
			  alert("Error" + Exception);
		  }
	
}


</script>


</html>
<%@include file="../commonJsp/footer.inc"%>
