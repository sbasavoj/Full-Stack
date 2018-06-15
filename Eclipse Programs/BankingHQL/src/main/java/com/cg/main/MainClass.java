package com.cg.main;
import javax.security.auth.login.AccountNotFoundException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.exception.BankingServicesDownException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.InvalidAccountTypeException;
import com.cg.exception.InvalidAmountException;
import com.cg.services.BankingServices;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
		BankingServices bankingServices=(BankingServices) applicationContext.getBean("services");
		try {
			int customerId=bankingServices.acceptCustomerDetails("ASD", "ZXC", "abc.gmail.com", "DGFH213", "Hyd", "TG", 12345, "Viz", "AP", 54321);
			System.out.println("Created Customer Id: "+customerId);
			System.out.println("Created account no: "+bankingServices.openAccount(customerId, "Savings", 500));
			System.out.println("Created account no: "+bankingServices.openAccount(customerId, "current", 500));
			System.out.println(bankingServices.getcustomerAllAccountDetails(customerId));
			System.out.println("customer: "+bankingServices.getCustomerDetails(customerId));
		} catch (BankingServicesDownException | InvalidAmountException | CustomerNotFoundException | InvalidAccountTypeException   e) {
			e.printStackTrace();
		}
	}
}
/*InvalidAmountException | CustomerNotFoundException | InvalidAccountTypeException*/