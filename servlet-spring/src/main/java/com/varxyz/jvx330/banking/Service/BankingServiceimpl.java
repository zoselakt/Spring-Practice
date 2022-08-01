package com.varxyz.jvx330.banking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.jvx330.banking.CustomerDao;
import com.varxyz.jvx330.banking.bean.Customer;

import lombok.NoArgsConstructor;

@Service
public class BankingServiceimpl implements BankingService {
	private CustomerDao dao = new CustomerDao();
	
	
	@Autowired
	public BankingServiceimpl(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public long addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	@Override
	public List<Customer> findAllCustomer(String customerid, String password, String name, String ssn, String phone) {
		return dao.findAllCustomer();
	}

	@Override
	public long modifyPassword(int password) {
		return dao.modifyPassword(password);
	}

	@Override
	public long modifyCustomer(Customer customer) {
		return dao.modifyCustomer(customer);
	}

	public long deleteCustomer(Customer customer) {
		return dao.deleteCustomer(customer);
	}
}