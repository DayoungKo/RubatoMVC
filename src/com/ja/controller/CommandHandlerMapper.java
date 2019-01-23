package com.ja.controller;

import java.util.*;
import com.ja.controller.command.*;
import java.io.*;

public class CommandHandlerMapper 
{
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	public CommandHandlerMapper(String contextRealPath)
	{
		String configFile = "\\WEB-INF\\commandHandlerURI.prop";
		String configFilePath = contextRealPath + configFile;
		
		//property Parser
		Properties prop = new Properties();
		
		FileReader fis = null;
		try
		{
			fis = new FileReader(configFilePath);
			prop.load(fis);
			
			Iterator<Object> keyIter = prop.keySet().iterator();
			
			while(keyIter.hasNext())
			{
				String command = (String) keyIter.next();
				String handlerClassName = prop.getProperty(command);
				
				Class<?> handlerClass = Class.forName(handlerClassName);
				
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				
				commandHandlerMap.put(command, handlerInstance);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
			fis.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public CommandHandler getCommandHandler(String command)
	{
		return commandHandlerMap.get(command);
	}
	
}
