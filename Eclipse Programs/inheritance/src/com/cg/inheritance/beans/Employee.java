package com.cg.inheritance.beans;

public abstract class Employee {
	private int employeeId;
	private double basicSalary,totalSalary;
	private String firstName,lastName;
	public Employee() {
		super();
	}
	public Employee(int employeeId, double basicSalary, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Employee(int employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
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
    public abstract void calculateSalary();
 //   	totalSalary=basicSalary;
	@Override
	public String toString() {
		return "employeeId=" + employeeId + ", basicSalary=" + basicSalary + ", totalSalary=" + totalSalary
				+ ", firstName=" + firstName + ", lastName=" + lastName;
	}
    
}
