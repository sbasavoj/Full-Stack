package com.cg.banking.beans;

public class Address {
	private int pinCode;
	private String city,state,country;
	public Address(){}
	public Address(int pinCode, String city, String state, String country) {
//		super();
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
