package com.cg.payroll.daoservices;
import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exception.PayrollServicesDownException;

public interface PayrollDAOServices {

	int insertAssociate(Associate associate) throws PayrollServicesDownException;

	boolean updateAssociate(Associate associate)throws PayrollServicesDownException;

	boolean deleteAssociate(int associateId)throws PayrollServicesDownException;

	Associate getAssociate(int associateId)throws PayrollServicesDownException;

	List<Associate> getAssociates()throws PayrollServicesDownException;

}