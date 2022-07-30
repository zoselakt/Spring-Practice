package com.varxyz.jvx330.lifecycle.example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;
import com.varxyz.jvx330.lifecycle.example2.Eagle;

public class Dog implements InitializingBean, DisposableBean{
	private String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Dog dog = context.getBean("dog", Dog.class);
		System.out.println("dog's name : "+ dog.getName());
		
		Eagle eagle = context.getBean("eagle", Eagle.class);
		System.out.println("eagle's name: " + eagle.getName());
		context.close();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy() 호출");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() 호출");
		if(name == null) {
			System.out.println("property name must be set");
		}else {
			System.out.println(name);
		}
	}
}
