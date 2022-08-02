package com.varxyz.jvx330.mvc.example4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("example4.addCustomerController")
public class AddCustomerController {
	@GetMapping("example4/add_customer")
	public String addCustomerForm() {
		return "example4/add_customer";
	}
	// model을 파라미터로 잡으면 자동으로 model로 넣어준다.?
	@PostMapping("example4/add_customer")
	public String addCustomer(CustomerCommand customerCommand, Model model) {
		System.out.println(customerCommand.getEmail());
		model.addAttribute("customerCommand", customerCommand);
		return "example4/success_add_customer";
	}
}
