package com.ja.controller.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinMemberFormHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		//자유게시판 벗어나면 검색 쿠키 삭제
		Cookie removeSearchOptionCookie = new Cookie("SearchOption",null);
		Cookie removeSearchContentCookie = new Cookie("SearchContent",null);
		removeSearchOptionCookie.setMaxAge(0);
		removeSearchContentCookie.setMaxAge(0);
		response.addCookie(removeSearchOptionCookie);
		response.addCookie(removeSearchContentCookie);

		return "WEB-INF/views/joinmemberform.jsp";
	}

}
