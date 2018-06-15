package com.cg.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.beans.Account;
import com.cg.beans.Address;
import com.cg.beans.Customer;
import com.cg.beans.Transaction;
import com.cg.daoservices.BankingDaoServices;
import com.cg.exception.AccountBlockedException;
import com.cg.exception.BankingServicesDownException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.InsufficientAmountException;
import com.cg.exception.InvalidAccountTypeException;
import com.cg.exception.InvalidAmountException;
import com.cg.exception.InvalidPinNumberException;
@Component("services")
@Transactional
public class BankingServicesImpl implements BankingServices{
	@Autowired
	private BankingDaoServices daoServices;
	@Override
	public int acceptCustomerDetails(String firstName, String lastName, String emailId, String panCard,
			String localAddressCity, String localAddressState, int localAddressPinCode, String homeAddressCity,
			String homeAddressState, int homeAddressPinCode) throws BankingServicesDownException {
		try {
			List<Address> addresses=new ArrayList<>();
			addresses.add(new Address(homeAddressPinCode, homeAddressCity, homeAddressState));
			addresses.add(new Address(localAddressPinCode, localAddressCity, localAddressState));
			return daoServices.insertCustomer(new Customer(firstName, lastName, emailId, panCard, addresses));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankingServicesDownException();
		}
	}
	@Override
	public long openAccount(int customerId, String accountType, float initBalance) throws InvalidAmountException,
	CustomerNotFoundException, InvalidAccountTypeException, BankingServicesDownException {
		Customer customer=daoServices.getCustomer(customerId);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if((accountType.equalsIgnoreCase("savings")||accountType.equalsIgnoreCase("current")||accountType.equalsIgnoreCase("salary"))==false)
			throw new InvalidAccountTypeException("Wrong Account Type");
		else if(initBalance<1)
			throw new InvalidAmountException("Please input correct amount");
		else
			return daoServices.insertAccount(customerId, new Account(accountType, initBalance));
	}

