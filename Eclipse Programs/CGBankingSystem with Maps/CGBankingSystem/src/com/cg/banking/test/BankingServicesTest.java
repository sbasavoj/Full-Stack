package com.cg.banking.test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Address;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.BankingDAOServicesImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.CustomerNotFoundException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
public class BankingServicesTest {
	private static BankingServices services;
	@BeforeClass
	public static void setUpBeforeClass(){
		services=new BankingServicesImpl();
	}
	@AfterClass
	public static void tearDownAfterClass(){
		services=null;
	}
	@Before
	public void setUp(){
		//Transaction transaction1=new Transaction(11, 1000, "Deposit");
		Customer customer1=new Customer("vidya", "Basavoju", "sbasavoj@gmail.com", "ASD123HJ", new Address(12344, "TG", "Hyd"), new Address(12345, "Telangana", "Khammam"));
		BankingDAOServicesImpl.customerMap.put(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR, customer1);
		BankingDAOServicesImpl.customerMap.get(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR).getAccounts().put(BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR, new Account(0, 0, "savings", "inactive", 1000, BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR, 1001));
		BankingDAOServicesImpl.customerMap.get(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR++).getAccounts().get(BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR++).getTransactions().put(100011001l, new Transaction(1000, "Deposit"));
		
		Customer customer2=new Customer("Lowkya", "Kandari", "skandar@gmail.com", "ASD123HJ", new Address(12344, "TG", "Hyd"), new Address(12345, "Telangana", "Khammam"));
		BankingDAOServicesImpl.customerMap.put(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR, customer2);
		BankingDAOServicesImpl.customerMap.get(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR).getAccounts().put(BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR, new Account("current", 1000));
		BankingDAOServicesImpl.customerMap.get(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR++).getAccounts().get(BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR++).getTransactions().put(100021001l, new Transaction(500, "Deposit"));
	 
		Customer customer3=new Customer("Sravan", "Boinapally", "skandar@gmail.com", "ASD123HJ", new Address(12344, "TG", "Hyd"), new Address(12345, "Telangana", "Khammam"));
		BankingDAOServicesImpl.customerMap.put(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR, customer3);
		BankingDAOServicesImpl.customerMap.get(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR).getAccounts().put(BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR, new Account(1234, 0, "current", "active", 1000, BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR, 1001));
		BankingDAOServicesImpl.customerMap.get(BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR++).getAccounts().get(BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR++).getTransactions().put(100031001l, new Transaction(500, "Deposit"));
	}
	
	

	@After
	public void tearDown() {
		BankingDAOServicesImpl.customerMap.clear();
		BankingDAOServicesImpl.CUSTOMER_ID_GENERATOR=111;
		BankingDAOServicesImpl.ACCOUNT_ID_GENERATOR=10001;	
	}
	@Test
	public void testToacceptCustomerDetails() throws BankingServicesDownException {
		int actualCustomerId=services.acceptCustomerDetails("vidya", "Basavoju", "sbasavoj@gmail.com", "ASD123HJ", "Hyd", "TG", 12344, "Khammam", "Telangana", 12345);
	assertEquals(114, actualCustomerId);
	}
	@Test
	public void testToOpenAccount() throws InvalidAmountException, CustomerNotFoundException, InvalidAccountTypeException, BankingServicesDownException{
		//long accountNo=services.openAccount(111, "savings", 1000);
		assertEquals(10004, services.openAccount(111, "savings", 1000));
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testToOpenAccountWithoutCustomer() throws InvalidAmountException, CustomerNotFoundException, InvalidAccountTypeException, BankingServicesDownException{
		services.openAccount(119, "savings", 1000);
	}
	@Test(expected=InvalidAmountException.class)
	public void testToOpenAccountWithInvalidAmount() throws InvalidAmountException, CustomerNotFoundException, InvalidAccountTypeException, BankingServicesDownException{
		services.openAccount(112, "savings", -1000);
	}
	@Test(expected=InvalidAccountTypeException.class)
	public void testToOpenAccountWithInvalidAccountType() throws InvalidAmountException, CustomerNotFoundException, InvalidAccountTypeException, BankingServicesDownException{
		services.openAccount(112, "abc", 1000);
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testToDepositWithoutCustomer() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException, InvalidAmountException{
		services.depositAmount(117, 11001, 500);
	}
	@Test(expected=AccountNotFoundException.class)
	public void testToDepositWithoutAccount() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException, InvalidAmountException{
		services.depositAmount(112, 11001, 500);
	}
	@Test(expected=AccountBlockedException.class)
	public void testToDepositInactiveAccount() throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException, AccountBlockedException, InvalidAmountException{
		services.depositAmount(111, 10001, 500);
	}
	
}
