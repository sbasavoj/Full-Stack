package com.cg.inheritance.beans;

public final class Developer extends PEmployee{
	private int incentive,projects;

	public Developer() {
		super();
	}
	public Developer(int employeeId, int basicSalary, String firstName, String lastName,int projects) {
		super(employeeId, basicSalary, firstName, lastName);
		this.projects = projects;
	}
	public int getIncentive() {
		return incentive;
	}
	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}
	public int getProjects() {
		return projects;
	}
	public void setProjects(int projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Developer:"+super.toString()+", incentive=" + incentive + ", projects=" + projects;
	}
	@Override
	public void calculateSalary() {
		super.calculateSalary();
		setIncentive(projects*5000);
		setTotalSalary(getTotalSalary()+incentive);
	}


}
