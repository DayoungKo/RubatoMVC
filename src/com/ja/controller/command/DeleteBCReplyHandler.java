package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;

public class DeleteBCReplyHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String bc_idx = request.getParameter("bc_idx");
		String bc_reply_idx = request.getParameter("bc_reply_idx");
		
		new BCReplyService().deleteReply(bc_reply_idx);
		
		try { response.sendRedirect("readbaord.do?bc_idx="+bc_idx); }
		catch(Exception e) { e.printStackTrace(); }
		
		return null;
	}
}
