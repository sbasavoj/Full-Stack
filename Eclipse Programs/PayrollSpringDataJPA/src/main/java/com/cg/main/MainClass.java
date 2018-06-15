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
			int associateId=payrollServices.acceptAssociateDetails(10000, "Vidya", "Basavoju", "Java", "Trainee", "AJSU123", "vidya@gmail.com", 6000, 1000, 1000, 1236, "ICICI", "ICICI123");
			payrollServices.calculateNetSAlary(associateId);
			System.out.println("Associate Details are: "+payrollServices.getAssociateDetails(associateId));
		    System.out.println(payrollServices.deleteAssociateDetails(associateId));
		    int associateId1=payrollServices.acceptAssociateDetails(2000, "Lekha", "Ganapa", "Java", "Trainee", "AJSU123", "vidya@gmail.com", 20000, 1000, 1000, 12534, "SBI", "SBI123");
		    System.out.println(payrollServices.getAllAssociateDetails());
		} catch (PayrollServicesDownException | AssociateDetailsNotFoundException e) {
			e.printStackTrace();
		}
	}

}
