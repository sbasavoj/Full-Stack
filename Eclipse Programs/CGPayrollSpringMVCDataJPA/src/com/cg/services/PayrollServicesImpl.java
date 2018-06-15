package com.cg.services;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.beans.Associate;
import com.cg.beans.BankDetails;
import com.cg.beans.Salary;
import com.cg.daoservices.PayrollDaoServices;
import com.cg.exception.AssociateDetailsNotFoundException;
import com.cg.exception.PayrollServicesDownException;
@Component("services")
@Transactional
public class PayrollServicesImpl implements PayrollServices{
	@Autowired
	private PayrollDaoServices daoServices;
	@Override
	public int acceptAssociateDetails(Associate associate)throws PayrollServicesDownException{
		Associate associate1= daoServices.save(associate);
		return associate1.getAssociateId();
	}
	@Override
	public double calculateNetSAlary(int associateId)throws PayrollServicesDownException,AssociateDetailsNotFoundException{
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
		daoServices.saveAndFlush(associate);
		return associate.getSalary().getNetSalary();
	}
	@Override
	public Associate getAssociateDetails(int associateId)throws PayrollServicesDownException,AssociateDetailsNotFoundException{
		Associate associate= daoServices.findOne(associateId);
		if(associate==null)
			throw new AssociateDetailsNotFoundException("Associate details of associateId "+associateId+" not found");
		return associate;
	}
	@Override
	public List<Associate> getAllAssociateDetails() throws PayrollServicesDownException{
		return daoServices.findAll();
	}
	@Transactional()
	public boolean deleteAssociateDetails(int associateId)throws PayrollServicesDownException, AssociateDetailsNotFoundException{
		if(daoServices.findOne(associateId)==null)
			throw new AssociateDetailsNotFoundException(associateId+" not found to delete");
		else{
			daoServices.delete(associateId);
			return  true;
		}
	}
}
