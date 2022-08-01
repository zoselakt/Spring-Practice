package com.varxyz.jvx330.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jvx330.banking.Service.BankingServiceimpl;
import com.varxyz.jvx330.banking.bean.Customer;

@Controller
public class ModifyController {
	
	private BankingServiceimpl bankingServiceimpl;
	
	@Autowired
	public ModifyController(BankingServiceimpl bankingServiceimpl) {
		this.bankingServiceimpl = bankingServiceimpl;
	}
	@GetMapping("banking/modifyCustomer")
	public String modify() {
		return "banking/modifyCustomer";
	}
	@PostMapping("banking/modifyCustomer")
	public String customerModify(Customer customer, Model model) {
		
		model.addAttribute(customer);
		bankingServiceimpl.modifyCustomer(customer);
		return "banking/modifyCustomer";
	}
	
}
