package com.cg.ioexception.beans;

import java.io.Serializable;

public class Associate implements Serializable {
	int associateId,salary;
	String firstName,lastName;
	public Associate() {}
	public Associate(int associateId, int salary, String firstName, String lastName) {
		super();
		this.associateId = associateId;
		this.salary = salary;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getAssociateId() {
		return associateId;
	}
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
	@Override
	public String toString() {
		return "Associate [associateId=" + associateId + ", salary=" + salary + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
