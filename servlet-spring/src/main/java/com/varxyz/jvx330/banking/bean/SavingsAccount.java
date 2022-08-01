package com.varxyz.jvx330.banking.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account{
	private double interestRate;
	
	public void withdraw(double amount) {
		
	}
}