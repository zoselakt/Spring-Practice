package com.varxyz.jvx330.banking.Service;

import java.util.List;

import com.varxyz.jvx330.banking.bean.Customer;

public interface BankingService {
	long addCustomer(Customer customer);
	List<Customer> findAllCustomer(String customerid, String password, String name, String ssn, String phone);
	long modifyPassword(int password);
	long modifyCustomer(Customer Customer);
	long deleteCustomer(Customer customer);
}
