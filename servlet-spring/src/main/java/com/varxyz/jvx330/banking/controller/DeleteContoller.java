package com.varxyz.jvx330.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jvx330.banking.Service.BankingServiceimpl;
import com.varxyz.jvx330.banking.bean.Customer;

@Controller
public class DeleteContoller {
	private BankingServiceimpl bankingServiceimpl;
	
	@Autowired
	public DeleteContoller(BankingServiceimpl bankingServiceimpl) {
		this.bankingServiceimpl = bankingServiceimpl;
	}
	
	@GetMapping("banking/deleteCustomer")
	public String delete(Customer customer) {
		return "banking/deleteCustomer";
	}
	@PostMapping("banking/deleteCustomer")
	public String deleteCustomer(Customer customer, Model model) {
		model.addAttribute(customer);
		bankingServiceimpl.deleteCustomer(customer);
		return "redirect:banking/main";
	}
}
