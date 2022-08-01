package com.varxyz.jvx330.banking;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.banking.bean.Account;
import com.varxyz.jvx330.banking.bean.CheckingAccount;
import com.varxyz.jvx330.banking.bean.Customer;
import com.varxyz.jvx330.banking.bean.SavingsAccount;
/**
 * @author Administrator
 * resultSet의 용도로 사용하는 RowMapper
 */
public class CustomerAccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = null;
		char accountNum = rs.getString("accountNum").charAt(0);
		char accountType = rs.getString("accountType").charAt(1);
		if(accountType == 'C') {
			account = new CheckingAccount();
			CheckingAccount ca = (CheckingAccount) account;
			ca.setOverdraftAmount(rs.getDouble("overAmount"));
		}else {
			account = new SavingsAccount();
			SavingsAccount sa = (SavingsAccount) account;
			sa.setInterestRate(rs.getDouble("interestRate"));
		}
		account.setAid(rs.getLong("aid"));
		account.setCustomerId(new Customer(rs.getLong("customerId")));
		account.setAccountNum(accountNum);
		account.setAccountType(accountType);
		account.setBalance(rs.getDouble("balance"));
		account.setRegDate(rs.getDate("regDate"));
		
		return account;
	}
}
