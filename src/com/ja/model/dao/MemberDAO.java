package com.ja.model.dao;

import java.sql.*;
import com.ja.model.dto.MemberDTO;

public class MemberDAO 
{
	public void insert(String id, String pw, String nick, String phone)
	{
		String query = "INSERT INTO MEMBER_1023 VALUES(SEQ_MEMBER_IDX.NEXTVAL,?,?,?,?,SYSDATE)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, id);
			pstm.setString(2, pw);
			pstm.setString(3, nick);
			pstm.setString(4, phone);
			
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
	
	public MemberDTO selectById(String m_id)
	{
		MemberDTO memberDto = null;
		
		String query = "SELECT * FROM MEMBER_1023 WHERE M_ID = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, m_id);
			rs= pstm.executeQuery();
			
			//로직 처리
			if(rs.next())
			{
				memberDto = new MemberDTO(
						rs.getString("M_IDX"),
						rs.getString("M_ID"),
						rs.getString("M_PW"),
						rs.getString("M_NICK"),
						rs.getString("M_PHONE"),
						rs.getString("M_JOINDATE")
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
		return memberDto;
	}
	
	public MemberDTO selectByIdx(String m_idx)
	{
		MemberDTO memberDto = null;
		
		String query = "SELECT * FROM MEMBER_1023 WHERE M_IDX = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, m_idx);
			rs= pstm.executeQuery();
			
			//로직 처리
			if(rs.next())
			{
				memberDto = new MemberDTO(
						rs.getString("M_IDX"),
						rs.getString("M_ID"),
						rs.getString("M_PW"),
						rs.getString("M_NICK"),
						rs.getString("M_PHONE"),
						rs.getString("M_JOINDATE")
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
		return memberDto;
	}
	
	public MemberDTO selectByNick(String m_nick)
	{
		MemberDTO memberDto = null;
		
		String query = "SELECT * FROM MEMBER_1023 WHERE M_NICK = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, m_nick);
			rs= pstm.executeQuery();
			
			//로직 처리
			if(rs.next())
			{
				memberDto = new MemberDTO(
						rs.getString("M_IDX"),
						rs.getString("M_ID"),
						rs.getString("M_PW"),
						rs.getString("M_NICK"),
						rs.getString("M_PHONE"),
						rs.getString("M_JOINDATE")
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
		return memberDto;
	}
}
