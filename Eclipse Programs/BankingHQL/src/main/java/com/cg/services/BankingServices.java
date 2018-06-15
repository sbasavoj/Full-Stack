package com.cg.services;
import java.util.Map;

import javax.security.auth.login.AccountNotFoundException;

import com.cg.beans.Account;
import com.cg.beans.Customer;
import com.cg.beans.Transaction;
import com.cg.exception.AccountBlockedException;
import com.cg.exception.BankingServicesDownException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.InsufficientAmountException;
import com.cg.exception.InvalidAccountTypeException;
import com.cg.exception.InvalidAmountException;
import com.cg.exception.InvalidPinNumberException;

public interface BankingServices {
	int acceptCustomerDetails(String firstName,String lastName,String customerEmailId,String panCard,String localAddressCity,
			String localAddressState,int localAddressPinCode,String homeAddressCity,
			String homeAddressState,int homeAddressPinCode)throws BankingServicesDownException;

	long openAccount(int customerId,String accountType,float initBalance)
			throws InvalidAmountException,
			CustomerNotFoundException,
			InvalidAccountTypeException,
			BankingServicesDownException;
	

	float depositAmount(int customerId,long accountNo,float amount)
			throws CustomerNotFoundException,
			AccountNotFoundException,BankingServicesDownException, AccountBlockedException;

	float withdrawAmount(int customerId,long accountNo,float amount,int pinNumber)
			throws InsufficientAmountException,CustomerNotFoundException,
			AccountNotFoundException,InvalidPinNumberException,
			BankingServicesDownException ,AccountBlockedException;
	
	boolean fundTransfer(int customerIdTo,long accountNoTo,int customerIdFrom,long accountNoFrom,float transferAmount,int pinNumber)
			throws InsufficientAmountException,
			CustomerNotFoundException,
			AccountNotFoundException,InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException  ;
	
	Customer getCustomerDetails(int customerId)
			throws CustomerNotFoundException,BankingServicesDownException;
	
	Account getAccountDetails(int customerId,long accountNo)
			throws 
			CustomerNotFoundException,AccountNotFoundException,BankingServicesDownException;

	public int generateNewPin(int customerId,long accountNo)
			throws
			CustomerNotFoundException,AccountNotFoundException ,
			BankingServicesDownException;

	public boolean changeAccountPin(int customerId,long accountNo,int oldPinNumber,int newPinNumber)
			throws CustomerNotFoundException,
			AccountNotFoundException,
			InvalidPinNumberException,BankingServicesDownException  ;
	
	Map<Integer, Customer> getAllCustomerDetails()throws BankingServicesDownException;

	Map<Long, Account> getcustomerAllAccountDetails(int customerId)
			throws BankingServicesDownException,CustomerNotFoundException;
	
	Map<Long, Transaction> getAccountAllTransaction(int customerId,long accountNo)
			throws BankingServicesDownException,
			CustomerNotFoundException,
			AccountNotFoundException;
	
	public String accountStatus(int customerId,long accountNo)
			throws BankingServicesDownException,
			CustomerNotFoundException,
			AccountNotFoundException, AccountBlockedException;

	boolean closeAccount(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException;
}
