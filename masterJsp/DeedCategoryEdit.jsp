<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr" />
<%@ page contentType="text/html;charset=UTF-8"%>
<sx:head />
</head>
<body>
	<s:form action="DeedCategoryEdit" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">Deed Category Edit</div>

		<div align="center">
			<table class="appFormBlock" align="center">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
				<tr>
					<td align="center"><s:if test="deedCategoryList.size() > 0">
							<div align="left"
								style="height: 150px; width: 350px; overflow-x: hidden"
								id="results">
								<table id="deedCategoryTable" 
									align="center" border="1"  style="height: 150px; width: 250px">
				
					<caption class="formBlockCaption">Deed Category :~</caption>
									
									<s:iterator value="deedCategoryList" status="status">
										<tr>
											<td class="shortfieldrowwise">
												 <a href="#" id="add"
												onclick="setValue('<s:property value="deed_category_id" />',
												               '<s:property value="deed_type_id" />',
												               '<s:property value="category_name" />',
												               '<s:property value="stamp_fee" />',
												               '<s:property value="stamp_unit" />')"><s:property
														value="category_name" /></a>

											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
						</s:if></td>
						</tr>
						<tr><td>-</td></tr>
                     <tr>
					<td align="center">

						<div align="center">
							<table align="center" cellspacing="2px"
				cellpadding="1px" border="1">
				<caption class="formBlockCaption">Deed Category Detail :~</caption>
								<tr>
									<td class="tdLabel"><s:property
											value="getText('global.Deed_Type_Name')" />*:</td>
									<td class="field"><s:select headerKey=""
											headerValue="Select" list="deedList" listKey="typeCode"
											listValue="typeDesc" id="deedID" name="deedID" cssClass="combobox"
											theme="simple" required="true" /> <s:fielderror
											fieldName="deedID" theme="igr" cssClass="smallErrorMsg" /></td>
								</tr>

								<tr>
									<td class="tdLabel"><s:property
											value="getText('global.Deed_Category')" />*:</td>
									<td class="field"><s:textfield name="category_name"
											cssClass="field" id="category_name" required="true"
											theme="simple" maxlength="20"
											onblur="this.value=this.value.toUpperCase();">
										</s:textfield> <s:fielderror fieldName="category_name" theme="igr"
											cssClass="smallErrorMsg" />
								</tr>
								<tr>
									<td class="tdLabel"><s:property
											value="getText('global.Stamp_Value')" />*:</td>
									<td class="field"><s:textfield name="stamp_fee"
											cssClass="field" id="fee_val" required="true" theme="simple"
											maxlength="10">
											<s:fielderror fieldName="stamp_fee" theme="igr"
												cssClass="smallErrorMsg" />
										</s:textfield></td>
									<td class="field"><s:select headerKey=""
											headerValue="Select" list="stampValueList" name="stamp_unit" id="stamp_unit"
											cssClass="combobox" theme="simple" required="true" /> <s:fielderror
											fieldName="stamp_unit" theme="igr" cssClass="smallErrorMsg" /></td>
								</tr>
								<s:hidden name="deedCategoryID" id="deedCategoryID" />
							</table>
						</div>

					</td>
					 
				</tr>
			</table>





			<div align="center">
				<s:submit method="updateDeedCategory" cssClass="button" value="Update"
					theme="simple" />
				<s:submit method="deleteDeedCategory" cssClass="button" value="Delete"
					theme="simple" />	
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitDeedCategoryEdit';">
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
	function setValue(deed_category_id,deed_type_id,category_name,stamp_fee,stamp_unit) {
		alert(deed_category_id);
		document.getElementById('deedCategoryID').value=deed_category_id;
		document.getElementById('deedID').value=deed_type_id;
		document.getElementById('category_name').value=category_name;
		document.getElementById('fee_val').value=stamp_fee;
		document.getElementById('stamp_unit').value=stamp_unit;
		
	}
</script>


</html>
<%@include file="../commonJsp/footer.inc"%>
