package com.cg.payroll.test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServicesImpl;
import com.cg.payroll.exception.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class PayrollServicesTest {
	private static PayrollServices services;
	@BeforeClass
	public static void setUpBeforeClass(){
		services=new PayrollServicesImpl();
	}
	@AfterClass
	public static void tearDownAfterClass(){
		services=null;
	}
	@Before
	public void setUp(){
		Associate associate1=new Associate(PayrollDAOServicesImpl.ASSOCIATE_ID_INDEX++,150000, "Vidya", "Basavoju", "training", "Jr Con", "UYT823ASE", "sbasavoj@abc.com", new Salary(20000, 1000, 1000), new BankDetails(12345, "SBI", "SBI123"));
		Associate associate2=new Associate(PayrollDAOServicesImpl.ASSOCIATE_ID_INDEX++,10000, "Lekha", "Ganapa", "coaching", "Sr Con", "ASD123ASE", "lganapa@abc.com", new Salary(20000, 1000, 1000), new BankDetails(12345, "ICICI", "ICICI32"));
		Associate associate3=new Associate(PayrollDAOServicesImpl.ASSOCIATE_ID_INDEX++,70000, "Sravan", "Boinapally", "java", "Assistent", "IYG43ASE", "sboina@abc.com", new Salary(15000, 1000, 1000), new BankDetails(12345, "HDFC", "HDFC908"));
		PayrollDAOServicesImpl.associateMap.put(associate1.getAssociateId(), associate1);
		PayrollDAOServicesImpl.associateMap.put(associate2.getAssociateId(), associate2);
		PayrollDAOServicesImpl.associateMap.put(associate3.getAssociateId(), associate3);
	}

	@After
	public void tearDown() throws Exception {
		PayrollDAOServicesImpl.associateMap.clear();
		PayrollDAOServicesImpl.ASSOCIATE_ID_INDEX=111;
	}
	@Test
	public void testToAcceptAssociateDetails() {
		int actualAssociateId = services.acceptAssociateDetails(3000, "Lowkya", "Kandari", "Main Frames", "Trainee", "LKS123JK", "lkandar@abc.com", 5000, 1000, 1000, 9087654, "SBI", "SBI987");
		assertEquals(114, actualAssociateId);
	}
	@Test(expected=AssociateDetailsNotFoundException.class) 
	public void testAssociateNotFound()throws AssociateDetailsNotFoundException{
		services.getAssociateDetails(122);
	}
	@Test 
	public void testAssociateFound()throws AssociateDetailsNotFoundException{
		services.getAssociateDetails(112);
	}
	@Test
	public void testAssociateDetailsFound()throws AssociateDetailsNotFoundException{
		Associate expectedAssociate= new Associate(113,70000, "Sravan", "Boinapally", "java", "Assistent", "IYG43ASE", "sboina@abc.com", new Salary(15000, 1000, 1000), new BankDetails(12345, "HDFC", "HDFC908"));
		assertEquals(expectedAssociate, services.getAssociateDetails(113));
	}
	@Test
	public void testCalculateNetSalary() throws AssociateDetailsNotFoundException{
		double actualNetSalary=services.calculateNetSAlary(111);
		assertEquals(35533.3333d, actualNetSalary,1);
	}
	@Test
	public void testDeleteExistingAssociate() throws AssociateDetailsNotFoundException{
		assertTrue(services.deleteAssociateDetails(112));
	}
	@Test(expected=AssociateDetailsNotFoundException.class) 
	public void testDeleteNotExistingAssociate() throws AssociateDetailsNotFoundException{
		services.deleteAssociateDetails(312);
	}
}
