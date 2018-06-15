package com.cg.services;
import java.util.List;

import com.cg.beans.Associate;
import com.cg.exception.AssociateDetailsNotFoundException;
import com.cg.exception.PayrollServicesDownException;
public interface PayrollServices {
	int acceptAssociateDetails(int yearlyInvestmentUnder80C, String firstName, String lastName, String department,
			String designation, String pancard, String emailId, double basicSalary, double epf, double companyPf,
			int accountNumber, String bankName, String ifscCode)throws PayrollServicesDownException;

	double calculateNetSAlary(int associateId)throws AssociateDetailsNotFoundException,PayrollServicesDownException;

	Associate getAssociateDetails(int associateId)throws AssociateDetailsNotFoundException,PayrollServicesDownException;

	List<Associate> getAllAssociateDetails() throws PayrollServicesDownException;
	
	boolean deleteAssociateDetails(int associateId) throws AssociateDetailsNotFoundException,PayrollServicesDownException;
	

}
