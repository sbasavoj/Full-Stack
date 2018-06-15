package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.daoservices.PayrollDAOServicesImpl;
import com.cg.payroll.exception.AssociateDetailsNotFoundException;

public class PayrollServicesImpl implements PayrollServices {
	private PayrollDAOServices daoServices;
	public PayrollServicesImpl(){
		daoServices=new PayrollDAOServicesImpl();
	}
	@Override
	public int acceptAssociateDetails(int yearlyInvestmentUnder80C,String firstName, String lastName,
			String department, String designation, String pancard, String emailId,
			double basicSalary,double epf, double companyPf,int accountNumber, String bankName,
			String ifscCode){
		return daoServices.insertAssociate(new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new Salary(basicSalary, epf, companyPf),new BankDetails(accountNumber, bankName, ifscCode)));
	}
	@Override
	public double calculateNetSAlary(int associateId)throws AssociateDetailsNotFoundException{
		Associate associate=this.getAssociateDetails(associateId);
		
			associate.getSalary().setConveyenceAllowance((0.20*(associate.getSalary().getBasicSalary())));
			associate.getSalary().setPersonalAllowance  ((0.30*(associate.getSalary().getBasicSalary())));
			associate.getSalary().setOtherAllowance     ((0.10*(associate.getSalary().getBasicSalary())));
			associate.getSalary().setGratuity           ((0.05*(associate.getSalary().getBasicSalary())));
			associate.getSalary().setHra                ((0.25*(associate.getSalary().getBasicSalary())));
			associate.getSalary().setGrossSalary        (associate.getSalary().getBasicSalary()+associate.getSalary().getPersonalAllowance()+associate.getSalary().getConveyenceAllowance()+associate.getSalary().getOtherAllowance()+associate.getSalary().getHra()+associate.getSalary().getCompanyPf());
			double annualGrossSalary   =12*associate.getSalary().getGrossSalary();
			double nonTaxable=(associate.getSalary().getEpf()+associate.getSalary().getCompanyPf())*12 +associate.getYearlyInvestmentUnder80C();
			double annualTax=0;
			if(nonTaxable>150000)
				nonTaxable=150000;
			if(annualGrossSalary<=250000)
				annualTax = 0;
			else if(annualGrossSalary>250000&&annualGrossSalary<=500000){
				if(annualGrossSalary-nonTaxable-250000>0)
					annualTax=.1*(annualGrossSalary-nonTaxable-250000);
				else
					annualTax = 0;
			}	
			else if(annualGrossSalary>500000&&annualGrossSalary<=1000000)
				annualTax=.1*(-nonTaxable+250000)+.2*(annualGrossSalary-500000);
			else 
				annualTax=(.1*(-nonTaxable+250000))+(.2*500000)+.3*(annualGrossSalary-1000000);
			associate.getSalary().setMonthlyTax(annualTax/12);
			associate.getSalary().setNetSalary(associate.getSalary().getGrossSalary()-associate.getSalary().getMonthlyTax()-associate.getSalary().getEpf()-associate.getSalary().getCompanyPf());
			//			daoServices.updateAssociate(associate);
			return associate.getSalary().getNetSalary();
		
		//return 0;
	}
	@Override
	public Associate getAssociateDetails(int associateId)throws AssociateDetailsNotFoundException{
		Associate associate= daoServices.getAssociate(associateId);
		if(associate==null)
			throw new AssociateDetailsNotFoundException("Associate details of associateId "+associateId+" not found");
		return associate;
	}
	@Override
	public List<Associate> getAllAssociateDetails(){
		return daoServices.getAssociates();
	}
	public boolean deleteAssociateDetails(int associateId)throws AssociateDetailsNotFoundException{
		if(daoServices.getAssociate(associateId)==null)
			throw new AssociateDetailsNotFoundException(associateId+" not found to delete");
		return daoServices.deleteAssociate(associateId);
	}
}
