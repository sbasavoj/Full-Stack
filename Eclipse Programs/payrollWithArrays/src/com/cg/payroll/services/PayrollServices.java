package com.cg.payroll.services;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exception.AssociateDetailsNotFoundException;

public interface PayrollServices {

	int acceptAssociateDetails(int yearlyInvestmentUnder80C, String firstName, String lastName, String department,
			String designation, String pancard, String emailId, double basicSalary, double epf, double companyPf,
			int accountNumber, String bankName, String ifscCode);

	double calculateNetSAlary(int associateId)throws AssociateDetailsNotFoundException;

	Associate getAssociateDetails(int associateId)throws AssociateDetailsNotFoundException;

	Associate[] getAllAssociateDetails();
	
	boolean deleteAssociateDetails(int associateId);
	

}