package com.cg.propertyinjection.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.propertyinjection.beans.Associate;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
		Associate associate=(Associate) applicationContext.getBean("associate");
		System.out.println(associate);
	}
}
