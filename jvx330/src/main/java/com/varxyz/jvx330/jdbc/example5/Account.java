package com.varxyz.jvx330.jdbc.example5;

import java.sql.*;

import com.varxyz.jvx330.jdbc.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Account {
	private long aid;
	private Customer customerId;
	private char accountNum;
	private char accType;
	private double balance;
	private double interestRate;
	private double overAmount;
	private Date regDate;

}
