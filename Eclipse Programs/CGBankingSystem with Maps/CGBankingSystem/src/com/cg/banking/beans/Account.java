package com.cg.banking.beans;

import java.util.HashMap;

public class Account {
	private int pinNumber,pinCounter;
	private String accountType;
	private String status;
	private float accountBalance;
	private long accountNo;	
	private HashMap<Long, Transaction>transactions=new HashMap<>();
	private int transactionIdGenerator=1001;
	public Account() {
		super();
	}
	public Account(int pinNumber, int pinCounter, String accountType, String status, float accountBalance,
			long accountNo, HashMap<Long, Transaction> transactions) {
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
	
	public Account(int pinNumber, int pinCounter, String accountType, String status, float accountBalance,
			long accountNo, int transactionIdGenerator) {
		super();
		this.pinNumber = pinNumber;
		this.pinCounter = pinCounter;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
		this.transactionIdGenerator = transactionIdGenerator;
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

	public HashMap<Long, Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(HashMap<Long, Transaction> transactions) {
		this.transactions = transactions;
	}
	public int getTransactionIdGenerator() {
		return transactionIdGenerator;
	}

	public void setTransactionIdGenerator(int transactionIdGenerator) {
		this.transactionIdGenerator = transactionIdGenerator;
	}
	@Override
	public String toString() {
		return "Account [pinNumber=" + pinNumber + ", pinCounter=" + pinCounter + ", accountType=" + accountType
				+ ", status=" + status + ", accountBalance=" + accountBalance + ", accountNo=" + accountNo
				+ ", transactions=" + transactions 
				+ ", transactionIdGenerator=" + transactionIdGenerator + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountBalance);
		result = prime * result + (int) (accountNo ^ (accountNo >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + pinCounter;
		result = prime * result + pinNumber;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + transactionIdGenerator;
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Float.floatToIntBits(accountBalance) != Float.floatToIntBits(other.accountBalance))
			return false;
		if (accountNo != other.accountNo)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (pinCounter != other.pinCounter)
			return false;
		if (pinNumber != other.pinNumber)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (transactionIdGenerator != other.transactionIdGenerator)
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		return true;
	}	
	
}