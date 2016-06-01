package com.igr.master;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
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
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.feeStructureModel;
import com.igr.hibernate.model.partyTypeModel;
import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeedTypeEntry extends ActionSupport implements
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
	private String rowNumber;
	private String partyTypeValue;
	private String deed_name;
	private String deed_code;
	private float fee_val;
	private String depends_on;
	private String property_details;
	private String book_id;
	private int rowIndex;
	private String action;
	// END OF PAGE RELATED VARIABLE

	// START OF PAGE DROPDOWN LIST VARIABLE
	private List<String> stampValueList;
	private List<CommonOptionsVO> propertyRequiredList;
	private List<CommonOptionsVO> validationPartyName;
	private List<String> bookTypeList;
	private partyTypeModel party;
	private feeStructureModel fee;

	// END OF PAGE DROPDOWN LIST VARIABLE
	
	public partyTypeModel getParty() {
		return party;
	}



	public int getRowIndex() {
		return rowIndex;
	}



	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}



	public List<CommonOptionsVO> getValidationPartyName() {
		return validationPartyName;
	}

	public void setValidationPartyName(List<CommonOptionsVO> validationPartyName) {
		this.validationPartyName = validationPartyName;
	}

	public void setParty(partyTypeModel party) {
		this.party = party;
	}

	public feeStructureModel getFee() {
		return fee;
	}

	public void setFee(feeStructureModel fee) {
		this.fee = fee;
	}

	// START OF SERVLET VARIABLE
	private ServletContext context;
	private HttpServletRequest request;
	// END OF SERVLET VARIABLE

	// START OF HIBERNATE VARIABLE

	List<partyTypeModel> partyType = new ArrayList();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");
	// END OF HIBERNATE VARIABLE

	// START OF CLASS OBJECT INITILIZATION
	private static CommonValidation validator = new CommonValidation();
	HibernateManager manager = new HibernateManager();

	private static InsertOperation insertOperation = new InsertOperation();
	private static final Logger log = Logger.getLogger(DeedTypeEntry.class);

	// END OF CLASS OBJECT INITILIZATION

	// START OF GETTER-SETTER METHOD

	public String getRowNumber() {
		return rowNumber;
	}

	public String getDeed_name() {
		return deed_name;
	}

	public void setDeed_name(String deed_name) {
		this.deed_name = deed_name;
	}

	public String getDeed_code() {
		return deed_code;
	}

	public void setDeed_code(String deed_code) {
		this.deed_code = deed_code;
	}

	public float getFee_val() {
		return fee_val;
	}

	public void setFee_val(float fee_val) {
		this.fee_val = fee_val;
	}

	public String getDepends_on() {
		return depends_on;
	}

	public void setDepends_on(String depends_on) {
		this.depends_on = depends_on;
	}

	public String getProperty_details() {
		return property_details;
	}

	public void setProperty_details(String property_details) {
		this.property_details = property_details;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getPartyTypeValue() {
		return partyTypeValue;
	}

	public void setPartyTypeValue(String partyTypeValue) {
		this.partyTypeValue = partyTypeValue;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}
	
	
	
	

	public String getAction() {
		return action;
	}



	public void setAction(String action) {
		this.action = action;
	}



	public boolean isEdit() {
		return edit;
	}

	public List<partyTypeModel> getPartyType() {
		return partyType;
	}

	public void setPartyType(List<partyTypeModel> partyType) {
		this.partyType = partyType;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public List<String> getStampValueList() {
		return stampValueList;
	}

	public void setStampValueList(List<String> stampValueList) {
		this.stampValueList = stampValueList;
	}

	public List<CommonOptionsVO> getPropertyRequiredList() {
		return propertyRequiredList;
	}

	public void setPropertyRequiredList(
			List<CommonOptionsVO> propertyRequiredList) {
		this.propertyRequiredList = propertyRequiredList;
	}

	public List<String> getBookTypeList() {
		return bookTypeList;
	}

	public void setBookTypeList(List<String> bookTypeList) {
		this.bookTypeList = bookTypeList;
	}

	// END OF GETTER-SETTER METHOD

	// START OF IMPLEMENTED METHOD
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

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

		stampValueList = new ArrayList<String>();
		stampValueList.add(getText("global.Percentage"));
		stampValueList.add(getText("global.Fixed"));
		stampValueList.add(getText("global.Slab"));
		stampValueList.add(getText("global.Multiple"));

		propertyRequiredList = new ArrayList<CommonOptionsVO>();
		CommonOptionsVO optionVO = new CommonOptionsVO(getText("global.Yes"),
				"true");
		propertyRequiredList.add(optionVO);
		optionVO = new CommonOptionsVO(getText("global.No"), "false");
		propertyRequiredList.add(optionVO);

		bookTypeList = new ArrayList<String>();
		bookTypeList.add("1");
		bookTypeList.add("3");
		bookTypeList.add("4");
		//this.setRowIndex(1);

		if (isEdit()) {
			Date currentDateValue = new Date();
			logModel.setUser_id(Integer.parseInt((empID)));
			logModel.setUser_action("Deed_Type_Entry");
			logModel.setUser_log_comment("");
			logModel.setLog_datetime(currentDateValue);
			returnMessage = manager.addUserLog(logModel);
			this.setEdit(false);
		}
		
		
		loadData();
		if((this.action!=null)&&(this.action.trim().length()>0)&&(this.action.equalsIgnoreCase("delete"))){
			
			System.out.println("rowNumber "+rowNumber+" Size="+validationPartyName.size()+" rowIndex="+(rowIndex-1));
			if ((rowNumber != null)
					&& (validator.neumericFiledValidate(String.valueOf(rowNumber)))
					&& (Integer.parseInt(rowNumber) > 1)){
			
			validationPartyName.remove(getRowIndex()-1);
			}
			else
			this.addActionError("Minimum one Party is required");
			}
		
		if(validationPartyName.isEmpty())
		{
			CommonOptionsVO option = new CommonOptionsVO("", "");
			validationPartyName.add(option);
			
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
	public String exitDeedType() throws Exception {
		return "home";
	}

	// END OF METHOD TO EXIT FROM PAGE

	// START OF METHOD TO INSERT FIRST TOKEN

	public String addDeedType() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;
		feeStructureModel feeModel = new feeStructureModel();
		deedTypeModel deedType = new deedTypeModel();
		try {

			Date currentDateValue = new Date();
			deedType.setDeed_name(this.deed_name);
			deedType.setDeed_code(this.deed_code);
			deedType.setRemarks("");
			deedType.setCreated_by(Integer.parseInt(empID));
			deedType.setCreated_datetime(currentDateValue);
			deedType.setUpdated_by(Integer.parseInt(empID));
			deedType.setUpdated_date(currentDateValue);
			deedType.setProperty_details(this.property_details.equals("true") ? true
					: false);
			deedType.setBook_id(Integer.parseInt(this.book_id));
			deedType.setLang_id(Integer.parseInt(this.language));

			/*
			 * feeModel.setDeed_category_id(deedType.getDeed_type_id());
			 * feeModel.setFee_name(getText("global.Stamp_Value_database"));
			 * feeModel.setFee_val(this.getFee_val());
			 * feeModel.setFee_unit(this.depends_on);
			 * feeModel.setDepends_on("");
			 * feeModel.setCreated_by(Integer.parseInt(empID));
			 * feeModel.setCreated_datetime(currentDateValue);
			 * feeModel.setUpdated_by(Integer.parseInt(empID));
			 * feeModel.setUpdated_date(currentDateValue);
			 * feeModel.setLang_id(Integer.parseInt(this.language));
			 */

			List<String> partyName = getAllDate();
			List<partyTypeModel> partyNameList = new ArrayList();
			ListIterator<String> listItr = partyName.listIterator();
			while (listItr.hasNext()) {
				partyTypeModel mode = new partyTypeModel();
				mode.setPart_name((String) listItr.next());
				mode.setRemarks("");
				mode.setCreated_by(Integer.parseInt(empID));
				mode.setCreated_datetime(currentDateValue);
				mode.setUpdated_by(Integer.parseInt(empID));
				mode.setUpdated_date(currentDateValue);
				mode.setLang_id(Integer.parseInt(this.language));
				partyNameList.add(mode);
			}

			insertOperationMessage = insertOperation.insertDeedType(deedType,
					partyNameList);

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

			else if (!validator.requiredFiledValidate(deed_name.trim())) {
				this.addFieldError("deed_name", "Deed Name Can't be empty");
			} else if (!validator.requiredFiledValidate(deed_code.trim())) {
				this.addFieldError("deed_code", "Deed Code Can't be empty");
			} else if (!validator.requiredFiledValidate(String.valueOf(
					property_details).trim())) {
				this.addFieldError("property_details",
						"Property Required Can't be empty");
			} else if (!validator.requiredFiledValidate(String.valueOf(book_id)
					.trim())) {
				this.addFieldError("book_id", "Book Can't be empty");
			} else if (!validator.languageValidate(deed_name.trim(),
					this.language)) {
				this.addFieldError("deed_name", "Pl. Input in Proper Language");

			} else if (!validator.validateNameField(deed_name.trim(),
					this.language)) {
				this.addFieldError("deed_name", "Deed Name is not valid");
			} else if (!validator.languageValidate(deed_code.trim(),
					this.language)) {
				this.addFieldError("deed_code", "Pl. Input in Proper Language");

			} else if (!validator.validateNameField(deed_code.trim(),
					this.language)) {
				this.addFieldError("deed_code", "Deed Code is not valid");
			}

			else if ((rowNumber == null)
					|| (!validator.neumericFiledValidate(String
							.valueOf(rowNumber)))
					|| (Integer.parseInt(rowNumber) <= 0)) {
				this.addActionError("Party Type Can't be empty ");
			}

			else {

				List<String> partyName = getAllDate();
				ListIterator<String> listItr = partyName.listIterator();
				String tempPartyName = "";
				while (listItr.hasNext()) {
					tempPartyName = (String) listItr.next();
					if (!validator.requiredFiledValidate(tempPartyName.trim())) {
						this.addActionError("Party Type Can't be empty");
						break;
					} else if (!validator.languageValidate(
							tempPartyName.trim(), this.language)) {
						this.addActionError("Pl. Input in Proper Language");
						break;
					} else if (!validator.validateNameField(
							tempPartyName.trim(), this.language)) {
						this.addActionError("Party Name is not valid");
						break;
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("System error Occured");
			log.fatal("Exception---", e);
		}
	}

	// END OF VALIDATION

	public void emptyField() {
		this.setDeed_name("");
		this.setDeed_code("");
		this.setFee_val(0f);
		this.setDepends_on("");
		this.setProperty_details("");
		this.setBook_id("");
		this.setPartyTypeValue("");
		this.validationPartyName.clear();

	}

	public List<String> getAllDate() {
		String getPartyTypeValue[] = request
				.getParameterValues("partyTypeValue");
		List<String> allPartyName = new ArrayList();
		for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
			String partyName = getPartyTypeValue[row];
			allPartyName.add(partyName);
		}
		return allPartyName;
	}

	@SkipValidation
	public String loadData() throws Exception {
		validationPartyName = new ArrayList<>();
		if ((rowNumber != null)
				&& (validator.neumericFiledValidate(String.valueOf(rowNumber)))
				&& (Integer.parseInt(rowNumber) > 0)) {
			List<String> partyName = getAllDate();
			ListIterator<String> listItr = partyName.listIterator();
			while (listItr.hasNext()) {
				CommonOptionsVO optionVO = new CommonOptionsVO(
						(String) listItr.next(), "");
				validationPartyName.add(optionVO);
		
			}
		}
		return SUCCESS;
	}
	
	
	


}