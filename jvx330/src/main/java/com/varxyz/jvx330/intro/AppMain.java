package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/intro/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		Hello hello = context.getBean("helloBean", Hello.class);
		System.out.println(hello.sayHello(" spring"));
		context.close();
		
//		Hello hbe = new HelloBeanEn();
//		System.out.println(hbe.sayHello(" spring"));
	}
}
