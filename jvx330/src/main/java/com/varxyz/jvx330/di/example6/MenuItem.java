package com.varxyz.jvx330.di.example6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Administrator
 * vo와 비슷한 처리를 담당
 */

@Getter
@Setter
@AllArgsConstructor
public class MenuItem{
	private String name;
	private int price;

	public MenuItem(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Menu[menu: ]" + name;
	}
}
