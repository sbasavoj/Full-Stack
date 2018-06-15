package com.cg.project.beans;

import java.util.Comparator;

public class CompareClass implements Comparator<Associate>{

	@Override
	public int compare(Associate o1, Associate o2) {
		//return o1.getAssociateId()-o2.getAssociateId();
		return o1.getFirstName().compareTo(o2.getFirstName());
	}
}
  