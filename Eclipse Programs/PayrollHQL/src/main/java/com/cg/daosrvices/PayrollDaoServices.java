package com.cg.daosrvices;
import java.util.List;
import com.cg.beans.Associate;
import com.cg.exception.PayrollServicesDownException;
public interface PayrollDaoServices {
	int insertAssociate(Associate associate) throws PayrollServicesDownException;

	boolean updateAssociate(Associate associate)throws PayrollServicesDownException;

	boolean deleteAssociate(int associateId)throws PayrollServicesDownException;

	Associate getAssociate(int associateId)throws PayrollServicesDownException;

	List<Associate> getAssociates()throws PayrollServicesDownException;

}
