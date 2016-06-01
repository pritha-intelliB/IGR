package com.igr.commonUtility;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String language;
	private Map<String, Object> session;
	private static CommonHelper helper = new CommonHelper();

	public String home() {
		return SUCCESS;
	}

	// Log Out user
	public String logOut() {
		session.remove("_EMPCODE");
		session.remove("_LOCATIONID");
		session.remove("_USERGROUP");
		session.remove("_LANGUAGE");
		session.remove("DISPLAYNAME");
		session.remove("LOCATIONNAME");
		session.clear();
		
		addActionMessage("You have been Successfully Logged Out");
		return SUCCESS;
	}

	// Login user
	public String login() {
		String loginValue=LOGIN;
		
		
		try{
		if (userName.isEmpty()) {
			this.addActionError("Username can't be blanked");
			loginValue= LOGIN;
		} else if (password.isEmpty()) {
			this.addActionError("Password can't be blanked");
			loginValue= LOGIN;

		} else {
			String returnMap[] = helper.cheekUserValidity(userName, password,
					language);
			
			if((returnMap[0]).equals("99999XXXXXX")){
				this.addActionError("Username  and Password mismatch!");
				loginValue= LOGIN;
			}
			else if(!returnMap[0].equals("99999XXXXXX")){
				session.put("_EMPCODE", returnMap[0]);
				session.put("_LOCATIONID", returnMap[1]);
				session.put("_USERGROUP", returnMap[2]);
				session.put("_LANGUAGE", returnMap[3]);
				session.put("DISPLAYNAME", returnMap[4]);
				session.put("LOCATIONNAME", returnMap[5]);
				loginValue= SUCCESS;
	
			}
			

			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return loginValue;
			
		}
	

	public String getUserName() {
		return userName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}