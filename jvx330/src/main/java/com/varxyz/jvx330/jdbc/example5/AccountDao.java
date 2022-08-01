package com.varxyz.jvx330.jdbc.example5;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import static java.sql.Types.*;

@Repository("accountDao")
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Account account) {
		String sql = " insert into Account(customerId, accountNum, accType, balance, interestRate"
				+ "overAmount) values(?,?,?,?,?,?) ";
		
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE, BIGINT};
		
		if(account instanceof SavingAccount) {
			sa = (SavingAccount) account;
			args = new Object[] {
					sa.getAccountNum(), String.valueOf(sa.getAccType()), 
					sa.getBalance(), sa.getInterestRate(), 0.0, sa.getCustomerId().getCid()};
		}else {
			ca = (CheckingAccount) account;
			args = new Object[] {
					ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), ca.getOverdraftAmount(), ca.getCustomerId().getCid()};
			}
		jdbcTemplate.update(sql, args, types);
	}

	public List<Account> findAccountsBySsn(String ssn){
		String sql = "select a.aid, a.customerId, a.accountId, a.accountNum, a.accType "
				+ " a.balance, a.interestRate, a.overAmount, a.regDate "
				+ " from Account a inner join Customer c"
				+ " on a.customerId = c.cid"
				+ " where c.ssn = ?";
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), ssn);
	}
	
	public List<Account> findAccountsByCustomerId(long customerId){
		String sql = "select a.aid, a.customerId, a.accountId, a.accountNum, a.accType "
				+ " a.balance, a.interestRate, a.overAmount, a.regDate "
				+ " from Account a inner join Customer c"
				+ " on a.customerId = c.cid"
				+ " where c.customerId = ?";
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
}
