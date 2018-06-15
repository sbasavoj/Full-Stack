package com.cg.inheritance.beans;

public final class SalesManager extends PEmployee {
	private double comission;
	private int sales;
	public SalesManager() {
		super();
	}
	public SalesManager(int employeeId, int basicSalary, String firstName, String lastName, 
			int sales) {
		super(employeeId, basicSalary, firstName, lastName);
		this.sales=sales;
	}
	public double getComission() {
		return comission;
	}
	public void setComission(double comission) {
		this.comission = comission;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public void ToDoSales(){
		System.out.println("sales are done");
	}
	@Override
	public String toString() {
		return "Sales Manager:"+super.toString()+", comission=" + comission + ", sales=" + sales;
	}
	@Override
	public void calculateSalary() {
		super.calculateSalary();
		this.setComission(.01*sales);
		this.setTotalSalary(getTotalSalary()+comission);
	}
	
	
}
