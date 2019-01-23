package com.ja.controller.command;

import java.net.*;
import java.util.*;
import javax.servlet.http.*;
import com.ja.controller.processing.*;
import com.ja.model.service.*;
import com.ja.model.vo.*;

public class BoardListHandler implements CommandHandler 
{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
	{
		String search_option = null;
		String search_content = null;
		
		/* boardlist search cookie process */
		Cookie[] getCookies = request.getCookies();
		String searchCookieCheck = request.getParameter("search_cookie_check");
		System.out.println("searchCookieCheck: " + searchCookieCheck);
		
		if(getCookies != null)
		{
			if(searchCookieCheck == null)
			{
				//쿠키 체크
				try {
					
				for(int cookieIndex=0; cookieIndex<getCookies.length; cookieIndex++)
				{
					Cookie getCookie = getCookies[cookieIndex];
					String getCookieName = getCookie.getName();
					String getCokkieValue = URLDecoder.decode(getCookie.getValue(), "UTF-8");

					if(getCookieName.equals("SearchOption") && getCokkieValue != "")
					{
						search_option = getCokkieValue;
						System.out.println("SearchOption 쿠키O - value: "+ getCokkieValue);
					}
					else if(getCookieName.equals("SearchContent") && getCokkieValue != "")
					{
						search_content = getCokkieValue;
						System.out.println("SearchContent 쿠키O - value: "+ getCokkieValue);
					}
					else
					{
						search_option = request.getParameter("search_option");
						search_content = request.getParameter("search_content");
					}
				}
				}
				catch(Exception e) { e.printStackTrace(); }
			}
			else if(searchCookieCheck.equals("modifyCookie"))
			{
				search_option = request.getParameter("search_option");
				search_content = request.getParameter("search_content");
			}
			else if(searchCookieCheck.equals("removeCookie"))
			{
				//목록, 자유게시판 클릭시 검색 쿠키 삭제
				Cookie removeSearchOptionCookie = new Cookie("SearchOption", search_option);
				Cookie removeSearchContentCookie =  new Cookie("SearchContent", search_content);
				removeSearchOptionCookie.setMaxAge(0);
				removeSearchContentCookie.setMaxAge(0);
				response.addCookie(removeSearchOptionCookie);
				response.addCookie(removeSearchContentCookie);
			}
			else
			{
				System.out.println("Invalid searchCookieCheck: " + searchCookieCheck);
			}
		}
		else
		{
			search_option = request.getParameter("search_option");
			search_content = request.getParameter("search_content");
		}

		//쿠키 생성
		if(search_option!=null && search_content!=null)
		{
			try
			{
				Cookie setSearchOptionCookie = new Cookie("SearchOption", search_option);
				Cookie setSearchContentCookie = new Cookie("SearchContent", URLEncoder.encode(search_content, "UTF-8"));
				response.addCookie(setSearchOptionCookie);
				response.addCookie(setSearchContentCookie);
			}
			catch(Exception e) { e.printStackTrace(); }
		}
		
		/* board list view process */
		BoardContentService boardContentService = new BoardContentService();
		ArrayList<BoardContentData> allBoardListData = new ArrayList<>();
		ArrayList<BoardContentData> viewBoardListData = new ArrayList<>();
		
		if(search_option != null)
		{
			//Set search
			System.out.println("search기능 작동 search_option: "+search_option+", search_content: "+search_content);
			switch(search_option)
			{
				case "about_title":
					allBoardListData = new BoardContentService().getBoardListByTitle(search_content);
					break;
				
				case "about_content":
					allBoardListData = new BoardContentService().getBoardListByContent(search_content);
					break;
					
				case "about_writer":
					allBoardListData = new BoardContentService().getBoardListByWriter(search_content);
					break;
					
				default:
					System.out.println("search_option invalid Error");
			}
		}
		else
		{
			//Set Nothing
			System.out.println("search기능X default boardList 작동");
			allBoardListData = boardContentService.getBoardList();
		}
		int allBoardListDataSize = allBoardListData.size();
		
		/* paging process */
		String now_page_check = request.getParameter("page_num");
		String select_view_boardList_size = request.getParameter("select_view_boardList_size");
		PagingData pagingData = new PagingProcessing().setPaging(allBoardListDataSize, select_view_boardList_size, now_page_check);
		System.out.println("페이징 기능 작동 - 현재페이지: "+pagingData.getNowPageNum()+", 볼 게시물 갯수: "+pagingData.getViewBoardListSize());
		
		
		for(int boardListIndex=pagingData.getFirstViewContentNum(); boardListIndex<=pagingData.getLastViewContentNum(); boardListIndex++)
		{
			if(boardListIndex < allBoardListDataSize) 
			{
				viewBoardListData.add(allBoardListData.get(boardListIndex));
			}
			else
			{
				break;
			}
		}
		
		request.getSession().setAttribute("boardListData", viewBoardListData);
		request.getSession().setAttribute("allBoardListDataSize", allBoardListDataSize);
		request.getSession().setAttribute("pagingData", pagingData);
		
		return "/WEB-INF/views/boardlist.jsp";
	}

}
