package com.cg.project.servlets;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.project.beans.RegisterDetails;
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = getServletContext();
		con=(Connection)servletContext.getAttribute("con");
	}
	public void destroy() {
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String>communicationMode=(ArrayList<String>)Arrays.asList(request.getParameterValues("communicationMode"));
		String name=request.getParameter("name");
		String emailId=request.getParameter("emailId");
		String gender=request.getParameter("gender");
		String graduation=request.getParameter("graduation");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String rPassword=request.getParameter("rPassword");
		int age=Integer.parseInt(request.getParameter("age"));
		long mobileNo=Long.parseLong(request.getParameter("mobileNo"));
		RequestDispatcher dispatcher;
		RegisterDetails registerDetails=new RegisterDetails(name, emailId, gender, graduation, userName, password, rPassword, age, mobileNo, communicationMode);
		if(name==null||emailId==null||gender==null||graduation==null||userName==null||password==null||rPassword==null||age==0||mobileNo==0l){
			dispatcher = request.getRequestDispatcher("RegisterErrorServlet");
			request.setAttribute("errorMessage","Enter all the Details");
		}
		else{
			dispatcher = request.getRequestDispatcher("RegisterSuccessServlet");
			request.setAttribute("registerDetails",registerDetails);
		}
		dispatcher.forward(request, response);	
	}

}
