package com.cg.banking.daoservices;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;

public class BankingDAOServicesImpl implements BankingDAOServices{
	public static HashMap<Integer,Customer> customerMap=new HashMap<>();
	public static int CUSTOMER_ID_GENERATOR=111;	
	public static long ACCOUNT_ID_GENERATOR=10001l;
	@Override
	public int insertCustomer(Customer customer) {
		customer.setCustomerId(CUSTOMER_ID_GENERATOR++);
		customerMap.put(customer.getCustomerId(), customer);
		return customer.getCustomerId();
	}
	@Override
	public long insertAccount(int customerId, Account account) {
		account.setAccountNo(ACCOUNT_ID_GENERATOR++);
		account.setStatus("Inactive");
		customerMap.get(customerId).getAccounts().put(account.getAccountNo(),account);
		return account.getAccountNo();
	}
	@Override
	public boolean updateAccount(int customerId, Account account) {
		if(customerMap.get(customerId).getAccounts().containsValue(account))
			customerMap.get(customerId).getAccounts().put(account.getAccountNo(),account);
		return customerMap.get(customerId).getAccounts().containsValue(account);
	}
	@Override
	public int generatePin(int customerId, Account account) {
		if(customerMap.get(customerId).getAccounts().containsValue(account)){
			account.setPinNumber(new Random().nextInt(9999) + 1001);
			account.setStatus("active");
			updateAccount(customerId, account);
			return account.getPinNumber();
		}
		return -1;
	}
	@Override
	public boolean insertTransaction(int customerId, long accountNo, Transaction transaction) {
		String concat;
		if(customerMap.get(customerId).getAccounts().containsKey(accountNo)){
			concat=Long.toString(accountNo)+Integer.toString(customerMap.get(customerId).getAccounts().get(accountNo).getTransactionIdGenerator());
			transaction.setTransactionId(Long.parseLong(concat));
			customerMap.get(customerId).getAccounts().get(accountNo).getTransactions().put(transaction.getTransactionId(), transaction);
			customerMap.get(customerId).getAccounts().get(accountNo).setTransactionIdGenerator(customerMap.get(customerId).getAccounts().get(accountNo).getTransactionIdGenerator()+1);
		}
		return customerMap.get(customerId).getAccounts().containsKey(accountNo);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		boolean customerExists=customerMap.containsKey(customerId);
		customerMap.remove(customerId);
		return customerExists;
	}

	@Override
	public boolean deleteAccount(int customerId, long accountNo) {
		boolean accountExists;
		if(getAccount(customerId, accountNo)==null)
			accountExists=false;
		else
			accountExists=true;
		customerMap.get(customerId).getAccounts().remove(accountNo);
		return accountExists;
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerMap.get(customerId);
	}

	@Override
	public Account getAccount(int customerId, long accountNo) {
		return customerMap.get(customerId).getAccounts().get(accountNo);
	}

	@Override
	public List<Customer> getCustomers() {
		return new ArrayList<Customer>(customerMap.values());
	}

	@Override
	public List<Account> getAccounts(int customerId) {
		return new ArrayList<Account>(customerMap.get(customerId).getAccounts().values());
	}

	@Override
	public ArrayList<Transaction> getTransactions(int customerId, long accountNo) {
		return new ArrayList<Transaction>(getAccount(customerId, accountNo).getTransactions().values());
	}
}
