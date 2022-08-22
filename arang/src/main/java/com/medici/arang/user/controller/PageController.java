package com.medici.arang.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.user.service.ArtistServiceImpl;
import com.medici.arang.user.service.GalleristServiceImpl;

@Controller("controller.pageController")
public class PageController {
	
	@Autowired
	ArtistServiceImpl artistService;
	
	@Autowired
	GalleristServiceImpl galleristService;
	
	@GetMapping("/main")
	public String mainForm() {
		return "main";				
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("login")
	public String Login(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		
		//유효성 검증
		if(!artistService.isValidUser(email, passwd)) {
			if(!galleristService.isValidUser(email, passwd)) {
				model.addAttribute("msg", "없는 아이디거나 틀린 비밀번호 입니다.");
				model.addAttribute("url", "login");
				return "alert";
			}
		}
		session.setAttribute("email", email);
		//성공시 갈곳
		return "main";
	}
	
	@GetMapping("/user/logout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		session.invalidate();		
		return "main";
	}
	
	@GetMapping("/user/select_user_type")
	public String selectUserTypeForm() {
		return "/user/select_user_type";				
	}
}
