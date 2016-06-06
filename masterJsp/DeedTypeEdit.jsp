<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr" />
<%@ page contentType="text/html;charset=UTF-8"%>
<sx:head />
</head>
<body>
	<s:form action="DeedTypeEdit" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">Deed Type Edit</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
				<tr>
			<td align="center">
			<s:if test="deedTypeList.size() > 0">
				<div align="center"
								style="height: 150px; width: 350px; overflow-x: hidden"
								id="results">
				<table id="deedCategoryTable" border="1" align="center" class="smallAppFormBlock">
					<caption class="formBlockCaption">Deed Type :~</caption>
					<s:iterator value="deedTypeList">
					<tr>
							<td class="shortfieldrowwise"><a href="#" id="add"
												onclick="setValue('<s:property value="deed_type_id" />',
												               '<s:property value="deed_name" />',
												               '<s:property value="deed_code" />',
												               '<s:property value="property_details" />',
												               '<s:property value="book_id" />')"><font color="BLUE"><s:property value="deed_name" /></font></a></td>
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
				<caption class="formBlockCaption">Deed Type Detail :~</caption>
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
							cssClass="field" id="deed_code" required="true"  theme="simple"
							maxlength="2" onblur="this.value=this.value.toUpperCase();">
						</s:textfield> <s:fielderror fieldName="deed_code" theme="igr"
							cssClass="smallErrorMsg" />
				</tr>
				
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Property_Required')" />*:</td>
						<td class="field"><s:select headerKey="" headerValue="Select"
							list="propertyRequiredList" listKey="typeCode" listValue="typeDesc"
							name="property_details" id="property_details" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="property_details"
							theme="igr" cssClass="smallErrorMsg" />
							
				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Book')" />*:</td><TD><s:select headerKey="" headerValue="Select"
							list="bookTypeList" listKey="typeCode" listValue="typeDesc"
							name="book_id" id="book_id" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="book_id"
							theme="igr" cssClass="smallErrorMsg" /></td>
						
				</tr>
								
					<s:hidden name="deed_type_id" id="deed_type_id" />
			</table>
			</div>	
			<br>
				<div align="center"
				style="height: 100px; width: 450px; overflow-x: hidden" id="partyType">
				<table id="partyTypeTable" align="center">
					<caption class="formBlockCaption">Party Type</caption>
					<s:if test="%{!validationPartyName.isEmpty()}">
                  <s:iterator value="validationPartyName" id="validationPartyNameID">
					<tr>
						<TD>  
						<s:textfield name="partyTypeValue"
							cssClass="field" id="partyTypeValue" value="%{typeCode}"  theme="simple"
							maxlength="10"></s:textfield>
						</TD>
						
						<TD>  
						<s:hidden name="partyTypeID"
							cssClass="field" id="partyTypeID" value="%{typeDesc}"  theme="simple"
							maxlength="10"></s:hidden>
						</TD>
						<TD><INPUT type="button" value="+"
							onclick="addRow('');" /></TD>
						<TD><INPUT type="button" value="-" onclick="deleteRow(this);" /></TD>
					</TR>
					</s:iterator>
                  </s:if>
                 </table>
		   </div> 
				</td>	</tr>	
			</table>
			




			<div align="center">
				<s:submit method="updateDeedType" cssClass="button" value="Update"
					theme="simple" />
				<s:submit method="deleteDeedType" cssClass="button" value="Delete"
					theme="simple" />	
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitDeedTypeEdit';">
			</div>
			<s:hidden name="rowNumber" id="rownumber"/>
	</div>		
	</s:form>
</body>
<script type="text/javascript">
	function setValue(deed_type_id,deed_name,deed_code,property_details,book_id) {
		
		try{
		var formInput = 'deed_type_id='+ deed_type_id;
		var rowCount=0;
		var options= '<caption class="formBlockCaption">Party Detail :~</caption>';
		$("#partyTypeTable").html(options);
		document.getElementById('deed_type_id').value=deed_type_id;
		document.getElementById('deed_name').value=deed_name;
		document.getElementById('deed_code').value=deed_code;
		document.getElementById('property_details').value=property_details;
		document.getElementById('book_id').value=book_id;
			$.getJSON('loadParty.action', formInput, function(data) {
				$.each(data.validationPartyName, function(i, item) {
				options +='<tr><td><input type="text" name="partyTypeValue" id="partyTypeValue" maxlength="10" class="field" value="'+item.typeDesc+'"></td><td><input type="hidden" name="partyTypeID" id="partyTypeID"  value="'+item.typeCode+'"></td><td><input type="button"  value="+" onclick="addRow();"></td><td><input type="button"  value="-" onclick="deleteRow(this);"/></tr>';
				rowCount+=1;
				});
				$("#partyTypeTable").html(options);
				 document.getElementById("rownumber").value=rowCount;
			});
			
		}catch(Exception){alert(Exception);}	
			
		}
	
	function addRow() {
		var table = document.getElementById("partyTypeTable");
		 var rowCount = table.rows.length;
		 var row = table.insertRow(rowCount)

		 
		var cell1 = row.insertCell(0);
		var houseNo = document.createElement("input");
		houseNo.type = "text";
		houseNo.name = "partyTypeValue";
		houseNo.setAttribute("class", "field");
		cell1.appendChild(houseNo);
		
		var cell2 = row.insertCell(1);
		var houseNo1 = document.createElement("input");
		houseNo1.type = "hidden";
		houseNo1.name = "partyTypeID";
		cell2.appendChild(houseNo1);

		var cell3 = row.insertCell(2);
		var buttonAdd = document.createElement("input");
		buttonAdd.type = "button";
		buttonAdd.value = "+";
		buttonAdd.setAttribute("onClick",
				"javascript: addRow('partyTypeTable');");
		cell3.appendChild(buttonAdd);

		var cell4 = row.insertCell(3);
		var buttonDelete = document.createElement("input");
		buttonDelete.type = "button";
		buttonDelete.value ="-";
		buttonDelete.setAttribute("onClick", "javascript:deleteRow(this)");
		cell4.appendChild(buttonDelete);
		
	 document.getElementById("rownumber").value=rowCount+1;

	}
	function deleteRow(count) {

		var i = count.parentNode.parentNode.rowIndex;
		var table = document.getElementById('partyTypeTable');
		var noOfRows = table.rows.length;
		if(noOfRows>2){
			document.getElementById("partyTypeTable").deleteRow(i);
			document.getElementById("rownumber").value=noOfRows-1;
			
		}
	    
		else{
			alert("Minimum Two party type is required");
			
		}
	}
	
	
</script>
</html>
<%@include file="../commonJsp/footer.inc"%>
