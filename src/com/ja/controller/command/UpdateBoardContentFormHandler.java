package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;
import com.ja.model.vo.*;

public class UpdateBoardContentFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String bc_idx = request.getParameter("bc_idx");
		
		BoardContentData boardContentData = new BoardContentService().getBoardContent(bc_idx);
		request.setAttribute("boardContentData", boardContentData);
		
		return "/WEB-INF/views/boardupdateform.jsp";
	}

}
