package com.cg.project.views;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FailureServlet")
public class FailureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter abc=response.getWriter();
		abc.println("<html>");
		abc.println("<head>");
		abc.println("<body>");
		abc.println("<div align='center'>");
		abc.println("<h1 style='color:maroon'>This is from FailureServlet</h1>");
		abc.println("<h2 style='color:red'>Your User Name or Password is Incorrect</h2>");
		abc.println("</div>");
		abc.println("</body>");
		abc.println("</head>");
		abc.println("</html>");
	}

}
