package com.cg.project.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		RequestDispatcher dispatcher;
		if(userName.equals("vidya")&&password.equals("12345")){
			dispatcher=request.getRequestDispatcher("SuccessServlet");
			request.setAttribute("userName", userName);
			request.setAttribute("password", password);
		}
		else
			dispatcher=request.getRequestDispatcher("FailureServlet");
		dispatcher.forward(request, response);
	}

}
