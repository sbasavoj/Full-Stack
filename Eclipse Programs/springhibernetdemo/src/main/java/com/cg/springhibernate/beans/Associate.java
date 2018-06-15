package com.cg.springhibernate.beans;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Associate {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int associateId;
private String firstName,lastName;
private float salary;
private long mobileNo;
@Embedded
private Address address;
public Associate() {}
public Associate(int associateId, String firstName, String lastName, float salary, long mobileNo, Address address) {
	super();
	this.associateId = associateId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.salary = salary;
	this.mobileNo = mobileNo;
	this.address = address;
}
public int getAssociateId() {
	return associateId;
}
public void setAssociateId(int associateId) {
	this.associateId = associateId;
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
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Associate [associateId=" + associateId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
			+ salary + ", mobileNo=" + mobileNo + ", address=" + address + "]";
}
}
