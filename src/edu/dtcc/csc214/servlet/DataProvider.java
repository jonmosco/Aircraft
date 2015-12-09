package edu.dtcc.csc214.servlet;
import edu.dtcc.csc214.aircraft.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataProvider
 */

@WebServlet("/GetSampleCount")

public class DataProvider extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		
		/*
		 * In the DataProvider init() method, it will ask the SystemDriver 
		 * to create all objects and the related objects. It then sets the
		 *  observable pattern and kick off the thread (ScheduledTask). 
		 */
		
		SystemDriver ourDriver = new SystemDriver();
		
		// create our thread
        Thread myThread = new Thread(ourDriver);
        
        // create our scheduled task
        ScheduledTask ourTask = new ScheduledTask();
        
        myThread.start();
		
	}
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();

		String command = request.getParameter("setHeading");
		if (command != null) {
			Double newHeading = new Double(Double.parseDouble(command));
			SystemDriver.setHeading(newHeading);
		}

		command = request.getParameter("setSpeed");
		if (command != null) {
			Double newSpeed = new Double(Double.parseDouble(command));
			SystemDriver.setSpeed(newSpeed);
		}

		command = request.getParameter("sysinit");
		if (command != null) {

			SystemDriver.resetAirplane();
		}

		writer.println(SystemDriver.getStatus());

		doGet(request, response);
	}

}
