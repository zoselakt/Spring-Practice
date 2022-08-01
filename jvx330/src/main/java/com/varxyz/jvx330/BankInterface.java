package com.varxyz.jvx330;

import java.util.List;
import com.varxyz.jvx330.jdbc.example5.Account;

public interface BankInterface {
	public long addCustomer(String Customerid, String passwd, String name, String ssn, String phone);
	public long addAccount(char accountType, String Customerid);
	public List<Account> getAccounts(String Customerid);
	public long transfer(double balance, double inputNum, double outputNum);
	public long saveInterest(double interestRate, String accountNum);
	public List<Account> getBalance(String accountNum);
}
