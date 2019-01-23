package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;

public class DeleteBoardContentHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String bc_idx = request.getParameter("bc_idx");
		new BoardContentService().deleteBoardContent(bc_idx);
		
		try { response.sendRedirect("boardlist.do"); }
		catch(Exception e) { e.printStackTrace(); }
		
		return null;
	}
}
