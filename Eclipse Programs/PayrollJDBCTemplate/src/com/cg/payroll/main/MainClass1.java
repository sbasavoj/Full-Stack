package com.cg.payroll.main;
import java.util.Scanner;
import com.cg.payroll.beans.Associate;
//import com.cg.payroll.beans.BankDetails;
//import com.cg.payroll.beans.Salary;
import com.cg.payroll.exception.AssociateDetailsNotFoundException;
import com.cg.payroll.exception.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class MainClass1 {
	public static void main(String[] args) throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		PayrollServices payrollServies=new PayrollServicesImpl();
		int option=0;
		while(option!=6){
			try{
				Scanner sc=new Scanner(System.in);
				System.out.println(	"MENU:"+"\n"+
						"1.To enter Associate Details"+"\n"+
						"2.To Calculate Net Salary"+"\n"+
						"3.To View Details Of Associate"+"\n"+
						"4.To Delete an Associate"+"\n"+
						"5.To View All Associate Details"+"\n"+
						"6.Exit"+"\n");
				System.out.println("Enter valid option:");
				option=sc.nextInt();
				switch (option) {
				case 1:System.out.println("Enter yearlyInvestmentUnder80C");
				int yearlyInvestmentUnder80C=sc.nextInt();
				System.out.println("Enter firstName");
				String firstName=sc.next();
				System.out.println("Enter lastName");
				String lastName=sc.next();
				System.out.println("Enter department");
				String department=sc.next();
				System.out.println("Enter designation");
				String designation=sc.next();
				System.out.println("Enter pancard");
				String pancard=sc.next();
				System.out.println("Enter emailId");
				String emailId=sc.next();
				System.out.println("Enter bankName");
				String bankName=sc.next();
				System.out.println("Enter accountNumber");
				int accountNumber=sc.nextInt();
				System.out.println("Enter ifscCode");
				String ifscCode=sc.next();
				System.out.println("Enter basicSalary");
				double basicSalary=sc.nextDouble();
				System.out.println("Enter epf");
				double epf=sc.nextDouble();
				System.out.println("Enter companyPf");
				double companyPf=sc.nextDouble();
				int associateId1=payrollServies.acceptAssociateDetails(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, basicSalary, epf, companyPf, accountNumber, bankName, ifscCode);
				System.out.println("Created Associate Id is:"+associateId1);
				break;
				case 2:
					System.out.println("Enter AssociateId:");
					int associateId2=sc.nextInt();
					double netSalary=payrollServies.calculateNetSAlary(associateId2);
					String name=payrollServies.getAssociateDetails(associateId2).getFirstName();
					System.out.println("Net salary of "+name+" is "+netSalary);
					break;
				case 3:System.out.println("Enter Associate Id to be Searched: ");
				int associateId3=sc.nextInt();
				System.out.println(payrollServies.getAssociateDetails(associateId3));
				break;
				case 4:System.out.println("Enter Associate Id to be Deleted: ");
				int associateId4=sc.nextInt();
				System.out.println("Is the Object Deleted?"+payrollServies.deleteAssociateDetails(associateId4));
				break;
				case 5:System.out.println("Below are the Details of All Associates:");
				for (Associate associate : payrollServies.getAllAssociateDetails()) 
					System.out.println(associate);
				break;
				case 6:
					System.out.println("Exit");
					break;
				default:System.out.println("Please Choose the Correct Option");
				break;
				}
				sc.close();
			}
			catch (AssociateDetailsNotFoundException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Exit");
	}

}


