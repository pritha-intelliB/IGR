<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr" />
<%@ page contentType="text/html;charset=UTF-8"%>
<sx:head />
</head>
<body>
	<s:form action="FeeMasterEdit" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">Fee Master Edit</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
				<tr>
				<td align="center">
				<s:if test="feeMasterList.size() > 0">
				<div align="center"
								style="height: 150px; width: 350px; overflow-x: hidden"
								id="results">
								
				<table id="deedCategoryTable" class="smallAppFormBlock"
									align="center" border="1">
									
					<caption class="formBlockCaption">Fee Name :~</caption>
					<s:iterator value="feeMasterList" status="status">
					<tr>
							<td class="shortfieldrowwise">
							 <a href="#" id="add"
												onclick="setValue('<s:property value="fee_id" />',
												               '<s:property value="deed_category_id" />',
												               '<s:property value="fee_name" />',
												               '<s:property value="fee_val" />',
												               '<s:property value="fee_unit" />',
												               '<s:property value="depends_on" />')">
							<font color="BLUE"><s:property value="fee_name" /></font></a>
							
							
							</td>
					</tr>
					</s:iterator>
					
					</table>
					</div>
				</s:if>	
				</td>
				</tr>
				<tr><td>-</td></tr>
                     <tr>
					<td align="center">

						<div align="center">
							<table align="center" cellspacing="2px"
				cellpadding="1px" border="1">
							<caption class="formBlockCaption">Fee Master Detail :~</caption>
							<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Deed_Category')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="deedList" listKey="typeCode"
							listValue="typeDesc" name="deedCategoryID" id="deedCategoryID" cssClass="combobox"
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
							list="stampValueList" listKey="typeCode"
							listValue="typeDesc" name="fee_unit" id="fee_unit" cssClass="combobox"
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
				
				
				
				
				<s:hidden name="fee_id" id="fee_id" />
							</table>
						</div>
				</td>
				
				</tr>	
			</table>
			




			<div align="center">
				<s:submit method="updateFeeMaster" cssClass="button" value="Update"
					theme="simple" />
				<s:submit method="deleteFeeMaster" cssClass="button" value="Delete"
					theme="simple" />
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitFeeMasterEdit';">
			</div>
	</div>		
	</s:form>
</body>
<script type="text/javascript">
	function setValue(fee_id,deed_category_id,fee_name,fee_val,fee_unit,depends_on) {
		document.getElementById('fee_id').value=fee_id;
		document.getElementById('deedCategoryID').value=deed_category_id;
		document.getElementById('fee_val').value=fee_val;
		document.getElementById('fee_unit').value=fee_unit;
		document.getElementById('on_value').value=depends_on;
		document.getElementById('fee_name').value=fee_name;
		
	}
</script>

</html>
<%@include file="../commonJsp/footer.inc"%>
