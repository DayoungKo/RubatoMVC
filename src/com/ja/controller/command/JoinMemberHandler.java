package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;

public class JoinMemberHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String id = request.getParameter("join_input_id");
		String pw = request.getParameter("join_input_pw");
		String nick = request.getParameter("join_input_nick");
		String phone = request.getParameter("join_input_phone");
		
		new MemberService().joinMember(id, pw, nick, phone);
		
		try { response.sendRedirect("./index.do"); }
		catch(Exception e) {e.printStackTrace();}
		
		return null;
	}
}
