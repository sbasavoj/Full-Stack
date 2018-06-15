package com.cg.payroll.main;

import java.util.Scanner;

import com.cg.payroll.exception.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass1 {

	public static void main(String[] args) {
		PayrollServices payrollServies=new PayrollServicesImpl();
		System.out.println("MENU:"+"\n"+"1.To enter Associate Details"+"2.To Calculate Net Salary"+"\n"+"3.To View Details Of Associate"+"\n"+"4.To Delete an Associate"+"\n"+"5.To View All Associate Details");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter valid option:");
		int option=sc.nextInt();
		switch (option) {
		case 1:System.out.println("Created Associate Id is:"+(payrollServies.acceptAssociateDetails(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextInt(), sc.next(), sc.next())));
		break;
		case 2:try {
			int associateId=sc.nextInt();
				System.out.println("Net salary of "+payrollServies.getAssociateDetails(associateId).getFirstName()+" is "+payrollServies.calculateNetSAlary(associateId));
			} catch (AssociateDetailsNotFoundException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}

}
