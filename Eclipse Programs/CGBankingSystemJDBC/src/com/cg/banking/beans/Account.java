package com.cg.banking.beans;
public class Account {
	private int pinNumber,pinCounter;
	private String accountType,status;
	private float accountBalance;
	private long accountNo;	
	private Transaction [] transactions=new Transaction[10];
	/*private int transactionCounter;
	private int transactionIdGenerator;*/
	public Account() {}
	public Account(int pinNumber, int pinCounter, String accountType, String status, float accountBalance,
			long accountNo, Transaction[] transactions) {
		super();
		this.pinNumber = pinNumber;
		this.pinCounter = pinCounter;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
		this.transactions = transactions;
	}
	public Account(String accountType, float accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public int getPinCounter() {
		return pinCounter;
	}
	public void setPinCounter(int pinCounter) {
		this.pinCounter = pinCounter;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public Transaction[] getTransactions() {
		return transactions;
	}
	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}
}