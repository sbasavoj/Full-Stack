package com.cg.banking.daoservices;
import java.sql.SQLException;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;
public interface BankingDAOServices {
	int insertCustomer(Customer customer) throws SQLException;
	long insertAccount(int customerId,Account account);
	boolean updateAccount(int customerId,Account account);
	int generatePin(int customerId,Account account);
	boolean insertTransaction(int customerId,long accountNo,Transaction transaction);
	boolean deleteCustomer(int customerId);
	boolean deleteAccount(int customerId,long accountNo);
	Customer getCustomer(int customerId);
	Account getAccount(int customerId,long accountNo);
	Customer[] getCustomers();
	Account[] getAccounts(int customerId);
	Transaction[] getTransactions(int customerId,long accountNo);
}