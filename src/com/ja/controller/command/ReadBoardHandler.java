package com.ja.controller.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;
import com.ja.model.vo.*;

public class ReadBoardHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String bc_idx = request.getParameter("bc_idx");
		BoardContentData boardContentData = new BoardContentService().getBoardContent(bc_idx);
		
		//replyList set
		ArrayList<BCReplyData> ubReplyDataList = new BCReplyService().getBcReplyList(bc_idx);
		
		//addLookCount Logic
		String look_count = boardContentData.getBoardContentDto().getBc_look_count();
		look_count = String.valueOf(Integer.parseInt(look_count)+1);
		new BoardContentService().addLookCount(bc_idx, look_count);
		
		boardContentData = new BoardContentService().getBoardContent(bc_idx);
		request.setAttribute("boardContentData", boardContentData);
		request.setAttribute("ubReplyDataList", ubReplyDataList);
		
		return "/WEB-INF/views/readbaordcontent.jsp";
	}
}
