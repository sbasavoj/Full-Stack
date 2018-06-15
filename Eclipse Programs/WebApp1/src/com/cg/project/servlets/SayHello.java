package com.cg.project.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/sayhello")
public class SayHello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter abc=response.getWriter();
	abc.println("<html>");
	abc.println("<head>");
	abc.println("<body>");
	abc.println("<div align='center'>");
	abc.println("<h1 style='color:red'>");
	abc.println("Hello Vidya! Have a nice day");
	abc.println("</h1>");
	abc.println("<h2>");
	abc.println("This is from HelloServlet ");
	abc.println("</h2>");
	abc.println("</div>");
	abc.println("</body>");
	abc.println("</head>");
	abc.println("</html>");
	}

}
