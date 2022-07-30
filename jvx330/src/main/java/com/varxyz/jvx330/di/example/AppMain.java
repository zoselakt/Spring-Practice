package com.varxyz.jvx330.di.example;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example/Beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		
		// xml에 등록하는 것으로 싱글톤패턴과 같은 출력결과를 얻는다.
		Foo foo = context.getBean("foo", Foo.class);
		System.out.println("foo: " + foo);
		
		//set으로 불러오기 / set으로 불러오기위해서는 파라미터가 비어있는 생성자를 만들어 불러와야한다. (필수)
		Foo foo2 = context.getBean("foo", Foo.class);
		System.out.println("foo2: " + foo2);
		context.close();
	}
}
