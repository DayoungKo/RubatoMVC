package com.ja.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.model.service.*;

public class BoardWriteHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String m_idx = request.getParameter("writer_idx");
		String title= request.getParameter("input_title");
		String content= request.getParameter("input_content");
		String attach_name= request.getParameter("upload_attach");
		String attach_url = null;
		
		//첨부파일 프로세스 추가로 작성하기..->attachHandler 만들어서 return String attach_url 할 수 있도록!(다운로드는...고민해보기)
		
		new BoardContentService().writeBoard(m_idx, title, content, attach_name, attach_url);
		
		try { response.sendRedirect("./boardlist.do"); }
		catch(Exception e) {e.printStackTrace();}
		
		return null;
	}

}
