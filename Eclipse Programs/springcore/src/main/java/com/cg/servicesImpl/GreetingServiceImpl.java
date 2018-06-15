package com.cg.servicesImpl;
import org.springframework.stereotype.Component;

import com.cg.services.GreetingServices;
public class GreetingServiceImpl implements GreetingServices {
	@Override
	public void SayHello(String person) {
		System.out.println("Good Morning "+person);
	}
	@Override
	public void SayBye(String person) {
		System.out.println("Bye "+person);
	}
}
