package com.cg.banking.beans;
public class Customer {
	private int customerId;
	private String firstName,lastName,emailId,panCard;
	private Address localAddress,homeAddress;
	private Account [] accounts =new Account[10] ;
	//private int accountCounter=0;
	public Customer() {}
	public Customer(int customerId, String firstName, String lastName, String emailId, String panCard,
			Address localAddress, Address homeAddress, Account[] accounts) {
		super();
		//accountCounter=0;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.panCard = panCard;
		this.localAddress = localAddress;
		this.homeAddress = homeAddress;
		this.accounts = accounts;
	}
	public Customer(String firstName, String lastName, String emailId, String panCard,
			Address localAddress, Address homeAddress) {
		super();
		//accountCounter=0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.panCard = panCard;
		this.localAddress = localAddress;
		this.homeAddress = homeAddress;
	}
	
	public Customer(int customerId, Account[] accounts) {
		super();
		this.customerId = customerId;
		this.accounts = accounts;
		//accountCounter=1;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public Address getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(Address localAddress) {
		this.localAddress = localAddress;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
}