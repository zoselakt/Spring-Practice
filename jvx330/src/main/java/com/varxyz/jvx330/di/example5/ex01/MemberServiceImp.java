package com.varxyz.jvx330.di.example5.ex01;

public class MemberServiceImp implements MemberService{
	
	public MemberServiceImp() {
		System.out.println("빈 생성: " + this);
	}
	
	@Override
	public void addMember(String id, String password) {
		System.out.println("new member inserted : " + id + "/ " + password);
	}
}
