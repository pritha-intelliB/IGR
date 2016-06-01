package com.igr.commonUtility;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;  

import com.igr.registration.IssueFirstTokenAction;
import com.opensymphony.xwork2.Action;  
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.Interceptor;  

public class IGRFilter implements Interceptor{  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger
			.getLogger(IGRFilter.class);
	private List<?> grpEventMap;
    public void destroy() {  
      
    }  
    public void init() {  
        
    }  

       
    @SuppressWarnings("deprecation")
	public String intercept(ActionInvocation invocation) throws Exception {  
        
        ActionContext context = invocation.getInvocationContext();  
        HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);  
        String path = request.getRequestURI();  
        
     
        
    	String userGroup =(String)request.getSession().getAttribute("_USERGROUP");
    	String empID = (String) request.getSession().getAttribute("_EMPCODE");
		String branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		
		
  
    	Map<?, ?> application = invocation.getInvocationContext().getApplication();
    	grpEventMap=  (List<?>)application.get("USERLOV");  
    	
    	
    	
        if((userGroup== null)||(empID==null)||(branchCode==null)){  
        	 request.setAttribute("error", "Session Invalid. Try to Login again");  
        	 return Action.ERROR;  
        }else{  
            StringBuffer groups=extractPermissibleGroups(grpEventMap,extractEventCodeFromUrl(path));
           // log.fatal("Group "+groups+" User Group "+userGroup +"Action Name"+extractEventCodeFromUrl(path));
            
            if(groups.indexOf(userGroup)<0){  
                    request.setAttribute("error", "You are not authorized to do this operation");  
                    return Action.ERROR;  
            }  
            else
            {
            	request.getSession().putValue("_USERGROUP", userGroup);
            	request.getSession().putValue("_EMPCODE", empID);
            	request.getSession().putValue("_LOCATIONID", branchCode);
            }
        }
        
        return invocation.invoke();  
    }
	private String extractEventCodeFromUrl(String url) {
		int beginIndex = url.indexOf('/',1);
		StringBuffer eventCode = new StringBuffer(url.substring(beginIndex+1,url.length()-7));
		eventCode.append(".action");
		return eventCode.toString();
	}
	
	private StringBuffer extractPermissibleGroups(List<?> grpEvent,String actualPath)
	{
		StringBuffer permissibleGroups=new StringBuffer();
		ListIterator<?> listItr = grpEvent.listIterator();
		while (listItr.hasNext()) {
		CommonOptionsVO optionVO = (CommonOptionsVO) listItr.next();
		if(optionVO.getTypeDesc().equals(actualPath))
			permissibleGroups.append(optionVO.getTypeCode());
		}
		return permissibleGroups;
	}
	
}  
