package com.varxyz.jvx330.di.example4.ex2;

public class JmsNamingServiceImpl implements NamingService{
	@Override
	public Object lookup(String name) {
		return "JMS: " + name;
	}
}
