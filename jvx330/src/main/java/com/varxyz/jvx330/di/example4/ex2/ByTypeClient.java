package com.varxyz.jvx330.di.example4.ex2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ByTypeClient {
	private NamingService service;
	
	public NamingService getNamingService() {
		return service;
	}
	public void setNamingService(NamingService service) {
		this.service = service;
	}
	public void service(String name) {
		Object o = service.lookup(name);
		System.out.println(o);
	}
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example4/ex2/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		ByTypeClient client = context.getBean("ByTypeClient" + ByTypeClient.class);
		client.service ("myQueue");
		context.close();
	}
}
