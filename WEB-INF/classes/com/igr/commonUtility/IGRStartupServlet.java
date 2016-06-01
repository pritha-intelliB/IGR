package com.igr.commonUtility;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.log4j.Logger;


 public class IGRStartupServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{

	 private static final long serialVersionUID = 1L;
	 private static final Logger log = Logger.getLogger(IGRStartupServlet.class);
	public IGRStartupServlet() {
		super();
	}   	 	  	  	  
	
		public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = config.getServletContext(); 
		
		
		try {
			UtilityServices services = new UtilityServices();
			servletContext.setAttribute("USERLOV",services.getUserLOV());
			servletContext.setAttribute("TOKENTYPELOV",services.getTokenTypeLov());
	  	}
			
			
			catch (Exception e) {
				log.fatal("Exception---",e);
		}
	}   
}