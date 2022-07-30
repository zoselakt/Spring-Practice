package com.varxyz.jvx330.di.example3;

import java.util.List;

public class MemberService {
	private MemberDao memberdao;
	
	public MemberService(MemberDao memberDao) {
		this.memberdao = memberDao;
	}
	
	public List<Member> getAllMembers(){
		return memberdao.findAllMembers();
	}
}
