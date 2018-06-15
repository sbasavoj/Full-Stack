package com.cg.threadsync.main;
import com.cg.threadsync.threadwork.Customer;
public class MainClass {
	public static void main(String[] args) {
		Thread th1=new Thread(new Customer(),"Lowkya");
		Thread th2=new Thread(new Customer(),"Sravan");
		Thread th3=new Thread(new Customer(),"Deepu");
		th1.start();
		th2.start();
		th3.start();
	}

}
