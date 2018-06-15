package com.cg.propertyinjection.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.propertyinjection.beans.Associate;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
		Associate associate1=(Associate) applicationContext.getBean("associate");
		Associate associate2=(Associate) applicationContext.getBean("associate");
		System.out.println(associate1);
		System.out.println(associate2);
	if(associate1==associate2)
		System.out.println("Same Reference");
	else
		System.out.println("Not Same Reference");
	if(associate1.equals(associate2))
		System.out.println("Same Data");
	else
		System.out.println("Not Same Data");
		
	}
}
