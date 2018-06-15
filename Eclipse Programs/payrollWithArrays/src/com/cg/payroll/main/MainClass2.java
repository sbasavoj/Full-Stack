                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              package com.cg.payroll.main;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;				
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int yearlyInvestment=5000;
		String firstName="Ramya";
		Associate associate=searchAssociateId(firstName);
		if(associate!=null)
			System.out.println(associate.getFirstName()+" has greater than "+associate.getSalary().getBasicSalary());
		else
			System.out.println("Not found");
	}
	public static Associate searchAssociateId(String firstName){
		Associate[] associateteam=new Associate[5];	
		associateteam[0]=new Associate(1022, 67000, "Lowkya", "Kandari", "Java", "Jr Con", "IJHUB567", "lowkya@abc.com", new Salary(40000, 1000, 500, 700, 200, 600, 800, 250, 125, 37000, 35000),new BankDetails(1209374, "ICICI", "icici2715"));
		associateteam[1]=new Associate(1035, 21000, "Ramya", "Kandari", "Main Frames", "Jr Con", "IJHUB567", "ramya@abc.com", new Salary(50000, 1400, 500, 700, 200, 600, 800, 250, 125, 45000, 43000),new BankDetails(1209374, "ICICI", "icici2715"));
		associateteam[2]=new Associate();
		for (Associate associate : associateteam) 
			if(associate!=null&&associate.getFirstName()==firstName&&associate.getSalary().getBasicSalary()>35000)
				return associate;
		return null;	
	}		
}
