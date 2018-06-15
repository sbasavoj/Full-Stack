package com.cg.payroll.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.cg.payroll.exception.PayrollServicesDownException;
public class PayrollUtility {
	private static Connection con=null;
	public static Connection getDBConnection() throws PayrollServicesDownException {
		try {
			if(con==null){
				Properties properties=new Properties();
				properties.load(new FileInputStream(new File(".//resources//payroll.properties")));
				Class.forName(properties.getProperty("driver"));
				con=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),"");
			}
			return con;
		} catch (IOException|ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownException("Payroll services are down!", e);
		}

	}
}
