package com.cg.payroll.daoservices;
import com.cg.payroll.beans.Associate;
import java.util.Arrays;
public class PayrollDAOServicesImpl implements PayrollDAOServices {
	private static Associate[] associateList=new Associate[10];
	private static int ASSOCIATE_ID_COUNTER=111;
	private static int ASSOCIATE_IDX_COUNTER=0;

	@Override
	public int insertAssociate(Associate associate){
		associate.setAssociateId(ASSOCIATE_ID_COUNTER++);
		if(ASSOCIATE_IDX_COUNTER>.7*associateList.length){
			Associate[] tempArray = Arrays.copyOf(associateList, associateList.length+10);
			associateList=tempArray;
		}
		associateList[ASSOCIATE_IDX_COUNTER++]=associate;
		return associate.getAssociateId();
	}
	@Override
	public boolean updateAssociate (Associate associate){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i]!=null&&associateList[i].getAssociateId()==associate.getAssociateId()){
				associateList[i]=associate;
				return true;
			}
		return false;
	}

	@Override
	public boolean deleteAssociate(int associateId){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i]!=null&&associateId==associateList[i].getAssociateId()){
				associateList[i]=null;
				for(int j=i;j<associateList.length&&(j+1)!=associateList.length;j++){
					associateList[j]=associateList[j+1];
					associateList[j+1]=null;
				}
				return true;
			}
		return false;
	}

	@Override
	public Associate getAssociate(int associateId){
		for(Associate a:associateList)
			if(a!=null&&a.getAssociateId()==associateId)
				return a;	
		return null;
	}

	@Override
	public Associate[] getAssociates(){
		return associateList;
	}

}