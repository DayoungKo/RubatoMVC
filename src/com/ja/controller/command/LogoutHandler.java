package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		request.getSession().invalidate();
		
		try { response.sendRedirect(request.getHeader("referer"));}
		catch(Exception e) { e.printStackTrace(); }
		
		return null;
	}

}
