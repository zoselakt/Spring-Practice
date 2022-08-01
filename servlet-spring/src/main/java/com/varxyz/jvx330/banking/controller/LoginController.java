package com.varxyz.jvx330.banking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("banking.controller.loginController")
public class LoginController {
	@GetMapping("banking/loginForm")
	public String loginForm() {
		return "banking/loginForm";
	}
	@PostMapping("banking/loginForm")
	public ModelAndView login(HttpServletRequest request, HttpSession session) {
		String customerid = request.getParameter("customerid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String phone = request.getParameter("phone");
		session.setAttribute("customerid", customerid);
		session.setAttribute("password", password);
		session.setAttribute("name", name);
		session.setAttribute("ssn", ssn);
		session.setAttribute("phone", phone);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerid", customerid);
		mav.addObject("password", password);
		mav.addObject("name", name);
		mav.addObject("ssn", ssn);
		mav.addObject("phone", phone);
		mav.setViewName("banking/main");
		return mav;
	}
}
