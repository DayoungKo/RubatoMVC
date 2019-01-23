package com.ja.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharacterEncodingFilter implements Filter 
{
	private String encodingType = "UTF-8";
	
    public CharacterEncodingFilter() 
    {
    }

    public void destroy() 
    {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// place your code here
		HttpServletRequest httpReq = (HttpServletRequest)request;
		httpReq.setCharacterEncoding(encodingType);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		encodingType = fConfig.getInitParameter("encodingType");
	}

}
