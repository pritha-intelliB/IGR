package com.igr.registration;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonThriceOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IssueSecondTokenAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	// START OF PAGE VARIABLE
	private String event;
	private String firstTokenNo;
	private String firstTokenDate;
	public String getFirstTokenDate() {
		return firstTokenDate;
	}

	public void setFirstTokenDate(String firstTokenDate) {
		this.firstTokenDate = firstTokenDate;
	}

	private String presenterName;
	private String tokenFor;
	private String counterNo;
	private String onlineApplicationID;
	private String eStampCertificate;
	private boolean edit;
	private userLogModel userLog;
	// END OF PAGE VARIABLE

	public userLogModel getUserLog() {
		return userLog;
	}

	public void setUserLog(userLogModel userLog) {
		this.userLog = userLog;
	}

	// START OF SESSION VARIABLE
	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String language = "";
	// END OF SESSION VARIABLE

	// START OF PAGE DROPDOWN LIST VARIABLE
	//private List<String> tokenForValueList;
	// END OF PAGE DROPDOWN LIST VARIABLE

	// START OF SERVLET VARIABLE
	private ServletContext context;
	private HttpServletRequest request;
	// END OF SERVLET VARIABLE

	// START OF CLASS OBJECT INITILIZATION
	private static CommonValidation validator = new CommonValidation();
	HibernateManager manager = new HibernateManager();
	userLogModel logModel = new userLogModel();
	private static final Logger log = Logger.getLogger(IssueSecondTokenAction.class);
	// END OF CLASS OBJECT INITILIZATION

	// START OF GETTER-SETTER METHOD
	
	
	
	
	
	public String getPresenterName() {
		return presenterName;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getFirstTokenNo() {
		return firstTokenNo;
	}

	public void setFirstTokenNo(String firstTokenNo) {
		this.firstTokenNo = firstTokenNo;
	}

	public void setPresenterName(String presenterName) {
		this.presenterName = presenterName;
	}

	public String getTokenFor() {
		return tokenFor;
	}

	public void setTokenFor(String tokenFor) {
		this.tokenFor = tokenFor;
	}

	public String getCounterNo() {
		return counterNo;
	}

	public void setCounterNo(String counterNo) {
		this.counterNo = counterNo;
	}

	public String getOnlineApplicationID() {
		return onlineApplicationID;
	}

	public void setOnlineApplicationID(String onlineApplicationID) {
		this.onlineApplicationID = onlineApplicationID;
	}

	public String geteStampCertificate() {
		return eStampCertificate;
	}

	public void seteStampCertificate(String eStampCertificate) {
		this.eStampCertificate = eStampCertificate;
	}

	// END OF GETTER-SETTER METHOD

	
	
	// START OF IMPLEMENTED METHOD
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	

	@SuppressWarnings("rawtypes")
	@SkipValidation
	
	// START OF EXECUTE METHOD
	public String execute() throws Exception {
		empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		int returnMessage=1;
		String returnValue=SUCCESS;
		

		if (isEdit()) {

			Date currentDateValue = new Date();
			logModel.setUser_id(Integer.parseInt((empID)));
			logModel.setUser_action("Issue_Second_Token");
			logModel.setUser_log_comment("");
			logModel.setLog_datetime(currentDateValue);
			this.setUserLog(logModel);
			returnMessage=manager.addUserLog(getUserLog());
			this.setEdit(false);
		}

		
		Locale locale = new Locale(language);
		ActionContext.getContext().setLocale(locale);
		
		if(returnMessage==1)
			returnValue=SUCCESS;

		else if(returnMessage==0){
			this.addActionError(getText("System Error Occured"));
			returnValue= "home";
		}
         return returnValue;
		


	}
	// END OF EXECUTE METHOD

/*
// START OF METHOD TO INSERT NEW CORPORATE CUSTOMER
	public String addLead() {
		String returnMessage = "";
		String insertOperationMessage = "";
		boolean operationFlag = false;
		try {

			assignToEmployee = assignToEmployee.substring(0,
					assignToEmployee.indexOf("~"));
			insertOperationMessage = insertOperation.insertNewLead(title,
					firstName, middleName, lastName, address1, address2, state,
					sdf.format(nextCallDate), district, pinCode, mobileNumber,
					specificInterest, assignToEmployee, leadStatus, branchCode,
					empID, remarks);

			if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("1")) {
				operationFlag = true;
			}

			else if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("0")) {
				operationFlag = false;
			}

			returnMessage = insertOperationMessage.substring(1,
					insertOperationMessage.trim().length() - 1);

		} catch (Exception e) {
			this.addActionError("System error Occured");
			log.fatal("Exception---", e);
			return "home";
		}

		if (operationFlag) {
			emptyField("ENTRY");
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}
	}

	// END OF METHOD TO INSERT NEW CORPORATE CUSTOMER

	// START OF JSON METHOD TO LOAD DISTRICT DEPENDING ON STATE
	@SuppressWarnings({ "rawtypes" })
	@SkipValidation
	public String loadDistrictAction() throws Exception {
		if (state != null) {
			districtList = new ArrayList<String>();
			List districtItaratorList = new ArrayList<String>();
			districtItaratorList = (List) context.getAttribute("DISTRICTLOV");
			districtList = helper.extractFromItarator(true, state,
					districtItaratorList);
		}
		return SUCCESS;
	}

	// END OF JSON METHOD TO LOAD DISTRICT DEPENDING ON STATE
*/
	// START OF METHOD TO EXIT FROM PAGE
	@SkipValidation
	public String exitSecondToken() throws Exception {
		return "home";
	}
	// END OF METHOD TO EXIT FROM PAGE

	
	/*
	public String addSecondToken() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "";
		boolean operationFlag = false;
		try {

			assignToEmployee = assignToEmployee.substring(0,
					assignToEmployee.indexOf("~"));
			insertOperationMessage = insertOperation.updateLeadFollowup(title,
					address1, address2, state, sdf.format(nextCallDate),
					district, pinCode, callDate, specificInterest,
					assignToEmployee, leadStatus, branchCode, empID, outcomes,
					leadID, srlNo, mobileNumber, leadFollowupStatus);

			if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("1")) {
				operationFlag = true;
			}

			else if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("0")) {
				operationFlag = false;
			}

			returnMessage = insertOperationMessage.substring(1,
					insertOperationMessage.trim().length());

		} catch (Exception e) {
			log.fatal("Exception---", e);
			return "home";
		}

		if (operationFlag) {
			emptyField("EDIT");
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}
*/
	public void validate() {
		try {
			this.setEdit(false);
			this.execute();

			// START OF VALIDATION
			if ((empID == null) || (branchCode == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (branchCode.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));
			}

			else if (!validator.requiredFiledValidate(firstTokenNo.trim())) {
				this.addFieldError("firstTokenNo", "First Token No. Can't be empty");
			}
			
			   else if (!validator.requiredFiledValidate(presenterName.trim())) {
					this.addFieldError("presenterName", "Name can't be empty");

				}else if (!validator.languageValidate(presenterName.trim(),
						this.language)) {
					this.addFieldError("presenterName",
							"Pl. Input in Proper Language");

				} else if (!validator.validateNameField(presenterName.trim(),
						this.language)) {
					this.addFieldError("presenterName",
							"Presenter Name is not valid");
				}
				else if (!validator.requiredFiledValidate(tokenFor.trim())) {
					this.addFieldError("tokenFor", "Token for is Required");

				} else if (!validator.requiredFiledValidate(counterNo.trim())) {
					this.addFieldError("counterNo", "Counter No is Required");

				} else if (!validator.neumericFiledValidate(
						counterNo.trim())) {
					this.addFieldError("counterNo",
							"Counter No. is not Valid");
				}
			

			// END OF VALIDATION
		} catch (Exception e) {
			this.addActionError("System error Occured");
			log.fatal("Exception---", e);
		}
	}

	public void emptyField(String event) {
		this.setPresenterName("");
		this.setTokenFor("");
		this.setCounterNo("");
		this.setOnlineApplicationID("");
		this.seteStampCertificate("");
	}
	
	
	
	@SkipValidation
	public String getDataValue() throws Exception {
		presenterName = "";	
		if( (this.firstTokenNo != null)&& (this.firstTokenDate != null)) {
		presenterName = "nirmalya banerjee";
		tokenFor="Purchase";
	}
		return SUCCESS;
	}
}