package com.varxyz.jvx330;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class BankTransfe1r {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		BankTransfer transfer = context.getBean("bankTransfer");
		bankTransfer(transfer);
		context.close();
	}
	public static void bankTransfer(BankDao dao) {
		BankImpl t = new BankImpl(dao);
		t.getAccounts("yobi1");
		t.getBalance("1000");
		t.saveInterest(0.0, "123-11-1234567");
		t.transfer(1000, 0.0, 0.0);
		System.out.println("이체성공");
	}
}
