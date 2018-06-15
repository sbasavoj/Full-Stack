package com.cg.inheritance.main;

import com.cg.inheritance.beans.CEmployee;
import com.cg.inheritance.beans.Developer;
import com.cg.inheritance.beans.Employee;
//import com.cg.inheritance.beans.Employee;
import com.cg.inheritance.beans.PEmployee;
import com.cg.inheritance.beans.SalesManager;

public class MainClass {

	public static void main(String[] args) {

		PEmployee pemp=new PEmployee(1234, 4561, "Vidya", "Basavoju");
		pemp.calculateSalary();
		System.out.println(pemp.toString());

		CEmployee cemployee=new CEmployee(1002, "Sravan", "Boinapally", 10);
		cemployee.calculateSalary();
		System.out.println(cemployee.toString());

		Developer developer=new Developer(1005, 3000, "Lowkya", "Kandari", 3);
		developer.calculateSalary();
		System.out.println(developer.toString());

		SalesManager salesperson=new SalesManager(1097, 2000, "Lekha", "Ganapa", 3);
		salesperson.calculateSalary();
		System.out.println(salesperson.toString());
		
		Employee emp1;
		emp1=new CEmployee(1987, "Nikhila", "Ravipudi", 10);
		CEmployee cemp=(CEmployee)emp1;
		cemp.signTheContract();
		emp1.calculateSalary();
		emp1.toString();
		
		
	}
}