package com.cg.servicesImpl;
import org.springframework.stereotype.Component;

import com.cg.services.GreetingServices;
@Component("greetings")
public class GreetingServicesNewImpl implements GreetingServices{
	public GreetingServicesNewImpl() {
		System.out.println("This is new Implimentation");
	}
	@Override
	public void SayHello(String person) {
		System.out.println("Hello "+person);		
	}
	@Override
	public void SayBye(String person) {
		System.out.println("Tata"+person);		
	}
}
