package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.services.GreetingServices;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
		GreetingServices greetingServices=(GreetingServices) applicationContext.getBean("greetings");
				greetingServices.SayHello("Vidya");
	}
}
 