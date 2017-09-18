package com.chinasofti.sms.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "*.do", "*.jsp", "*.html" }, filterName = "loginFileter")
public class LoginFileter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		String uri = req.getRequestURI();
		String reqStr = uri.substring(uri.lastIndexOf('/'));
		if (reqStr.equals("/") || reqStr.equals("/login.do") || reqStr.equals("/login.jsp")
				|| reqStr.equals("/frame.jsp")) {
			arg2.doFilter(arg0, arg1);
		} else {
			if (req.getSession().getAttribute("user") == null) {
				HttpServletResponse resp = (HttpServletResponse) arg1;
				resp.sendRedirect(req.getSession().getAttribute("basePath")+"/view/frame.jsp");
			} else {
				arg2.doFilter(arg0, arg1);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
