package com.cg.banking.rowmappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.cg.banking.beans.Account;
public class AccountRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account=new Account();
		account.setAccountType(rs.getString("accountType"));
		account.setAccountBalance(rs.getFloat("accountBalance"));
		account.setPinNumber(rs.getInt("pinNumber"));
		account.setPinCounter(rs.getInt("pinCounter"));
		account.setStatus(rs.getString("status"));
		return account;
	}
}
