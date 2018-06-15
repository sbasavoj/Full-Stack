package com.cg.banking.services;

import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Address;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.BankingDAOServices;
import com.cg.banking.daoservices.BankingDAOServicesImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.CustomerNotFoundException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
public class BankingServicesImpl implements BankingServices {
	private BankingDAOServices daoServices;
	public BankingServicesImpl(){
		daoServices=new BankingDAOServicesImpl();
	}
	@Override
	public int acceptCustomerDetails(String firstName, String lastName, String emailId, String panCard,
			String localAddressCity, String localAddressState, int localAddressPinCode, String homeAddressCity,
			String homeAddressState, int homeAddressPinCode) throws BankingServicesDownException {
		return daoServices.insertCustomer(new Customer(firstName, lastName, emailId, panCard, new Address(homeAddressPinCode, homeAddressCity, homeAddressState),new Address(localAddressPinCode, localAddressCity, localAddressState)));
	}
	@Override
	public long openAccount(int customerId, String accountType, float initBalance) throws InvalidAmountException,
	CustomerNotFoundException, InvalidAccountTypeException, BankingServicesDownException {	
		getCustomerDetails(customerId);
		if((accountType.equalsIgnoreCase("savings")||accountType.equalsIgnoreCase("current")||accountType.equalsIgnoreCase("salary"))==false)
			throw new InvalidAccountTypeException("Wrong Account Type");
		else if(initBalance<0)
			throw new InvalidAmountException("Please input correct amount");
		else
			return daoServices.insertAccount(customerId, new Account(accountType, initBalance));
	}
	@Override
	public float depositAmount(int customerId, long accountNo, float amount) throws CustomerNotFoundException,
	AccountNotFoundException, BankingServicesDownException, AccountBlockedException, InvalidAmountException {
		Account account=getAccountDetails(customerId, accountNo);
		if((account.getStatus().equalsIgnoreCase("inactive")))
			throw new AccountBlockedException("Account Blocked!!!"+"\n"+"If you are New User,Generate Pin "+"\n"+"else Visit nearby Branch");
		else if(amount<0)
			throw new InvalidAmountException("Please input correct amount");
		else 
		{
			account.setAccountBalance(account.getAccountBalance()+amount);
			daoServices.insertTransaction(customerId, accountNo, new Transaction(amount, "Deposit"));
			return account.getAccountBalance();
		}
	}
	@Override
	public float withdrawAmount(int customerId, long accountNo, float amount, int pinNumber)
			throws InsufficientAmountException, CustomerNotFoundException, AccountNotFoundException,
			InvalidPinNumberException, BankingServicesDownException, AccountBlockedException, InvalidAmountException {
		Account account=getAccountDetails(customerId, accountNo);
		if(account.getStatus().equalsIgnoreCase("inactive"))
			throw new AccountBlockedException("Account Blocked!");
		else if (pinNumber!=account.getPinNumber()){
			int pinCounter=account.getPinCounter();
			if(pinCounter<2){
				account.setPinCounter(pinCounter+1);
				throw new InvalidPinNumberException("Wrong pin entered!!!");			
			}
			else{
				account.setStatus("Inactive");
				throw new AccountBlockedException("Account Blocked!!!Please Visit nearby Bank");
			}
		}
		else if(amount<0)
			throw new InvalidAmountException("Please input correct amount");
		else if(amount>account.getAccountBalance())
			throw new InsufficientAmountException("YOu don't have Sufficient Banlance!!!");
		else 
		{
			account.setPinCounter(0);
			account.setAccountBalance(account.getAccountBalance()-amount);
			daoServices.insertTransaction(customerId, accountNo, new Transaction(amount, "Withdrawal"));
			return account.getAccountBalance();
		}
	}
	@Override
	public boolean fundTransfer(int customerIdTo, long accountNoTo, int customerIdFrom, long accountNoFrom,
			float transferAmount, int pinNumber) throws InsufficientAmountException, CustomerNotFoundException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException, InvalidAmountException {
		Account accountTo=getAccountDetails(customerIdTo, accountNoTo);
		Account accountFrom=getAccountDetails(customerIdFrom, accountNoFrom);
		if(accountFrom.getStatus().equalsIgnoreCase("active")==false||accountTo.getStatus().equalsIgnoreCase("active")==false)
			throw new AccountBlockedException("Account Blocked!");
		else if (pinNumber!=accountFrom.getPinNumber()){
			int pinCounter=accountFrom.getPinCounter();
			if(pinCounter<2){
				accountFrom.setPinCounter(pinCounter+1);
				throw new InvalidPinNumberException("Wrong pin entered!!!");			
			}
			else{
				accountFrom.setStatus("Inactive");
				throw new AccountBlockedException("Account Blocked!!!");
			}
		}
		else if(transferAmount<0)
			throw new InvalidAmountException("Please input correct amount");
		else if(transferAmount>accountFrom.getAccountBalance())
			throw new InsufficientAmountException("YOu don't have Sufficient Banlance!!!");
		else 
		{
			accountFrom.setPinCounter(0);
			accountTo.setAccountBalance(accountTo.getAccountBalance()+transferAmount);
			daoServices.insertTransaction(customerIdTo, accountNoTo, new Transaction(transferAmount, "Transfer"));
			accountFrom.setAccountBalance(accountFrom.getAccountBalance()-transferAmount);
			daoServices.insertTransaction(customerIdFrom, accountNoFrom, new Transaction(transferAmount, "Transfer"));
			return true;
		}
	}
	@Override
	public Customer getCustomerDetails(int customerId) throws CustomerNotFoundException, BankingServicesDownException {
		Customer customer=daoServices.getCustomer(customerId);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		return customer;
	}
	@Override
	public Account getAccountDetails(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		getCustomerDetails(customerId);
		Account account=daoServices.getAccount(customerId, accountNo);
		if(account==null)
			throw new AccountNotFoundException("Wrong Account Number Entered");
		else
			return account;	
	}
	@Override
	public int generateNewPin(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		Account account=getAccountDetails(customerId, accountNo);
			if(account.getPinNumber()==0){
				account.setStatus("Active");
				return daoServices.generatePin(customerId, account);	
			}
			else return 0;
	}
	@Override
	public boolean changeAccountPin(int customerId, long accountNo, int oldPinNumber, int newPinNumber)
			throws CustomerNotFoundException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException {
		Account account=getAccountDetails(customerId, accountNo);
		if(oldPinNumber!=account.getPinNumber())
			throw new InvalidPinNumberException("Wrong pin Entered");
		else
			account.setPinNumber(newPinNumber);
			return true;
	}
	@Override
	public List<Customer> getAllCustomerDetails() throws BankingServicesDownException {
		return daoServices.getCustomers();
	}
	@Override
	public List<Account> getcustomerAllAccountDetails(int customerId)
			throws BankingServicesDownException, CustomerNotFoundException {
		getCustomerDetails(customerId);
		List<Account> accounts=daoServices.getAccounts(customerId);
		return accounts;
	}
	@Override
	public List<Transaction> getAccountAllTransaction(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		getAccountDetails(customerId, accountNo);
			return daoServices.getTransactions(customerId, accountNo);
	}
	@Override
	public String accountStatus(int customerId, long accountNo) throws BankingServicesDownException,
	CustomerNotFoundException, AccountNotFoundException, AccountBlockedException {
		Account account=getAccountDetails(customerId, accountNo);
		if(account.getStatus().equalsIgnoreCase("active")==false) 
			throw new AccountBlockedException("Your Account is Blocked");
		else
			return account.getStatus();
	}
	@Override
	public boolean closeAccount(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		Account account=getAccountDetails(customerId, accountNo);
		if(account.getAccountBalance()==0){
			daoServices.deleteAccount(customerId, accountNo);
			return true;
		}
		else return false;		
	}
}