package com.varxyz.jvx330.banking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.jvx330.banking.bean.Customer;

@Controller("banking.controller.mainController")
public class MainController {
	@GetMapping("banking/main")
	public String mainForm() {
		return "banking/main";
	}
	@GetMapping("banking/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("redirect:/banking/loginForm");
		return mv;
	}
	@PostMapping("banking/main")
	public String Formmain(Customer customer, Model model) {
		model.addAttribute("customer", customer);
		return "banking/main";
	}
}
