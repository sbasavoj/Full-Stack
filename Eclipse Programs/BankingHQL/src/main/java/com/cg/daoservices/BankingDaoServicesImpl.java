package com.cg.daoservices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.beans.Account;
import com.cg.beans.Customer;
import com.cg.beans.Transaction;
@Component("daoServices")
public class BankingDaoServicesImpl implements BankingDaoServices{
	@Autowired SessionFactory sessionFactory;
	org.hibernate.Transaction tx;
	Session session;
	@Override
	public int insertCustomer(Customer customer)  {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			int customerId = (int) session.save(customer);
			tx.commit();
			return customerId;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		finally{
			session.close();
		}
	}
	@Override
	public long insertAccount(int customerId, Account account) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			account.setStatus("Inactive");
			Customer customer=(Customer) session.get(Customer.class, customerId);
			account.setCustomer(customer);
			long accountNo=(long)session.save(account);
			tx.commit();
			return accountNo;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		finally{
			session.close();
		}
	}
	@Override
	public Customer getCustomer(int customerId) {
		Customer customer=null;
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			/*Query query = session.createQuery("from Customer where customerId= :customerId");
			query.setInteger("customerId", customerId);
			customer = (Customer) query.uniqueResult();*/
			customer=(Customer) session.get(Customer.class, customerId);
			tx.commit();
			return customer;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		/*finally{
			session.close();
		}*/
	}
	@Override
	public Account getAccount(int customerId, long accountNo) {
		Account account=null;
		try {
			session=sessionFactory.openSession();
			account=(Account) session.get(Account.class, accountNo);
			if(account.getCustomer().getCustomerId()==customerId)
			return account;
			else return null;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		/*finally{
			session.close();
		}*/
	}
	@Override
	public Map<Integer, Customer> getCustomers() {
		session=sessionFactory.openSession();
		List<Customer> customers=session.createQuery("FROM Customer").list();
		Map<Integer, Customer> map = new HashMap<>();
		for (Customer i : customers) map.put(i.getCustomerId(),i);
		session.close();
		return   map;
	}
	@Override
	public Map<Long, Account> getAccounts(int customerId) {
		session=sessionFactory.openSession();
		Customer customer=getCustomer(customerId);
		/*session.close();*/
		return customer.getAccounts();
	}
	@Override
	public Map<Long, Transaction> getTransactions(int customerId, long accountNo) {
		Map<Long, Transaction> transactions=null;
		session=sessionFactory.openSession();
		Customer customer=getCustomer(customerId);
		for (Account i : customer.getAccounts().values())
			if(i.getAccountNo()==accountNo)
				transactions= i.getTranscations();
		/*session.close();*/
		return transactions;
	}
	@Override
	public boolean insertTransaction(int customerId, long accountNo, com.cg.beans.Transaction transaction) {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		Account account=getAccount(customerId, accountNo);
		if(account==null){
			session.close();
			return false;
		}
		else
		{
			Transaction transaction2=transaction;
			transaction2.setAccount(account);
			session.save(transaction2);
			tx.commit();
			session.close();
			return true;
		}
	}
	@Override
	public boolean updateAccount(int customerId, Account account) {
		Session session=sessionFactory.openSession();
		tx=session.beginTransaction();
		if(!(customerId==account.getCustomer().getCustomerId())){
			session.close();
			return false;
		}
		else
			session.update(account);
		session.flush();
		tx.commit();
		session.close();
		return false;
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
	public boolean deleteCustomer(int customerId) {
		Session session=sessionFactory.openSession();
		tx=session.beginTransaction();
		if(getCustomer(customerId)==null)
			return false;
		else{
			session.delete(getCustomer(customerId));
			session.flush();
			tx.commit();
			session.close();
			return true;
		}
	}
	@Override
	public boolean deleteAccount(int customerId, long accountNo) {
		Session session=sessionFactory.openSession();
		tx=session.beginTransaction();
		if(getAccount(customerId, accountNo)==null)
			return false;
		else{
			session.delete(getAccount(customerId, accountNo));
			session.flush();
			tx.commit();
			session.close();
			return true;
		}
	}
}
