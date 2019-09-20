package com.dh.demo.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dh.demo.util.JWTUtils;

public class SysFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		String servletpath=request.getServletPath();
		if(servletpath.contains("/index.jsp")){
			arg2.doFilter(request, response);
			return;
		}
		if(servletpath.equals("/user/login.do")){
			arg2.doFilter(request, response);
			return;
		}
		if(servletpath.equals("/main.jsp")){
			String token= request.getParameter("token");
			try {
				JWTUtils.verifyToken(token);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
			arg2.doFilter(request, response);
			return;
		}
		String token=request.getHeader("usertoken");
		try {
			JWTUtils.verifyToken(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
