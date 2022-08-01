package com.varxyz.jvx330.banking.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account{
	private double overdraftAmount;
	
}
