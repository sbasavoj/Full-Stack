package com.cg.payroll.main;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.exception.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
//import com.cg.payroll.beans.BankDetails;
//import com.cg.payroll.beans.Salary;
public class MainClass {

	public static void main(String[] args) {
		PayrollServices payrollServies=new PayrollServicesImpl();
		try {
			int associateId1=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
			System.out.println("Associate ID:"+associateId1);
			System.out.println("Name        :"+payrollServies.getAssociateDetails(associateId1).getFirstName());
			System.out.println("Salary      :"+payrollServies.calculateNetSAlary(associateId1));
			System.out.println("Monthly Tax :"+payrollServies.getAssociateDetails(associateId1).getSalary().getMonthlyTax());
			int associateId2=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
			System.out.println("Associate ID:"+associateId2);
			int associateId3=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
			System.out.println("Associate ID:"+associateId3);
			int associateId4=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
			System.out.println("Associate ID:"+associateId4);
			int associateId5=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
			System.out.println("Associate ID:"+associateId5);
			int associateId6=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
			System.out.println("Associate ID:"+associateId6);
			System.out.println((payrollServies.getAllAssociateDetails()).length);
			int associateId7=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
			System.out.println("Associate ID:"+associateId7);
			System.out.println(payrollServies.calculateNetSAlary(189330));
		}
			catch (AssociateDetailsNotFoundException e) {
				//e.printStackTrace();
				System.out.println(e);
			}
		
		try{
		int associateId8=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
		System.out.println("Associate ID:"+associateId8);
		System.out.println((payrollServies.getAllAssociateDetails()).length);
		int associateId9=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
		System.out.println("Associate ID:"+associateId9);
		System.out.println((payrollServies.getAllAssociateDetails()).length);
		int associateId10=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
		System.out.println("Associate ID:"+associateId10);
		int associateId11=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
		System.out.println("Associate ID:"+associateId11);
		int associateId12=payrollServies.acceptAssociateDetails(150000, "Srividya", "Basavoju", "java", "trainee", "135FHJY", "vidya@gmail.com", 17000, 1000, 1000, 12345, "ICICI", "icici123");
		System.out.println("Associate ID:"+associateId12);
		System.out.println((payrollServies.getAllAssociateDetails()).length);
		System.out.println("Is the object deleted? :"+payrollServies.deleteAssociateDetails(122));
		for(Associate a:payrollServies.getAllAssociateDetails())
			System.out.println(a);
		}
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e);

		}



	}


}


