package com.cg.inheritance.beans;

public final class CEmployee extends Employee {
	private double hrs,variablePay;

	public CEmployee() {
		super();
	}
	public CEmployee(int employeeId, String firstName, String lastName,double hrs) {
		super(employeeId, firstName, lastName);
		this.hrs = hrs;
	}
	public double getHrs() {
		return hrs;
	}
	public void setHrs(double hrs) {
		this.hrs = hrs;
	}
	public double getVariablePay() {
		return variablePay;
	}
	public void setVariablePay(double variablePay) {
		this.variablePay = variablePay;
	}
	
	public void signTheContract(){
		System.out.println("Contract is signed");
	}
	@Override
	public void calculateSalary() {
		setVariablePay(hrs*2000);
		this.setTotalSalary(variablePay);
	}
	@Override
	public String toString() {
		return "Contract Employee:"+super.toString()+", hrs=" + hrs + ", variablePay=" + variablePay;
	}
	
}
