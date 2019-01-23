package com.ja.model.dao;

import java.sql.*;

public class JDBCUtil 
{
	public static Connection getConnection()
	{
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:boardMVC");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stm, ResultSet rs)
	{
		try
		{
			if(rs != null) rs.close();
			if(stm != null) stm.close();
			if(conn != null) conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
