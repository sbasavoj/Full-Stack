package com.cg.project.listeners;
import java.awt.Event;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ProjectListener implements ServletContextListener {
	Connection con;
	public void contextDestroyed(ServletContextEvent arg0)  { 
	try {
		con.close();
		con=null;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	public void contextInitialized(ServletContextEvent event)  { 
		try {
			ServletContext servletContext=event.getServletContext();
			String driver=servletContext.getInitParameter("driver");
			String url=servletContext.getInitParameter("url");
			String user=servletContext.getInitParameter("user");
			Class.forName(servletContext.getInitParameter("driver"));
			con=DriverManager.getConnection(url, user, "");
			servletContext.setAttribute("con", con);
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
}
