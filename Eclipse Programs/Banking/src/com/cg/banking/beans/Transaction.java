package com.cg.banking.beans;

public class Transaction {
	private int transactionId;	
	private float amount;
	private String transactionType,transactionLocation,modeOfTransation,transactionStatus, timeStamp;
	public Transaction() {}
	public Transaction(int transactionId, float amount, String transactionType, String transactionLocation,
			String modeOfTransation, String transactionStatus, String timeStamp) {
//		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionLocation = transactionLocation;
		this.modeOfTransation = modeOfTransation;
		this.transactionStatus = transactionStatus;
		this.timeStamp = timeStamp;
	}

	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
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
	public String getTransactionLocation() {
		return transactionLocation;
	}
	public void setTransactionLocation(String transactionLocation) {
		this.transactionLocation = transactionLocation;
	}
	public String getModeOfTransation() {
		return modeOfTransation;
	}
	public void setModeOfTransation(String modeOfTransation) {
		this.modeOfTransation = modeOfTransation;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

}
