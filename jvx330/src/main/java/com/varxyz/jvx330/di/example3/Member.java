package com.varxyz.jvx330.di.example3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
	private String userId;
	private String name;
	
	public String toString() {
		return "Member [userId=" + userId + ", name=" + name + "]";
	}
}