	@Override
	public float depositAmount(int customerId, long accountNo, float amount) throws CustomerNotFoundException,
	AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account=daoServices.getAccount(customerId, accountNo);
		Customer customer=daoServices.getCustomer(customerId);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if (account==null)
			throw new AccountNotFoundException("Account of "+accountNo+" not found");
		else if((account.getStatus().equalsIgnoreCase("active"))==false)
			throw new AccountBlockedException("Account Blocked!!!");
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
			InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account account=daoServices.getAccount(customerId, accountNo);
		Customer customer=daoServices.getCustomer(customerId);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if (account==null)
			throw new AccountNotFoundException("Account of "+accountNo+" not found");
		else if(account.getStatus().equalsIgnoreCase("active")==false)
			throw new AccountBlockedException("Account Blocked!");
		else if (pinNumber!=account.getPinNumber()){
			int pinCounter=account.getPinCounter();
			if(pinCounter<3){
				account.setPinCounter(pinCounter+1);
				throw new InvalidPinNumberException("Wrong pin entered!!!");			
			}
			else{
				account.setStatus("Inactive");
				throw new AccountBlockedException("Account Blocked!!!");
			}
		}
		else if(amount>account.getAccountBalance())
			throw new InsufficientAmountException("YOu don't have Sufficient Banlance!!!");
		else 
		{
			account.setAccountBalance(account.getAccountBalance()-amount);
			daoServices.insertTransaction(customerId, accountNo, new Transaction(amount, "Withdrawal"));
			return account.getAccountBalance();
		}
	}

	@Override
	public boolean fundTransfer(int customerIdTo, long accountNoTo, int customerIdFrom, long accountNoFrom,
			float transferAmount, int pinNumber) throws InsufficientAmountException, CustomerNotFoundException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account accountTo=daoServices.getAccount(customerIdTo, accountNoTo);
		if (accountTo==null)
			throw new AccountNotFoundException("Account of "+accountNoTo+" not found");
		Account accountFrom=daoServices.getAccount(customerIdFrom, accountNoFrom);
		if (accountFrom==null)
			throw new AccountNotFoundException("Account of "+accountNoFrom+" not found");
		else if(accountFrom.getStatus().equalsIgnoreCase("active")==false)
			throw new AccountBlockedException("Account Blocked!");
		else if (pinNumber!=accountFrom.getPinNumber()){
			int pinCounter=accountFrom.getPinCounter();
			if(pinCounter<3){
				accountFrom.setPinCounter(pinCounter+1);
				throw new InvalidPinNumberException("Wrong pin entered!!!");			
			}
			else{
				accountFrom.setStatus("Inactive");
				throw new AccountBlockedException("Account Blocked!!!");
			}
		}
		else if(transferAmount>accountFrom.getAccountBalance())
			throw new InsufficientAmountException("YOu don't have Sufficient Banlance!!!");
		else 
		{
			accountTo.setAccountBalance(accountTo.getAccountBalance()+transferAmount);
			daoServices.insertTransaction(customerIdTo, accountNoTo, new Transaction(transferAmount, "Transfer"));
			accountFrom.setAccountBalance(accountFrom.getAccountBalance()+transferAmount);
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
		Customer customer=daoServices.getCustomer(customerId);
		Account account=daoServices.getAccount(customerId, accountNo);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if(account==null)
			throw new AccountNotFoundException("Wrong Account Number Entered");
		else
			return account;	
	}

	@Override
	public int generateNewPin(int customerId, long accountNo)
			throws CustomerNotFoundException, AccountNotFoundException, BankingServicesDownException {
		Customer customer=daoServices.getCustomer(customerId);
		Account account=daoServices.getAccount(customerId, accountNo);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if(account==null)
			throw new AccountNotFoundException("Wrong Account Number Entered");
		else
		{
			if(account.getPinNumber()==0){
				account.setStatus("Active");
				return daoServices.generatePin(customerId, account);	
			}						
			else return 0;
		}
	}

	@Override
	public boolean changeAccountPin(int customerId, long accountNo, int oldPinNumber, int newPinNumber)
			throws CustomerNotFoundException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException {
		Customer customer=daoServices.getCustomer(customerId);
		Account account=daoServices.getAccount(customerId, accountNo);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if(account==null)
			throw new AccountNotFoundException("Wrong Account Number Entered");
		else if(oldPinNumber!=account.getPinNumber())
			throw new InvalidPinNumberException("Wrong pin Entered");
		else
		{
			account.setPinNumber(newPinNumber);
			return true;
		}
	}

	@Override
	public Map<Integer, Customer> getAllCustomerDetails() throws BankingServicesDownException {
		return daoServices.getCustomers();
	}

	@Override
	public Map<Long, Account> getcustomerAllAccountDetails(int customerId)
			throws BankingServicesDownException, CustomerNotFoundException {
		Map<Long, Account> accounts=daoServices.getAccounts(customerId);
		if(accounts==null)
			throw new CustomerNotFoundException("Wrong Customer Id Entered");
		return accounts;
	}

	@Override
	public Map<Long, Transaction> getAccountAllTransaction(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		Customer customer=daoServices.getCustomer(customerId);
		Account account=daoServices.getAccount(customerId, accountNo);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if(account==null)
			throw new AccountNotFoundException("Wrong Account Number Entered");
		else
			return daoServices.getTransactions(customerId, accountNo);
	}

	@Override
	public String accountStatus(int customerId, long accountNo) throws BankingServicesDownException,
	CustomerNotFoundException, AccountNotFoundException, AccountBlockedException {
		Customer customer=daoServices.getCustomer(customerId);
		Account account=daoServices.getAccount(customerId, accountNo);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if(account==null)
			throw new AccountNotFoundException("Wrong Account Number Entered");
		else if(account.getStatus().equalsIgnoreCase("active")==false) 
			throw new AccountBlockedException("Your Account is Blocked");
		else
			return account.getStatus();
	}
	@Override
	public boolean closeAccount(int customerId, long accountNo)
			throws BankingServicesDownException, CustomerNotFoundException, AccountNotFoundException {
		Customer customer=daoServices.getCustomer(customerId);
		Account account=daoServices.getAccount(customerId, accountNo);
		if(customer==null)
			throw new CustomerNotFoundException("No such Customer Exists");
		else if(account==null)
			throw new AccountNotFoundException("Wrong Account Number Entered");
		else
			return daoServices.deleteAccount(customerId, accountNo);
	}
}
