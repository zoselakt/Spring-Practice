package com.varxyz.jvx330.di.example5.ex02;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class QualifierTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example5/ex02/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		CartController controller = context.getBean("cartController" , CartController.class);
		controller.processRequest();
		context.close();
	}
}
