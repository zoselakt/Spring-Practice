package com.varxyz.jvx330.di.example5.ex01;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberController {
	@Autowired
	private MemberService memberService;
	
	public MemberController() {
		System.out.println("빈 생성: " + this);
	}
	public void processRequest() {
		memberService.addMember("java", "1111");
	}
}
