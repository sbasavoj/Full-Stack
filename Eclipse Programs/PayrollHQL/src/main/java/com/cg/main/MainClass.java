package com.cg.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.exception.AssociateDetailsNotFoundException;
import com.cg.exception.PayrollServicesDownException;
import com.cg.services.PayrollServices;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
		PayrollServices payrollServices=(PayrollServices) applicationContext.getBean("services");
		try {
			int associateId=payrollServices.acceptAssociateDetails(2000, "Vidya", "Basavoju", "Java", "trainee", "FGHJ123K", "vidya@gmail.com", 5000, 1000, 1000, 123456, "ICICI", "ICICI123");
		System.out.println("Associate Created with Id "+associateId);
		System.out.println("Net salary= "+payrollServices.calculateNetSAlary(associateId));
		System.out.println("Details of ID "+associateId+" are "+ payrollServices.getAssociateDetails(associateId));
		
		} catch (PayrollServicesDownException e) {
			e.printStackTrace();
		} catch (AssociateDetailsNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
