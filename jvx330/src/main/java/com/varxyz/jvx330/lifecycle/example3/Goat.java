package com.varxyz.jvx330.lifecycle.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

public class Goat {
	private static int count;
	
	public Goat() {
		count++;
	}
	public int getCount() {
		return count;
	}
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		Goat goat = context.getBean("goat", Goat.class);
		System.out.println("Goat's count : "+ goat.getCount()); //3개를 호출하였으나 기본적으로 싱글톤으로 관리되기 때문에 하나만 호출이 된다!
		
		context.close();
	}
}
