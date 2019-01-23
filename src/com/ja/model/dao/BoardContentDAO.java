package com.ja.model.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import com.ja.model.dto.*;

public class BoardContentDAO 
{
	public ArrayList<BoardContentDTO> selectAllBoardList()
	{
		ArrayList<BoardContentDTO> boardContentList = new ArrayList<>();
		
		String query = "SELECT * FROM BOARDCONTENT_1023 ORDER BY BC_WRITEDATE DESC";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next())
			{
				//작성날짜 로직
				String writeTime = rs.getString("BC_WRITEDATE");
				writeTime = setWriteDate(writeTime);
				
				//List로직
				boardContentList.add(new BoardContentDTO(
						rs.getString("BC_IDX"),
						rs.getString("M_IDX"),
						rs.getString("BC_TITLE"),
						rs.getString("BC_CONTENT"),
						rs.getString("BC_ATTACH_NAME"),
						rs.getString("BC_ATTACH_URL"),
						rs.getString("BC_LOOK_COUNT"),
						writeTime
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, rs);
		}
		return boardContentList;
	}

	public ArrayList<BoardContentDTO> selectBoardListByTitle(String search_content)
	{
		ArrayList<BoardContentDTO> boardContentList = new ArrayList<>();
		
		String query = "SELECT * FROM BOARDCONTENT_1023 WHERE BC_TITLE LIKE ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, "%"+search_content+"%");
			rs = pstm.executeQuery();
			
			while(rs.next())
			{
				//작성날짜 로직
				String writeTime = rs.getString("BC_WRITEDATE");
				writeTime = setWriteDate(writeTime);
				
				//List로직
				boardContentList.add(new BoardContentDTO(
						rs.getString("BC_IDX"),
						rs.getString("M_IDX"),
						rs.getString("BC_TITLE"),
						rs.getString("BC_CONTENT"),
						rs.getString("BC_ATTACH_NAME"),
						rs.getString("BC_ATTACH_URL"),
						rs.getString("BC_LOOK_COUNT"),
						writeTime
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, rs);
		}
		return boardContentList;
	}
	
	public ArrayList<BoardContentDTO> selectBoardListByContent(String search_content)
	{
		ArrayList<BoardContentDTO> boardContentList = new ArrayList<>();
		
		String query = "SELECT * FROM BOARDCONTENT_1023 WHERE BC_CONTENT LIKE ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, "%"+search_content+"%");
			rs = pstm.executeQuery();
			
			while(rs.next())
			{
				//작성날짜 로직
				String writeTime = rs.getString("BC_WRITEDATE");
				writeTime = setWriteDate(writeTime);
				
				//List로직
				boardContentList.add(new BoardContentDTO(
						rs.getString("BC_IDX"),
						rs.getString("M_IDX"),
						rs.getString("BC_TITLE"),
						rs.getString("BC_CONTENT"),
						rs.getString("BC_ATTACH_NAME"),
						rs.getString("BC_ATTACH_URL"),
						rs.getString("BC_LOOK_COUNT"),
						writeTime
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, rs);
		}
		return boardContentList;
	}

	public ArrayList<BoardContentDTO> selectBoardListByM_idx(String m_idx)
	{
		ArrayList<BoardContentDTO> boardContentList = new ArrayList<>();
		
		String query = "SELECT * FROM BOARDCONTENT_1023 WHERE M_IDX=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, m_idx);
			rs = pstm.executeQuery();
			
			while(rs.next())
			{
				//작성날짜 로직
				String writeTime = rs.getString("BC_WRITEDATE");
				writeTime = setWriteDate(writeTime);
				
				//List로직
				boardContentList.add(new BoardContentDTO(
						rs.getString("BC_IDX"),
						rs.getString("M_IDX"),
						rs.getString("BC_TITLE"),
						rs.getString("BC_CONTENT"),
						rs.getString("BC_ATTACH_NAME"),
						rs.getString("BC_ATTACH_URL"),
						rs.getString("BC_LOOK_COUNT"),
						writeTime
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, rs);
		}
		return boardContentList;
	}
	
	public BoardContentDTO getBoardByIdx(String bc_idx)
	{
		BoardContentDTO boardContentDto = null;
		
		String query = "SELECT * FROM BOARDCONTENT_1023 WHERE BC_IDX=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bc_idx);
			rs = pstm.executeQuery();
			
			if(rs.next())
			{
				boardContentDto = new BoardContentDTO(
						rs.getString("BC_IDX"),
						rs.getString("M_IDX"),
						rs.getString("BC_TITLE"),
						rs.getString("BC_CONTENT"),
						rs.getString("BC_ATTACH_NAME"),
						rs.getString("BC_ATTACH_URL"),
						rs.getString("BC_LOOK_COUNT"),
						rs.getString("BC_WRITEDATE")
						);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, rs);
		}
		return boardContentDto;
	}
	
	
	
	public void insertBoardData(String m_idx, String title, String content, String attach_name, String attach_url)
	{
		String query = "INSERT INTO BOARDCONTENT_1023 VALUES(SEQ_BOARDCONTENT_IDX.NEXTVAL,?,?,?,?,?, 0,SYSDATE)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, m_idx);
			pstm.setString(2, title);
			pstm.setString(3, content);
			pstm.setString(4, attach_name);
			pstm.setString(5, attach_url);
			
			pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, null);
		}
	}
	
	public void deleteBoardData(String bc_idx)
	{
		String query = "DELETE BOARDCONTENT_1023 WHERE BC_IDX=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bc_idx);
			pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, null);
		}
	}
	
	public void updateBoardData(String bc_idx, String title, String content, String attach_name, String attach_url)
	{
		String query = "UPDATE BOARDCONTENT_1023 SET BC_TITLE=?, BC_CONTENT=?, BC_ATTACH_NAME=?, BC_ATTACH_URL=? WHERE BC_IDX=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setString(3, attach_name);
			pstm.setString(4, attach_url);
			pstm.setString(5, bc_idx);
			pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, null);
		}
	}
	
	public void addLookCountData(String bc_idx, String look_count)
	{
		String query = "UPDATE BOARDCONTENT_1023 SET BC_LOOK_COUNT=? WHERE BC_IDX=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, look_count);
			pstm.setString(2, bc_idx);
			pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, pstm, null);
		}
	}
	
	String setWriteDate(String writeTime)
	{
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date todayDate = new Date();
		String checkDate = dateFormat.format(todayDate);
		
		if(writeTime.substring(0, 10).equals(checkDate))
		{
			writeTime = writeTime.substring(11, 19);
		}
		else
		{
			writeTime = writeTime.substring(0, 10);
		}
		return writeTime;
	}
}
