package com.ja.listener;

import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.*;

public class DBCPInitListener implements ServletContextListener 
{
    public DBCPInitListener() 
    {
    }

    public void contextDestroyed(ServletContextEvent arg0) 
    {
    }

    public void contextInitialized(ServletContextEvent arg0)  
    {
    	System.out.println("DBCP 가동 코드 시작: ");
    	try 
    	{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:MYORACLE";
			String username = "userName";
			String pw = "password";

			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, pw);

			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);

			poolableConnFactory.setValidationQuery("SELECT 1 FROM member_1023");

			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxTotal(50);

			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("boardMVC", connectionPool);
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
    }
	
}
