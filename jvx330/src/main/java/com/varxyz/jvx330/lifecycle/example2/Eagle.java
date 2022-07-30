package com.varxyz.jvx330.lifecycle.example2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle {
	private String name;
	
	public void attachWings() {
		System.out.println("Eagle의 날개를 달아줍니다.");
	}
	public void detachWings() {
		System.out.println("Eagle의 날개를 회수합니다.");
	}
}
