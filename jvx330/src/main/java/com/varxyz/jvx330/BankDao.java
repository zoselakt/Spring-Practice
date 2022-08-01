package com.varxyz.jvx330;

import java.util.List;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.example5.Account;

public class BankDao {

	public long addCustomer(String customerid, String passwd, String name, String ssn, String phone) {
		return 0;
	}

	public long addAccount(char accountType, String customerid) {
		return 0;
	}

	public List<Account> getAccounts(String customerid) {
		return null;
	}

	public long transfer(double balance, double savingAccount, double checkingAccount) {
		return 0;
	}

	public long saveInterest(double interestRate, String accountNum) {
		return 0;
	}
}
