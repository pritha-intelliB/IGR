package com.igr.master;

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

import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.feeStructureModel;
import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FeeMasterEntry extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	// START OF SESSION VARIABLE
	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String language = "";
	private boolean edit;
	// END OF SESSION VARIABLE

	// PAGE RELATED VARIABLE

	private String deedCategoryID;
	private String fee_name;
	private float fee_rate;
	private String fee_unit;
	private String on_value;
	// END OF PAGE RELATED VARIABLE

	// START OF PAGE DROPDOWN LIST VARIABLE
	List<CommonOptionsVO> deedList;
	private List<String> stampValueList;
	// END OF PAGE DROPDOWN LIST VARIABLE

	// START OF SERVLET VARIABLE
	private ServletContext context;
	private HttpServletRequest request;
	// END OF SERVLET VARIABLE

	// START OF CLASS OBJECT INITILIZATION
	private static CommonValidation validator = new CommonValidation();
	HibernateManager manager = new HibernateManager();
	private static InsertOperation insertOperation = new InsertOperation();
	private static final Logger log = Logger.getLogger(FeeMasterEntry.class);

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");

	// END OF CLASS OBJECT INITILIZATION

	// START OF GETTER-SETTER METHOD
	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getDeedCategoryID() {
		return deedCategoryID;
	}

	public void setDeedCategoryID(String deedCategoryID) {
		this.deedCategoryID = deedCategoryID;
	}

	public String getFee_name() {
		return fee_name;
	}

	public void setFee_name(String fee_name) {
		this.fee_name = fee_name;
	}

	public float getFee_rate() {
		return fee_rate;
	}

	public void setFee_rate(float fee_rate) {
		this.fee_rate = fee_rate;
	}

	public String getFee_unit() {
		return fee_unit;
	}

	public void setFee_unit(String fee_unit) {
		this.fee_unit = fee_unit;
	}

	public String getOn_value() {
		return on_value;
	}

	public void setOn_value(String on_value) {
		this.on_value = on_value;
	}

	public List<String> getStampValueList() {
		return stampValueList;
	}

	public void setStampValueList(List<String> stampValueList) {
		this.stampValueList = stampValueList;
	}

	public List<CommonOptionsVO> getDeedList() {
		return deedList;
	}

	public void setDeedList(List<CommonOptionsVO> deedList) {
		this.deedList = deedList;
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
	// START OF EXECUTE METHOD
	@SkipValidation
	public String execute() throws Exception {

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		int returnMessage = 1;
		String returnValue = SUCCESS;
		userLogModel logModel = new userLogModel();
		// START INITIALIZATION OF ARRAYLISTS AND VARIABLES

		Locale locale = new Locale(language);
		ActionContext.getContext().setLocale(locale);

		deedList = new ArrayList<CommonOptionsVO>();
		deedList = manager.searchDeedCategory(Integer.parseInt(language));

		stampValueList = new ArrayList<String>();
		stampValueList.add(getText("global.Percentage"));
		stampValueList.add(getText("global.Fixed"));
		stampValueList.add(getText("global.Slab"));
		stampValueList.add(getText("global.Multiple"));

		if (isEdit()) {
			Date currentDateValue = new Date();
			logModel.setUser_id(Integer.parseInt((empID)));
			logModel.setUser_action("Deed_Category_Entry");
			logModel.setUser_log_comment("");
			logModel.setLog_datetime(currentDateValue);
			returnMessage = manager.addUserLog(logModel);
			this.setEdit(false);
		}

		// END INITIALIZATION OF ARRAYLISTS AND VARIABLES

		if (returnMessage == 1)
			returnValue = SUCCESS;

		else if (returnMessage == 0) {
			this.addActionError(getText("System Error Occured"));
			returnValue = "home";
		}
		return returnValue;
	}

	// END OF EXECUTE METHOD

	// START OF METHOD TO EXIT FROM PAGE
	@SkipValidation
	public String exitFeeMaster() throws Exception {
		return "home";
	}

	// END OF METHOD TO EXIT FROM PAGE

	// START OF METHOD TO INSERT FIRST TOKEN

	public String addFeeMaster() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {
			feeStructureModel feeModel = new feeStructureModel();
			Date currentDate = new Date();

			feeModel.setDeed_category_id(Integer.parseInt(this.deedCategoryID));
			feeModel.setFee_name(this.fee_name);
			feeModel.setFee_val(this.fee_rate);
			feeModel.setFee_unit(this.fee_unit);
			feeModel.setDepends_on(this.on_value);
			feeModel.setCreated_by(Integer.parseInt(empID));
			feeModel.setCreated_datetime(currentDate);
			feeModel.setUpdated_by(Integer.parseInt(empID));
			feeModel.setUpdated_date(currentDate);
			feeModel.setLang_id(Integer.parseInt(this.language));
			insertOperationMessage = insertOperation.insertFeeMaster(feeModel);

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
			}

			else if (!validator.requiredFiledValidate(deedCategoryID.trim())) {
				this.addFieldError("deedCategoryID",
						"Deed Category Can't be empty");
			} else if (!validator.requiredFiledValidate(fee_name.trim())) {
				this.addFieldError("fee_name", "Fee Name Can't be empty");
			} else if (!validator.requiredFiledValidate(String
					.valueOf(fee_rate).trim())) {
				this.addFieldError("fee_rate", "Fee rate Can't be empty");
			} else if (!validator.requiredFiledValidate(String
					.valueOf(fee_rate).trim())) {
				this.addFieldError("fee_rate", "Fee rate Can't be empty");
			} else if (!validator.languageValidate(fee_name.trim(),
					this.language)) {
				this.addFieldError("fee_name", "Pl. Input in Proper Language");

			} else if (!validator.validateNameField(fee_name.trim(),
					this.language)) {
				this.addFieldError("fee_name", "Fee Name is not valid");
			} else if (!validator.amountFiledValidate(String.valueOf(fee_rate)
					.trim())) {
				this.addActionError("Fee Rate is not valid");
			} else if (!validator.requiredFiledValidate(String
					.valueOf(fee_unit).trim())) {
				this.addFieldError("fee_unit", "Fee Unit Can't be empty");
			} else if (!validator.requiredFiledValidate(String
					.valueOf(on_value).trim())) {
				this.addFieldError("on_value", "On Value Can't be empty");
			}

		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("System error Occured");
			log.fatal("Exception---", e);
		}
	}

	// END OF VALIDATION

	public void emptyField() {
		this.setDeedCategoryID("");
		this.setFee_name("");
		this.setFee_rate(0f);
		this.setFee_unit("");
		this.setOn_value("");
		
	}

}