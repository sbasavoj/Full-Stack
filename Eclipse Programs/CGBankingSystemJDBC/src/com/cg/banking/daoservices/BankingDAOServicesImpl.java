package com.cg.banking.daoservices;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.SQLException;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;
import com.cg.banking.rowmappers.AccountRowMapper;
import com.mysql.jdbc.Connection;
@Component("daoServices")
public class BankingDAOServicesImpl implements BankingDAOServices{
	Connection con;	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int insertCustomer(Customer customer) throws SQLException {
//		con=(Connection) jdbcTemplate.getDataSource().getConnection();
		String sql1="insert into customer(firstName,lastName,emailId,panCard)value(?,?,?,?) ";
		jdbcTemplate.update(sql1,customer.getFirstName(),customer.getLastName(),customer.getEmailId(),customer.getPanCard());
		String query="select max(customerId) from customer";
		int customerId = jdbcTemplate.queryForObject(query,Integer.class);
		
		String sql2="insert into address(pincode,city,state) value(?,?,?)";
		jdbcTemplate.update(sql2,customer.getHomeAddress().getPincode(),customer.getHomeAddress().getCity(),customer.getHomeAddress().getState());
	
		String sql3="insert into address(pincode,city,state) value(?,?,?)";
		jdbcTemplate.update(sql3,customer.getLocalAddress().getPincode(),customer.getLocalAddress().getCity(),customer.getLocalAddress().getState());
		
		return customerId;
	}
	@Override
	public long insertAccount(int customerId, Account account){
		String sql1="insert into account(customerId,accountType,accountBalance) value(?,?) ";
		jdbcTemplate.update(sql1,customerId,account.getAccountType(),account.getAccountBalance());
		String query="select max(accountNo) from account";
		return jdbcTemplate.queryForObject(query,Long.class);
	}
	@Override
	public boolean updateAccount(int customerId, Account account) {
		String sql1="update account SET( accountType=?,accountBalance=? WHERE customerId =?";
		jdbcTemplate.update(sql1,account.getAccountType(),account.getAccountBalance(),customerId);
		
		return true;
	}
	@Override
	public int generatePin(int customerId, Account account) {
		Random n = new Random();
		int  pin = n.nextInt(9999) + 1001;
		account.setPinNumber(pin);
		updateAccount(customerId, account);
		return account.getPinNumber();
	}
	@Override
	public boolean insertTransaction(int customerId, long accountNo, Transaction transaction) {
		Account account=getAccount(customerId,accountNo);
		if (account!=null){
			String sql1="insert into transaction(accountNo,amount,transactionType) values(?,?,?)";
			jdbcTemplate.update(sql1,accountNo,transaction.getAmount(),transaction.getTransactionType());
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteCustomer(int customerId) {
		
		return false;
	}
	@Override
	public boolean deleteAccount(int customerId, long accountNo) {
		Account account=getAccount(customerId, accountNo);
		if(account!=null){
			account=null;
			return true;
		}
		return false;
	}
	@Override
	public Customer getCustomer(int customerId) {
		
		return null;
	}
	@Override
	public Account getAccount(int customerId, long accountNo) {
		String sql = "select * from account where accountNo = ?";
		Account account = (Account)jdbcTemplate.queryForObject(sql, new Object[]{ accountNo }, new AccountRowMapper());	
		if(account==null)
			return null;
		else
			return account;
	}
	@Override
	public Customer[] getCustomers() {
		return null;
	}
	@Override
	public Account[] getAccounts(int customerId) {
		return getCustomer(customerId).getAccounts();
	}
	@Override
	public Transaction[] getTransactions(int customerId, long accountNo) {
		return getAccount(customerId, accountNo).getTransactions();
	}
}
