package com.varxyz.jvx330.jdbc.example2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class CustomerDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		
		findAllCustomers(dao);
		System.out.println("============================");
		findCustomerByRegDate(dao);
		System.out.println("============================");
		findCustomerByEmail(dao);
		context.close();
	}
	public static void findAllCustomers(CustomerDao dao) {
		System.out.println("findAllCustomer Test");
		dao.findAllCustomers().forEach(c -> System.out.println(c));
	}
	
	public static void findCustomerByRegDate(CustomerDao dao) {
		System.out.println("findcustomerByRegDate Test");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date currentDate = null;
		try {
			currentDate = format.parse(format.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Customer> list = dao.findCustomerByRegDate(currentDate);
		for(Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	private static void findCustomerByEmail(CustomerDao dao) {
		System.out.println("findCustomerByEmail Test");
		dao.findCustomerByEmail("jangbi@chonara.com");
	}
}
