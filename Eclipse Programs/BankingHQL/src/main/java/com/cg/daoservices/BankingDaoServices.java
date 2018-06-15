package com.cg.daoservices;
import java.sql.SQLException;
import java.util.Map;

import com.cg.beans.Account;
import com.cg.beans.Customer;
import com.cg.beans.Transaction;
public interface BankingDaoServices {
	int insertCustomer(Customer customer) throws SQLException;
	long insertAccount(int customerId,Account account);
	boolean updateAccount(int customerId,Account account);
	int generatePin(int customerId,Account account);
	boolean insertTransaction(int customerId,long accountNo,Transaction transaction);
	boolean deleteCustomer(int customerId);
	boolean deleteAccount(int customerId,long accountNo);
	Customer getCustomer(int customerId);
	Account getAccount(int customerId,long accountNo);
	Map<Integer, Customer> getCustomers();
	Map<Long, Account> getAccounts(int customerId);
	Map<Long, Transaction> getTransactions(int customerId,long accountNo);
}
