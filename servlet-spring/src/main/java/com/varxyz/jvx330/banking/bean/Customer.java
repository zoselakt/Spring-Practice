package com.varxyz.jvx330.banking.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@AllArgsConstructor
@ToString
public class Customer {
	private long cid;
	private String customerid;
	private String password;
	private String name;
	private String ssn;
	private String phone;
	
	public Customer() {
		super();
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}
}
