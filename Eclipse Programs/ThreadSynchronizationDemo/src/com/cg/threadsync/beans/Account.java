package com.cg.threadsync.beans;

public class Account {
	private static int SUCCESS,FAIL=0;
	private int balance;
	public Account() {}
	public Account(int balance) {
		super();
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public synchronized int deposit(int amount){
		balance +=amount;
		this.notify();
		this.notifyAll();
		return balance;	
	}
	public synchronized int withdraw(int amount) throws InterruptedException{	 
		if(balance<amount){
			System.out.println("withdral failure "+FAIL++);
			this.wait(1000);
		}
		else{
			balance -=amount;
			System.out.println("withdral success "+SUCCESS++);
		}
		return balance;

	}
}