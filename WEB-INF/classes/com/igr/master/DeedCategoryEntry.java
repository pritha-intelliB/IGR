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
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class DeedCategoryEntry extends ActionSupport implements
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

	private String deedID;
	private String category_name;
	private float stamp_fee;
	private String stamp_unit;
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
	private static final Logger log = Logger.getLogger(DeedCategoryEntry.class);

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");

	// END OF CLASS OBJECT INITILIZATION

	// START OF GETTER-SETTER METHOD
	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
	
	
	

	public List<String> getStampValueList() {
		return stampValueList;
	}

	public void setStampValueList(List<String> stampValueList) {
		this.stampValueList = stampValueList;
	}

	public String getDeedID() {
		return deedID;
	}

	public void setDeedID(String deedID) {
		this.deedID = deedID;
	}

	public float getStamp_fee() {
		return stamp_fee;
	}

	public void setStamp_fee(float stamp_fee) {
		this.stamp_fee = stamp_fee;
	}

	public String getStamp_unit() {
		return stamp_unit;
	}

	public void setStamp_unit(String stamp_unit) {
		this.stamp_unit = stamp_unit;
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
		deedList=manager.searchDeedType(Integer.parseInt(language));
		
		 stampValueList= new ArrayList<String>();
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
	public String exitDeedCategory() throws Exception {
		return "home";
	}

	// END OF METHOD TO EXIT FROM PAGE

	// START OF METHOD TO INSERT FIRST TOKEN

	
	
	public String addDeedCategory() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {
			deedCategoryModel categoryModel= new deedCategoryModel();
			Date currentDate= new Date();
			categoryModel.setDeed_type_id(Integer.parseInt(deedID));
			categoryModel.setCategory_name(category_name);
			categoryModel.setStamp_fee(stamp_fee);
			categoryModel.setStamp_unit(stamp_unit);
			categoryModel.setCreated_by(Integer.parseInt(empID));
			categoryModel.setCreated_datetime(currentDate);
			categoryModel.setUpdated_by(Integer.parseInt(empID));
			categoryModel.setUpdated_datetime(currentDate);
			categoryModel.setLang_id(Integer.parseInt(this.language));
			insertOperationMessage = insertOperation.insertDeedCategory(categoryModel);

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

			else if (!validator.requiredFiledValidate(deedID.trim())) {
				this.addFieldError("deedID", "Deed Type Can't be empty");
			} else if (!validator.requiredFiledValidate(category_name.trim())) {
				this.addFieldError("category_name", "Deed Category Can't be empty");
			} else if (!validator.requiredFiledValidate(String.valueOf(stamp_fee)
					.trim())) {
				this.addFieldError("stamp_fee", "Stamp Value Can't be empty");
			} else if (!validator.requiredFiledValidate(String.valueOf(
					stamp_unit).trim())) {
				this.addFieldError("stamp_unit", "Stamp Unit Can't be empty");
			} else if (!validator.languageValidate(category_name.trim(),
					this.language)) {
				this.addFieldError("deed_name", "Pl. Input in Proper Language");

			} else if (!validator.validateNameField(category_name.trim(),
					this.language)) {
				this.addFieldError("deed_name", "Deed Name is not valid");
			} 
			else if (!validator.amountFiledValidate(String.valueOf(stamp_fee)
					.trim())) {
				this.addActionError("Stamp Value is not valid");
			} 

			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("System error Occured");
			log.fatal("Exception---", e);
		}
	}

	// END OF VALIDATION

	public void emptyField() {
		this.setDeedID("");
		this.setCategory_name("");
		this.setStamp_fee(0f);
		this.setStamp_unit("");
	}

}