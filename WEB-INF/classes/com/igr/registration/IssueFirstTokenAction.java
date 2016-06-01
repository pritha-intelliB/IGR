package com.igr.registration;

import java.text.SimpleDateFormat;
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

import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonThriceOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IssueFirstTokenAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	// START OF PAGE VARIABLE
	private String event;
	private String presenterName;
	private String tokenFor;
	private String currentDateTime;

	// END OF PAGE VARIABLE

	// START OF SESSION VARIABLE
	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String language = "";
	private boolean edit;
	private userLogModel userLog;
	// END OF SESSION VARIABLE

	// START OF PAGE DROPDOWN LIST VARIABLE
	private List<CommonOptionsVO> tokenForValueList;
	// END OF PAGE DROPDOWN LIST VARIABLE

	// START OF SERVLET VARIABLE
	private ServletContext context;
	private HttpServletRequest request;
	// END OF SERVLET VARIABLE

	// START OF CLASS OBJECT INITILIZATION
	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	userLogModel logModel = new userLogModel();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");
	// private static CommonHelper helper = new CommonHelper();
     private static InsertOperation insertOperation = new InsertOperation();
	private static final Logger log = Logger
			.getLogger(IssueFirstTokenAction.class);

	// private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

	public String getCurrentDateTime() {
		return currentDateTime;
	}

	public void setCurrentDateTime(String currentDateTime) {
		this.currentDateTime = currentDateTime;
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

	public List<CommonOptionsVO> getTokenForValueList() {
		return tokenForValueList;

	}

	public userLogModel getUserLog() {
		return userLog;
	}

	public void setUserLog(userLogModel userLog) {
		this.userLog = userLog;
	}

	// END OF GETTER-SETTER METHOD

	public void setTokenForValueList(List<CommonOptionsVO> tokenForValueList) {
		this.tokenForValueList = tokenForValueList;
	}

	// START OF IMPLEMENTED METHOD
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	@SuppressWarnings("rawtypes")
	// START OF EXECUTE METHOD
	@SkipValidation
	public String execute() throws Exception {

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		int returnMessage=1;
		String returnValue=SUCCESS;

		Date currentDate = new Date();
		this.setCurrentDateTime(sdf.format(currentDate));

		// START INITIALIZATION OF ARRAYLISTS AND VARIABLES
		tokenForValueList = new ArrayList<CommonOptionsVO>();
		List tokenItaratorList = new ArrayList<CommonThriceOptionsVO>();
		tokenItaratorList = (List) context.getAttribute("TOKENTYPELOV");
		tokenForValueList = helper.extractThriceData(this.language,
				tokenItaratorList);

		if (isEdit()) {

			Date currentDateValue = new Date();
			logModel.setUser_id(Integer.parseInt((empID)));
			logModel.setUser_action("Issue_First_Token");
			logModel.setUser_log_comment("");
			logModel.setLog_datetime(currentDateValue);
			this.setUserLog(logModel);
			returnMessage=manager.addUserLog(getUserLog());
			this.setEdit(false);
		}
		System.out.println("empID at Execute "+empID);
		
		// END INITIALIZATION OF ARRAYLISTS AND VARIABLES
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

	// START OF METHOD TO EXIT FROM PAGE
	@SkipValidation
	public String exitFirstToken() throws Exception {
		return "home";
	}

	// END OF METHOD TO EXIT FROM PAGE

	// START OF METHOD TO INSERT FIRST TOKEN
	public String addFirstToken() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {
			
			System.out.println("empID at addDeedType "+empID);
		
			insertOperationMessage = insertOperation.insertFirstToken(language,this.tokenFor,empID,this.presenterName,branchCode);
			
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
			e.printStackTrace();
			this.addActionError("System error Occured");
			log.fatal("Exception---", e);
			return "home";
		}

		if (operationFlag) {
			this.emptyField();
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}

	// END OF METHOD TO INSERT FIRST TOKEN

	// START OF VALIDATION
	public void validate() {
		try {

			this.setEdit(false);
			this.execute();

			if ((empID == null) || (branchCode == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (branchCode.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));
			} else if (!validator.requiredFiledValidate(presenterName.trim())) {
				this.addFieldError("presenterName", "Name can't be empty");
			} else if (!validator.languageValidate(presenterName.trim(),
					this.language)) {
				this.addFieldError("presenterName",
						"Pl. Input in Proper Language");

			} else if (!validator.validateNameField(presenterName.trim(),
					this.language)) {
				this.addFieldError("presenterName",
						"Presenter Name is not valid");

			} else if (!validator.requiredFiledValidate(tokenFor.trim())) {
				this.addFieldError("tokenFor", "Token for is Required");
			}

		} catch (Exception e) {
			this.addActionError("System error Occured");
			log.fatal("Exception---", e);
		}
	}

	// END OF VALIDATION

	public void emptyField() {
		this.setPresenterName("");
		this.setTokenFor("");
	}

}