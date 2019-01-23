package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;

public class WriteReplyOnBCHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String bc_idx = request.getParameter("reply_bc_idx");
		String m_idx = request.getParameter("reply_writer_idx");
		String bc_reply_content = request.getParameter("reply_input_content");
		
		new BCReplyService().writeReply(bc_idx, m_idx, bc_reply_content);
		
		try { response.sendRedirect("readbaord.do?bc_idx="+bc_idx);}
		catch(Exception e) { e.printStackTrace(); }
		
		return null;
	}
}
