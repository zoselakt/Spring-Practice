package com.varxyz.jvx330.di.example5.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartController {
	
	@Autowired
	@Qualifier("sessionCartSerivce")
	private CartService service;

	public CartController() {
		System.out.println("CartController 생성");
	}
	
	public void processRequest() {
		service.addItem();
	}
	
}
