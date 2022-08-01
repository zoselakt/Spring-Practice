package com.varxyz.jvx330.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jvx330.banking.bean.Account;

@Controller("banking.controller.addAccountController")
public class AddAccountController {
	@GetMapping("banking/addAccountForm")
	public String addaccountForm() {
		return "banking/addAccountForm";
	}
	@PostMapping("banking/addAccountForm")
	public String addaccount(Account account, Model model) {
		model.addAttribute("account", account);
		return "banking/addAccountForm";
	}
}