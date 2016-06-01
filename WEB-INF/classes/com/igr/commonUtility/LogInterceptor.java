package com.igr.commonUtility;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LogInterceptor  extends AbstractInterceptor {


	private static final long serialVersionUID = 1L;

		@Override
        public String intercept(ActionInvocation invocation) throws Exception {
                Map<String, Object> session = invocation.getInvocationContext().getSession();

                String empID = (String) session.get("_EMPCODE");
                String branchCode = (String) session.get("_LOCATIONID");
                String groupID = (String) session.get("_USERGROUP");
                String language = (String) session.get("_LANGUAGE");
            
               
                if ((empID == null)||(branchCode == null)||(groupID == null)||(language == null))
                {
                        return Action.LOGIN;
                } 
                else 
                {
                        return invocation.invoke();
                }
        }
}