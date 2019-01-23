package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;

public class UpdateBoardContentHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String bc_idx = request.getParameter("bc_idx");
		String title = request.getParameter("input_title");
		String content = request.getParameter("input_content");
		String attach_name = request.getParameter("upload_attach");
		String attach_url = null;
		
		if(attach_name != null)
		{
			//url처리
			attach_url = null;
		}
		else
		{
			attach_name = request.getParameter("not_updated_attach_name");
			attach_url = request.getParameter("not_updated_attach_url");
		}
		
		new BoardContentService().updateBoardContent(bc_idx, title, content, attach_name, attach_url);
		
		try { response.sendRedirect("readbaord.do?bc_idx="+bc_idx); }
		catch(Exception e) { e.printStackTrace(); }
		
		return null;
	}

}
