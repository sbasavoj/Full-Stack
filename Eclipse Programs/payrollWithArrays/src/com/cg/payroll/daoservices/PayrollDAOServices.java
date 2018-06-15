package com.cg.payroll.daoservices;

import com.cg.payroll.beans.Associate;

public interface PayrollDAOServices {

	int insertAssociate(Associate associate);

	boolean updateAssociate(Associate associate);

	boolean deleteAssociate(int associateId);

	Associate getAssociate(int associateId);

	Associate[] getAssociates();

}