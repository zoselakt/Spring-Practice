package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.AddCustomerDao;
import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
		//addcustomer1(dao);
		//addcustomer2(dao);
		addcustomer3(dao);
		context.close();
	}		
		public static void addcustomer1(AddCustomerDao dao) {
			Customer c = new Customer();
			c.setEmail("yubi@chonara.com");
			c.setPasswd("1111");
			c.setName("유비");
			c.setSsn("123456-1234567");
			c.setPhone("010-1111-2222");
			dao.addCustomer(c);
			System.out.println("Insert 성공");
	}
		public static void addcustomer2(AddCustomerDao dao) {
			Customer c = new Customer();
			c.setEmail("jojo@weenara.com");
			c.setPasswd("1234");
			c.setName("조조");
			c.setSsn("123456-1234567");
			c.setPhone("010-1234-1234");
			dao.addCustomer(c);
			System.out.println("Insert 성공");
	}
		public static void addcustomer3(AddCustomerDao dao) {
			Customer c = new Customer();
			c.setEmail("jangbi@chonara.com");
			c.setPasswd("1212");
			c.setName("장비");
			c.setSsn("123456-1234567");
			c.setPhone("010-1212-1212");
			dao.addCustomer3(c);
			System.out.println("Insert 성공");
	}
}
