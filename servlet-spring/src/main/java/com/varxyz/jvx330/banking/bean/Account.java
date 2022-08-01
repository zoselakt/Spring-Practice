package com.varxyz.jvx330.banking.bean;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Account {
	private long aid;
	private Customer customerId;
	private char accountNum;
	private char accountType;
	private double balance;
	private double interestRate;
	private double overAmount;
	private Date regDate;
	
	public Account() {
		super();
	}
}
