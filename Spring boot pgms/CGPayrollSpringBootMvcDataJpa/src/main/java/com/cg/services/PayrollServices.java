package com.cg.services;
import java.util.List;

import com.cg.beans.Associate;
import com.cg.exception.AssociateDetailsNotFoundException;
import com.cg.exception.PayrollServicesDownException;
public interface PayrollServices {
	int acceptAssociateDetails(Associate associate)throws PayrollServicesDownException;

	double calculateNetSAlary(int associateId)throws AssociateDetailsNotFoundException,PayrollServicesDownException;

	Associate getAssociateDetails(int associateId)throws AssociateDetailsNotFoundException,PayrollServicesDownException;

	List<Associate> getAllAssociateDetails() throws PayrollServicesDownException;
	
	boolean deleteAssociateDetails(int associateId) throws AssociateDetailsNotFoundException,PayrollServicesDownException;
	

}
