package com.varxyz.jvx330.di.example5.ex02;

public class SessionCartSerivce implements CartService{

	@Override
	public void addItem() {
		System.out.println("SessionCartService : addItem() is Called");
	}
}
