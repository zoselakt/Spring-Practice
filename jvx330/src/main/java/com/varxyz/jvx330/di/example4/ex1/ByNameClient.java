package com.varxyz.jvx330.di.example4.ex1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ByNameClient {
	private NamingService namingSerivce;
	
	public NamingService getJmsNamingService() {
		return namingSerivce;
	}
	public void setJmsNamingService(NamingService namingService) {
		this.namingSerivce = namingService;
	}
	
	public void service(String name) {
		Object o = namingSerivce.lookup(name);
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example4/ex1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		ByNameClient client = context.getBean("byNameClient", ByNameClient.class);
		client.service("myQueue");
		context.close();
	}
}
