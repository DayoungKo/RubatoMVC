package com.ja.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.controller.command.*;

public class ControllerUsingURI extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private CommandHandlerMapper commandHandlerMapper = null;
       
    public ControllerUsingURI() 
    {
        super();
    }

	public void init(ServletConfig config) throws ServletException 
	{
		//상속받은 init을 호출 -> 내부적으로 HttpServlet이 init을 수행하기전
		//getServletContext()를 처리함
		super.init(config);
		
		String realRootPath = getServletContext().getRealPath("/");
		commandHandlerMapper = new CommandHandlerMapper(realRootPath);

		System.out.println("realRootPath: "+realRootPath);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String command = request.getRequestURI();
		command = command.substring(request.getContextPath().length());
		System.out.println("실행 command: "+command);
		
		CommandHandler handler = commandHandlerMapper.getCommandHandler(command);
		
		if(handler != null)
		{
			String view = handler.process(request, response);
			
			if(view != null)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
			else	//예외처리
			{
				System.out.println("view == null");
			}
		}
		else
		{
			System.out.println("handler == null");
		}
	}
}
