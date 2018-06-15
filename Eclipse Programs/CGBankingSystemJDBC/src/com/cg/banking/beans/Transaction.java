package com.cg.banking.beans;
public class Transaction {
	private long transactionId;
	private float amount;
	private String transactionType;
	
	public Transaction() {
		super();
		
	}
	public Transaction(float amount, String transactionType) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
	}
	
	public Transaction(long transactionId, float amount, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionType = transactionType;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "Transaction: transactionId=" + transactionId + ", amount="
				+ amount + ", transactionType=" + transactionType;
	}
	
}
