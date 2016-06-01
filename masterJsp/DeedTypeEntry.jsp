<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr" />
<%@ page contentType="text/html;charset=UTF-8"%>
<sx:head />
</head>
<body>
	<s:form name="DeedTypeForm" action="DeedTypeEntry" validate="true" namespace="/"
		method="post">
		<s:token />
            
		<div align="center" class="formCaption">Deed Type Entry</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td class="field"><s:textfield name="deed_name"
							cssClass="field" id="deed_name" required="true"  theme="simple"
							maxlength="10">
						</s:textfield> <s:fielderror fieldName="deed_name" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Deed_Code')" />*:</td>
					<td class="field"><s:textfield name="deed_code"
							cssClass="field" id="deed_code" required="true" theme="simple"
							maxlength="2" onblur="this.value=this.value.toUpperCase();">
						</s:textfield> <s:fielderror fieldName="deed_code" theme="igr"
							cssClass="smallErrorMsg" />
				</tr>
				
				<!--  
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Stamp_Value')" />*:</td>
					<td class="field"><s:textfield name="fee_val"
							cssClass="field" id="fee_val" required="true" theme="simple"
							maxlength="10">
							<s:fielderror fieldName="fee_val" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="stampValueList" name="depends_on" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="depends_on" theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>
				-->
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Property_Required')" />*:</td>
						<td class="field"><s:select headerKey="" headerValue="Select"
							list="propertyRequiredList" listKey="typeDesc" listValue="typeCode"
							name="property_details" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="property_details"
							theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>

				<tr>
					<td class="tdLabel"><s:property value="getText('global.Book')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="bookTypeList" name="book_id" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror fieldName="book_id"
							theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>

			</table>



			<div align="center"
				style="height: 200px; width: 450px; overflow: auto" id="results">
				<table id="partyTypeTable" class="shortAppFormBlock" align="center"
					cellspacing="2px" cellpadding="1px">
					<caption class="formBlockCaption">Party Type</caption>
					<s:if test="%{!validationPartyName.isEmpty()}">
                  <s:iterator value="validationPartyName" id="validationPartyNameID">
					<tr>
						<TD>  
						<s:textfield name="partyTypeValue"
							cssClass="field" id="partyTypeValue" value="%{typeCode}"  theme="simple"
							maxlength="10"></s:textfield>
						</TD>
						<TD><INPUT type="button" value="+"
							onclick="addRow('partyTypeTable');" /></TD>
						<TD><INPUT type="button" value="-" onclick="deleteRow('1');" /></TD>
					</TR>
					</s:iterator>
                  </s:if>
                  
				</table>
			</div>


			<div align="center">
			  <s:submit method="addDeedType" cssClass="button" value="Submit"  theme="simple"/>			
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitDeedType';">
			</div>
			<s:hidden name="rowNumber" id="rownumber"/>
			<s:hidden name="rowIndex" id="rowIndex"/>
			<s:hidden name="action" id="action"/>
	</s:form>
</body>

</html>
<script>
	function addRow(tableID) {
		var table = document.getElementById(tableID);
		 var rowCount = table.rows.length;
		 var row = table.insertRow(rowCount)

		 
		var cell1 = row.insertCell(0);
		var houseNo = document.createElement("input");
		houseNo.type = "text";
		houseNo.name = "partyTypeValue";
		houseNo.setAttribute("class", "field");
		cell1.appendChild(houseNo);

		var cell2 = row.insertCell(1);
		var buttonAdd = document.createElement("input");
		buttonAdd.type = "button";
		buttonAdd.value = "+";
		buttonAdd.setAttribute("onClick",
				"javascript: addRow('partyTypeTable');");
		cell2.appendChild(buttonAdd);

		var cell3 = row.insertCell(2);
		var buttonDelete = document.createElement("input");
		buttonDelete.type = "button";
		buttonDelete.value ="-";
		buttonDelete.setAttribute("onClick", "javascript:deleteRow("+(rowCount+1) + ")");
		cell3.appendChild(buttonDelete);
		
	 document.getElementById("rownumber").value=rowCount+1;

	}
	function deleteRow(count) {
		document.getElementById("rowIndex").value=count;
		document.getElementById("action").value="delete";
		alert(document.getElementById("rowIndex").value);
		document.DeedTypeForm.submit();
	}
	
</script>
<%@include file="../commonJsp/footer.inc"%>
