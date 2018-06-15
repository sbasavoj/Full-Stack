package com.cg.project.views;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		PrintWriter abc=response.getWriter();
		abc.println("<html>");
		abc.println("<head>");
		abc.println("<body>");
		abc.println("<div align='center'>");
		abc.println("<h1 style='color:maroon'>This is from SuccessServlet</h1>");
		abc.println("<h2 style='color:green'>Welcome "+userName+"</h2>");
		abc.println("</div>");
		abc.println("</body>");
		abc.println("</head>");
		abc.println("</html>");
		}
}

