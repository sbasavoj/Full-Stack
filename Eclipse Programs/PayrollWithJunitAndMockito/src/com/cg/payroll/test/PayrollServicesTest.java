package com.cg.payroll.test;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.exception.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class PayrollServicesTest {
	private static PayrollServices services;
	private static PayrollDAOServices mockDAOServices;
	@BeforeClass
	public static void setUpBeforeClass(){
		mockDAOServices=Mockito.mock(PayrollDAOServices.class);
		services=new PayrollServicesImpl(mockDAOServices);
	}

	@AfterClass
	public static void tearDownAfterClass(){
		services=null;
		mockDAOServices=null;
	}

	@Before
	public void setUp(){
		Associate associate1=new Associate(1001,150000, "Vidya", "Basavoju", "training", "Jr Con", "UYT823ASE", "sbasavoj@abc.com", new Salary(20000, 1000, 1000), new BankDetails(12345, "SBI", "SBI123"));
		Associate associate2=new Associate(1002,10000, "Lekha", "Ganapa", "coaching", "Sr Con", "ASD123ASE", "lganapa@abc.com", new Salary(20000, 1000, 1000), new BankDetails(12345, "ICICI", "ICICI32"));
		Associate associate3=new Associate(1003,70000, "Sravan", "Boinapally", "java", "Assistent", "IYG43ASE", "sboina@abc.com", new Salary(15000, 1000, 1000), new BankDetails(12345, "HDFC", "HDFC908"));
		ArrayList<Associate> associateList=new ArrayList<>();
		associateList.add(associate1);
		associateList.add(associate2);
		associateList.add(associate3);
		Mockito.when(mockDAOServices.getAssociate(1001)).thenReturn(associate1);
		Mockito.when(mockDAOServices.getAssociate(1002)).thenReturn(associate2);
		Mockito.when(mockDAOServices.getAssociate(1003)).thenReturn(associate3);
		Mockito.when(mockDAOServices.getAssociate(1986)).thenReturn(null);
		Mockito.when(mockDAOServices.insertAssociate(associate3)).thenReturn(1003);
		Mockito.when(mockDAOServices.getAssociates()).thenReturn(associateList);
		//Mockito.when(mockDAOServices.)
	}

	@After
	public void tearDown(){
		Mockito.reset(mockDAOServices); 
	}
	@Test
	public void testToAcceptAssociateDetails() {
		Associate associate3=new Associate(1003,70000, "Sravan", "Boinapally", "java", "Assistent", "IYG43ASE", "sboina@abc.com", new Salary(15000, 1000, 1000), new BankDetails(12345, "HDFC", "HDFC908"));
		int associateId=services.acceptAssociateDetails(1000, "abc", "def", "ghi", "jkl", "mno", "pqr",1000, 200, 200, 12345, "stu", "vwxyz");
		Mockito.verify(mockDAOServices).insertAssociate(associate3);
		//Assert.assertEquals(1003, associateId);
	}
	@Test(expected=AssociateDetailsNotFoundException.class) 
	public void testAssociateForInvalidId()throws AssociateDetailsNotFoundException{
		services.getAssociateDetails(1986);
		Mockito.verify(mockDAOServices).getAssociate(1986);
	}
	@Test 
	public void testAssociateForValidId()throws AssociateDetailsNotFoundException{
		services.getAssociateDetails(1002);
		Mockito.verify(mockDAOServices).getAssociate(1002);
	}
	@Test
	public void testAssociateDetailsFound()throws AssociateDetailsNotFoundException{
		services.getAllAssociateDetails();
		Mockito.verify(mockDAOServices).getAssociates();
	}
	@Test
	public void testCalculateNetSalary() throws AssociateDetailsNotFoundException{

	}
	@Test
	public void testDeleteExistingAssociate() throws AssociateDetailsNotFoundException{

	}
	@Test(expected=AssociateDetailsNotFoundException.class) 
	public void testDeleteNotExistingAssociate() throws AssociateDetailsNotFoundException{

	}
}
