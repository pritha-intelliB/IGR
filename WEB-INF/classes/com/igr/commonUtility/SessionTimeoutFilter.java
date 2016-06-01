// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 26-03-2012 12:52:06 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SessionTimeoutFilter.java
package com.igr.commonUtility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

public class SessionTimeoutFilter implements Filter {
	private static final Logger log = Logger
			.getLogger(SessionTimeoutFilter.class);
	public SessionTimeoutFilter() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init(FilterConfig config) throws ServletException {

		String entryPoints = config.getInitParameter("entryURLs");

		if (entryPoints != null) {
			StringTokenizer st = new StringTokenizer(entryPoints, ",");
			String url = "";
			entryURLs = new HashMap();
			entryURLs.put(url, null);
			for (; st.hasMoreTokens(); entryURLs.put(url, null)) {
				url = st.nextToken();

			}

		}
		formater = new SimpleDateFormat("ZddMMyyHHmmssSSSS");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (!entryURLs.containsKey(req.getServletPath())) {
			Cookie oldCookie = getCookie(req);
			if (oldCookie != null) {

				String timestamp = oldCookie.getValue();

				if (!timestamp.equals("null")) {

					if (!isCookieValid(oldCookie, req, res)) {
						Cookie sessionCookie = new Cookie("SYSConTimeout", null);
						sessionCookie.setPath("/");
						res.addCookie(sessionCookie);
						logout(req, res);
						return;
					}
				}
			}
		}

		setCookie(res);
		chain.doFilter(req, res);
	}

	private boolean isCookieValid(Cookie oldCookie, HttpServletRequest req,
			HttpServletResponse res) {
		label0: {
			try {
				String timestamp = oldCookie.getValue();
				Date oldDate = formater.parse(timestamp);

				Date expireDate = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(expireDate);
				cal.add(13, req.getSession().getMaxInactiveInterval() * -1);
				expireDate = cal.getTime();
				if (!oldDate.before(expireDate))
					break label0;

			} catch (Exception e) {
				log.fatal("Exception---",e);
				return false;
			}
			return false;
		}
		return true;
	}

	private Cookie getCookie(HttpServletRequest request)
			throws ServletException {
		Cookie cookies[] = request.getCookies();
		Cookie retCookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++)
				if ("SYSConTimeout".equals(cookies[i].getName()))
					retCookie = cookies[i];

		} else {
			throw new ServletException("Cookie not found");
		}
		return retCookie;
	}

	private void setCookie(HttpServletResponse res) {
		Date newDate = new Date();
		String formatedDate = formater.format(newDate);
		Cookie sessionCookie = new Cookie("SYSConTimeout", formatedDate);
		sessionCookie.setPath("/");
		res.addCookie(sessionCookie);
	}

	private void logout(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession piisSession = req.getSession();
		piisSession.setMaxInactiveInterval(10*60);
		piisSession.removeAttribute("_EMPCODE");
		piisSession.removeAttribute("_LOCATIONID");
		piisSession.removeAttribute("_USERGROUP");
		piisSession.removeAttribute("_LANGUAGE");
		piisSession.removeAttribute("DISPLAYNAME");
		piisSession.removeAttribute("LOCATIONNAME");
		piisSession.invalidate();
		RequestDispatcher rd = req.getRequestDispatcher("errorPage.jsp");
		rd.forward(req, res);
	}

	public void destroy() {
	}

	HashMap<String, ?> entryURLs;
	SimpleDateFormat formater;

}