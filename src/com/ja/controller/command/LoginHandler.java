package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;
import com.ja.model.vo.*;

public class LoginHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberService memberService = new MemberService();
		SessionUserData logineduser = memberService.login(id, pw);
		
		try {
			if(logineduser != null)
			{
				request.getSession().setAttribute("logineduser", logineduser);
				response.sendRedirect(request.getHeader("referer"));
			}
			else
			{
				//로그인 실패하면 session에 값을 저장한 후, 해당 페이지에서 loginfailcheck가 null이 아니면 alert 창 띄우기
				//request.getSession().setAttribute("loginfailcheck", "loginfail");
				response.sendRedirect(request.getHeader("referer"));
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	}
}
