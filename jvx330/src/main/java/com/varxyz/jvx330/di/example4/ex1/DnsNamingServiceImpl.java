package com.varxyz.jvx330.di.example4.ex1;

public class DnsNamingServiceImpl implements NamingService{

	@Override
	public Object lookup(String name) {
		return "DNS: " + name;
	}
}
