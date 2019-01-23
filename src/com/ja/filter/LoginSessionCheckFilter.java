package com.ja.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/LoginCheckFilter")
public class LoginSessionCheckFilter implements Filter 
{
    public LoginSessionCheckFilter() { }

	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String url = req.getContextPath();
		
		System.out.println("LoginSessionCheckFilter 수행 \n 호출Path: "+url);
		
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("logineduser")==null)
		{
			res.sendRedirect("./boardlist.do");
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
	}
}
