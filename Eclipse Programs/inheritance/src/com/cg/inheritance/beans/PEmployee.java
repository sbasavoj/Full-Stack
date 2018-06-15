package com.cg.inheritance.beans;

public class PEmployee extends Employee {
	private double ta,da,hra;

	public PEmployee() {
		super();
	}

	public PEmployee(int employeeId, int basicSalary, String firstName, String lastName) {
		super(employeeId, basicSalary, firstName, lastName);
	}
	public PEmployee(int employeeId, int basicSalary, String firstName, String lastName,double ta, double da, double hra) {
		super(employeeId, basicSalary, firstName, lastName);
		this.ta = ta;
		this.da = da;
		this.hra = hra;
	}

	public double getTa() {
		return ta;
	}

	public void setTa(double ta) {
		this.ta = ta;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	@Override
	public void calculateSalary() {
		setHra(getBasicSalary()*.1);
		setDa(getBasicSalary()*.2);
		setTa(getBasicSalary()*.3);
		this.setTotalSalary(getBasicSalary()+hra+da+ta);
	}

	@Override
	public String toString() {
		return "Permenant Employee:"+super.toString()+", ta=" + ta + ", da=" + da + ", hra=" + hra;
	}

	
}