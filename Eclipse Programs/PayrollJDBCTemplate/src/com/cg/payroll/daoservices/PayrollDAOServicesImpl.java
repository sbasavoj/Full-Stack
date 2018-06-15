package com.cg.payroll.daoservices;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exception.PayrollServicesDownException;
import com.cg.payroll.utility.PayrollUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
//import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component(value="DAOServices")
public class PayrollDAOServicesImpl implements PayrollDAOServices {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public int insertAssociate(Associate associate) throws PayrollServicesDownException {
		try {
			String sql = "insert into Associate(yearlyInvestmentUnder80C,firstName,lastName,department,designation,pancard,emailId) value(?,?,?,?,?,?,?)";
			int associateId = jdbcTemplate.update(sql, new Object[] {associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId()});
			String sql1="select max(associateId) from associate";
			List<Associate> a=jdbcTemplate.query(sql1, new Associate());
			int b=a.get(0).getAssociateId();
			String sql2 = "insert into Salary(associateId,basicSalary,epf,companyPf) value(?,?,?,?)";
			jdbcTemplate.update(sql2, new Object[] {b,associate.getSalary().getBasicSalary(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf()});
			String sql3 = "insert into BankDetails(associateId,accountNo,bankName,ifscCode) value(?,?,?,?)";
			jdbcTemplate.update(sql3, new Object[] {b,associate.getBankDetail().getAccountNumber(),associate.getBankDetail().getBankName(),associate.getBankDetail().getIfscCode()});
			return associateId;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownException();
		}		
	}

	@Override
	public boolean updateAssociate(Associate associate) throws PayrollServicesDownException {
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt=con.prepareStatement("select associateId from Associate where associateId=?");
			pstmt.setInt(1, associate.getAssociateId());
			ResultSet rs = pstmt.executeQuery();	
			if(rs.next())
			{
				PreparedStatement pstmt1=con.prepareStatement("update Associate set yearlyInvestmentUnder80C=?,firstName=?,lastName=?,department=?,designation=?,pancard=?,emailId=? where associateId=?"); 
				pstmt1.setInt(1, associate.getYearlyInvestmentUnder80C());
				pstmt1.setString(2, associate.getFirstName());
				pstmt1.setString(3, associate.getLastName());
				pstmt1.setString(4, associate.getDepartment());
				pstmt1.setString(5, associate.getDesignation());
				pstmt1.setString(6, associate.getPancard());
				pstmt1.setString(7, associate.getEmailId());
				pstmt1.setInt(8, associate.getAssociateId());
				pstmt1.executeUpdate();

				PreparedStatement pstmt2=con.prepareStatement("update Salary set basicSalary=?, hra=?, conveyenceAllowance=?,otherAllowance=?,personalAllowance=?,monthlyTax=?,	epf=?,companyPf=?,gratuity=?,grossSalary=?,netSalary=?");
				pstmt2.setDouble(2, associate.getSalary().getBasicSalary());
				pstmt2.setDouble(3, associate.getSalary().getEpf());
				pstmt2.setDouble(4, associate.getSalary().getCompanyPf());
				pstmt2.executeUpdate();

				PreparedStatement pstmt3=con.prepareStatement("update BankDetails accountNumber=?,bankName=?,ifscCode=?");
				pstmt3.setInt(2, associate.getBankDetails().getAccountNumber());
				pstmt3.setString(3, associate.getBankDetails().getBankName());
				pstmt3.setString(4, associate.getBankDetails().getIfscCode());
				con.commit();
				return true;
			}
			return false;		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownException();
		}		
	}

	@Override
	public boolean deleteAssociate(int associateId) throws PayrollServicesDownException {
		return false;
	}

	@Override
	public Associate getAssociate(int associateId)throws PayrollServicesDownException  {
		try{
			PreparedStatement pstmt=con.prepareStatement("select a.associateId,a.yearlyInvestmentUnder80C,a.firstName,a.lastName,a.department,a.designation,a.pancard,a.emailId,b. from Associate where associateId=?");
			pstmt.setInt(1, associateId);
			ResultSet rs = pstmt.executeQuery();	
			if(rs.next())
				return new Associate(associateId,rs.getInt("yearlyInvestmentUnder80C"), rs.getString("firstName"),rs.getString("lastName"), rs.getString("department"),rs.getString("designation"), rs.getString("pancard"), rs.getString("emailId"), new Salary(rs.getDouble("basicSalary"), rs.getDouble("hra"), rs.getDouble("conveyenceAllowance"), rs.getDouble("otherAllowance"), rs.getDouble("personalAllowance"), rs.getDouble("monthlyTax"),rs.getDouble("epf"), rs.getDouble("companyPf"), rs.getDouble("gratuity"), rs.getDouble("grossSalary"), rs.getDouble("netSalary")), new BankDetails(rs.getInt("accountNumber"), rs.getString("bankName"), rs.getString("ifscCode")));
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownException();
		}		
	}
	@Override
	public List<Associate> getAssociates() throws PayrollServicesDownException {
		return null;
	}

}