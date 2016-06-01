<%@include file="../commonJsp/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:head theme="igr"/>
<sx:head/>
</head>
<body>
<s:form action="IssueSecondTokenAction" validate="true" namespace="/" method ="post" >  
<s:token />

<div align="center" class="formCaption">Issue Second Token</div>



<div align="center">
<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px" >
<s:actionerror  theme="igr" cssClass="errorMsg"/>
<s:actionmessage theme="igr" cssClass="infoMsg"/>

<tr>
<td class="tdLabel">First Token No.*:</td>
<td class="field">
<s:textfield  name="firstTokenNo" cssClass="field" id="firstTokenNo"  required="true" theme="simple" maxlength="10" onblur="this.value=this.value.toUpperCase();"> 
</s:textfield><s:fielderror fieldName="firstTokenNo" theme="igr" cssClass="smallErrorMsg"/>
</td>
</tr>

<tr>
<td class="tdLabel">First Token Date*:</td>
<td class="field">
<s:textfield  name="firstTokenDate" cssClass="field" id="firstTokenDate"  required="true" theme="simple" maxlength="10" onblur="loadData();"> 
</s:textfield><s:fielderror fieldName="firstTokenDate" theme="igr" cssClass="smallErrorMsg"/>
</tr>
<tr>
<td class="tdLabel">Presenter/Executant's Name*:</td>
<td class="field">
<s:textfield  name="presenterName" cssClass="field readOnlyField" id="presenterName"  readonly="true"  theme="simple" maxlength="20" onblur="javascript:this.value=this.value.toUpperCase();">
<s:fielderror fieldName="presenterName" theme="igr" cssClass="smallErrorMsg"/> 
</s:textfield>
</tr>

<tr>
<td class="tdLabel">Token For:</td>
<td class="field">
<s:textfield  name="tokenFor" cssClass="field readOnlyField"  id="tokenFor" readonly="true"  theme="simple" maxlength="10" onblur="javascript:this.value=this.value.toUpperCase();"> 
</s:textfield><s:fielderror fieldName="tokenFor" theme="igr" cssClass="smallErrorMsg"/>
</td>
</tr>

<tr>
<td class="tdLabel">Counter No.*:</td>
<td class="field">
<s:textfield  name="counterNo" required="true" cssClass="field" theme="simple" maxlength="2">
</s:textfield><s:fielderror fieldName="counterNo" theme="igr" cssClass="smallErrorMsg"/>
</td>
</tr>


<tr>
<td class="tdLabel">Online Application ID(If Any):</td>
<td class="field">
<s:textfield  name="onlineApplicationID" cssClass="field"  theme="simple" maxlength="10" onblur="javascript:this.value=this.value.toUpperCase();"> 
</s:textfield><s:fielderror fieldName="onlineApplicationID" theme="igr" cssClass="smallErrorMsg"/>
</td>
</tr>


<tr>
<td class="tdLabel">e-Stamp Certificate No.(If Any):</td>
<td class="field">
<s:textfield  name="eStampCertificate" cssClass="field"  theme="simple" maxlength="10" onblur="javascript:this.value=this.value.toUpperCase();"> 
</s:textfield><s:fielderror fieldName="eStampCertificate" theme="igr" cssClass="smallErrorMsg"/>
</td>
</tr>
</table>

<div align="center">
  <s:submit method="addSecondToken" cssClass="button" value="Submit"  theme="simple"/>
 <input type="button" name="Exit" value="Exit" class="button" onClick="window.location.href='exitSecondToken';">
 </div>

</s:form>
</body>
<script>
function loadData()
{	
	
	var text='';
	var formInput = '';
	var option = '';
	if((document.getElementById('firstTokenNo').value!='')&&(document.getElementById('firstTokenDate').value!='')){
	try{
		
		 formInput ='firstTokenNo='+document.getElementById('firstTokenNo').value+"&firstTokenDate="+document.getElementById('firstTokenDate').value;
	     $.getJSON('getDataValue.action', formInput, function(data) {
	
		if((data.presenterName.value!="*")&&(data.tokenFor.value!="*")){
		document.getElementById('presenterName').value=data.presenterName;
		document.getElementById('tokenFor').value=data.tokenFor;
		}
		else{
			document.getElementById('firstTokenNo').value="";
			alert("No data found with this token No");
		}
		
	});
	} catch (Exception) {
		document.getElementById('firstTokenNo').value="";
		alert("System error Occured");	
   }
	
	}
	else{
	alert("Pl. enter the Token No and Token date.");	
	}
}	
</script>

</html>
<%@include file="../commonJsp/footer.inc"%>
