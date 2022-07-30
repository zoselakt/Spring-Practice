package com.varxyz.jvx330.di.example5.ex02;

public class CookieCartService implements CartService{
	@Override
	public void addItem() {
		System.out.println("CookieCartService : addItem() is Called");
	}
}
