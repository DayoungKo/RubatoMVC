package com.ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import com.ja.model.dto.*;

public class BCReplyDAO 
{
	public ArrayList<BCReplyDTO> selectBCReplyList(String bc_idx)
	{
		ArrayList<BCReplyDTO> bcReplyList = new ArrayList<>();
		
		String query = "SELECT * FROM BC_REPLY WHERE BC_IDX=? ORDER BY BC_REPLY_IDX";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bc_idx);
			rs = pstm.executeQuery();
			
			while(rs.next())
			{
				//작성날짜 로직
				String writeTime = rs.getString("BC_REPLY_WRITEDATE");
				writeTime = setWriteDate(writeTime);
				
				//List로직
				bcReplyList.add(new BCReplyDTO(
						rs.getString("BC_REPLY_IDX"),
						rs.getString("BC_IDX"),
						rs.getString("M_IDX"),
						rs.getString("BC_REPLY_CONTENT"),
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
		return bcReplyList;
	}
	
	public void insertBCReplyData(String bc_idx, String m_idx, String bc_reply_content)
	{
		String query = "INSERT INTO BC_REPLY VALUES(SEQ_BC_REPLY_IDX.NEXTVAL,?,?,?,SYSDATE)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bc_idx);
			pstm.setString(2, m_idx);
			pstm.setString(3, bc_reply_content);
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
	
	public void deleteBCReplyData(String bc_reply_idx)
	{
		String query = "DELETE BC_REPLY WHERE BC_REPLY_IDX=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bc_reply_idx);
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
