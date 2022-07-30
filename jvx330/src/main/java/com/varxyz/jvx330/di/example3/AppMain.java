package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		//String config = "com/varxyz/jvx330/di/example3/beans.xml";
		//GenericApplicationContext context = new GenericXmlApplicationContext(config);
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService service = context.getBean("memberService", MemberService.class);
		service.getAllMembers().forEach(member -> System.out.println(member));
//		System.out.println(service.getAllMembers());
		context.close();
	}
}
