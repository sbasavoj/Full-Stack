package com.cg.threadsync.threadwork;

import com.cg.threadsync.beans.Account;

public class Customer implements Runnable{
	public Customer() {}
	private static Account account;
	static{
		account=new Account(1000);
		System.out.println("Intial Balance:"+account.getBalance()+"\n\n===============");
	}
	@Override
	public void run() {	
		Thread customerThread=Thread.currentThread();
		if(customerThread.getName().equals("Lowkya"))
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("Lowkya has call WithDraw()  "+i+" Time Balance:"+account.withdraw(2000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}					
			}
		if(customerThread.getName().equals("Sravan"))
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(    "Sravan has call Deposit()   "+i+" Time Balance:"+account.deposit(1000));
				
			}
		if(customerThread.getName().equals("Deepu"))
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(    "Deepu has call GetBalance() "+i+" Time Balance:"+account.getBalance());
			}
	}

}
