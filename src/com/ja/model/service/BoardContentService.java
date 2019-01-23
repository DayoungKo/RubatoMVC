package com.ja.model.service;

import com.ja.model.dao.*;
import com.ja.model.dto.*;
import com.ja.model.vo.*;
import java.util.*;

public class BoardContentService 
{
	public ArrayList<BoardContentData> getBoardList()
	{
		ArrayList<BoardContentData> boardListData = new ArrayList<>();
		ArrayList<BoardContentDTO> boardContentList = new BoardContentDAO().selectAllBoardList();
		
		for(BoardContentDTO boardContentDto:boardContentList)
		{
			MemberDTO memberDto = new MemberDAO().selectByIdx(boardContentDto.getM_idx());
			boardListData.add(new BoardContentData(boardContentDto,memberDto));
		}
		return boardListData;
	}
	
	public ArrayList<BoardContentData> getBoardListByTitle(String search_content)
	{
		ArrayList<BoardContentData> boardListData = new ArrayList<>();
		ArrayList<BoardContentDTO> boardContentList = new BoardContentDAO().selectBoardListByTitle(search_content);
		
		for(BoardContentDTO boardContentDto:boardContentList)
		{
			MemberDTO memberDto = new MemberDAO().selectByIdx(boardContentDto.getM_idx());
			boardListData.add(new BoardContentData(boardContentDto,memberDto));
		}
		return boardListData;
	}
	
	public ArrayList<BoardContentData> getBoardListByContent(String search_content)
	{
		ArrayList<BoardContentData> boardListData = new ArrayList<>();
		ArrayList<BoardContentDTO> boardContentList = new BoardContentDAO().selectBoardListByContent(search_content);
		
		for(BoardContentDTO boardContentDto:boardContentList)
		{
			MemberDTO memberDto = new MemberDAO().selectByIdx(boardContentDto.getM_idx());
			boardListData.add(new BoardContentData(boardContentDto,memberDto));
		}
		return boardListData;
	}
	
	public ArrayList<BoardContentData> getBoardListByWriter(String search_content)
	{
		MemberDTO checkMemberDto = new MemberDAO().selectByNick(search_content);
		ArrayList<BoardContentData> boardListData = new ArrayList<>();
		
		if(checkMemberDto != null)
		{
			String writer_idx = checkMemberDto.getM_idx();
			ArrayList<BoardContentDTO> boardContentList = new BoardContentDAO().selectBoardListByM_idx(writer_idx);
			for(BoardContentDTO boardContentDto:boardContentList)
			{
				MemberDTO memberDto = new MemberDAO().selectByIdx(boardContentDto.getM_idx());
				boardListData.add(new BoardContentData(boardContentDto,memberDto));
			}
		}
		return boardListData;
	}
	
	public void writeBoard(String m_idx, String title, String content, String attach_name, String attach_url)
	{
		new BoardContentDAO().insertBoardData(m_idx, title, content, attach_name, attach_url);
	}
	
	public BoardContentData getBoardContent(String bc_idx)
	{
		BoardContentDTO boardContentDto = new BoardContentDAO().getBoardByIdx(bc_idx);
		MemberDTO memberDto = new MemberDAO().selectByIdx(boardContentDto.getM_idx());
		
		BoardContentData boardContentData = new BoardContentData(boardContentDto, memberDto);
		
		return boardContentData;
	}
	
	public void deleteBoardContent(String bc_idx)
	{
		new BoardContentDAO().deleteBoardData(bc_idx);
	}
	
	public void updateBoardContent(String bc_idx, String title, String content, String attach_name, String attach_url)
	{
		new BoardContentDAO().updateBoardData(bc_idx, title, content, attach_name, attach_url);
	}
	
	public void addLookCount(String bc_idx, String look_count)
	{
		new BoardContentDAO().addLookCountData(bc_idx, look_count);
	}
}
