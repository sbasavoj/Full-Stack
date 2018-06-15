package com.cg.banking.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.services.BankingServices;
public class SpringMainClass {
	public static void main(String[] args) {
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
			BankingServices bankingServices=(BankingServices) applicationContext.getBean("services");
			try {
				int associateId=bankingServices.acceptCustomerDetails("vidya", "basavoju", "abc@gmail.com", "AOJSI92", "Hyd", "TG", 12345, "Kmm", "TG", 128745);
			System.out.println(associateId);
			} catch (BankingServicesDownException e) {
				e.printStackTrace();
			}
	}
}
