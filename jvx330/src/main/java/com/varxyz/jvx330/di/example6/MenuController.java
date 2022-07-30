package com.varxyz.jvx330.di.example6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 
 * @author Administrator
 * 값을 받아 처리한다.
 */

public class MenuController {
	
	@Autowired
	@Qualifier("Menu")
	private MenuService service;
	
	public MenuController() {
		service.addMenuItem("아메리카노", 1000);
	}

	public void findList() {
		
	}
}
