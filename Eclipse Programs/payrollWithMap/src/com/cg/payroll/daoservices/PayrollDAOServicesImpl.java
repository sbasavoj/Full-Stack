package com.cg.payroll.daoservices;
import com.cg.payroll.beans.Associate;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
//import java.util.LinkedList;
import java.util.List;
public class PayrollDAOServicesImpl implements PayrollDAOServices {
	public static HashMap<Integer,Associate> associateMap=new HashMap<>();
	public static int ASSOCIATE_ID_INDEX=111;
	@Override
	public int insertAssociate(Associate associate) {
		associate.setAssociateId(ASSOCIATE_ID_INDEX++);
		associateMap.put(associate.getAssociateId(), associate);
		return associate.getAssociateId();
	}

	@Override
	public boolean updateAssociate(Associate associate) {
		associateMap.put(associate.getAssociateId(), associate);
		return true;
	}

	@Override
	public boolean deleteAssociate(int associateId) {
		boolean existingAssociate=associateMap.containsKey(associateId);
		associateMap.remove(associateId);
		return existingAssociate;
	}

	@Override
	public Associate getAssociate(int associateId) {
		return associateMap.get(associateId);
	}

	@Override
	public List<Associate> getAssociates() {
		return new ArrayList<Associate>(associateMap.values());
	}

}