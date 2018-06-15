package com.cg.banking.beans;

public class Customer {
	private int customerId;
	private long mobileNo,adharNo;
	private String firstName,lastName,emailId,pancardNo,dateOfBirth;
	private Address address;
	private Account[] accounts;
	public Customer() {}
	public Customer(int customerId, long mobileNo, long adharNo, String firstName, String lastName, String emailId,
			String pancardNo, String dateOfBirth, Address address, Account[] accounts) {
//		super();
		this.customerId = customerId;
		this.mobileNo = mobileNo;
		this.adharNo = adharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.pancardNo = pancardNo;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.accounts = accounts;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
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
	public String getPancardNo() {
		return pancardNo;
	}
	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
