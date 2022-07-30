package com.varxyz.jvx330.intro;

public class HelloBeanKo implements Hello{

	@Override
	public String sayHello(String name) {
		return "안녕하세요" + name;
	}
	
}
