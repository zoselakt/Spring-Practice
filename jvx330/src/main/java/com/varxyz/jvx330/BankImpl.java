package com.varxyz.jvx330;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.varxyz.jvx330.jdbc.example5.Account;

public class BankImpl implements BankInterface{
	private BankDao dao = new BankDao();
	
	@Autowired
	public BankImpl(BankDao dao) {
		this.dao = dao;
	}

	@Override
	public long addCustomer(String Customerid, String passwd, String name, String ssn, String phone) {
		return dao.addCustomer(Customerid, passwd, name, ssn, phone);
	}

	@Override
	public long addAccount(char accountType, String customerid) {
		return dao.addAccount(accountType, customerid);
	}

	@Override
	public List<Account> getAccounts(String Customerid) {
		return dao.getAccounts(Customerid);
	}

	@Override
	public long transfer(double balance, double savingAccount, double checkingAccount) {
		return dao.transfer(balance, savingAccount, checkingAccount);
	}
	

	@Override
	public long saveInterest(double interestRate, String accountNum) {
		return dao.saveInterest(interestRate, accountNum);
	}

	@Override
	public List<Account> getBalance(String accountNum) {
		return getBalance(accountNum);
	}

}
