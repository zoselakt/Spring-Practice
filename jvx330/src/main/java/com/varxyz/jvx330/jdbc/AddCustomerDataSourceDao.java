package com.varxyz.jvx330.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//둘중아무거나 써도 상관없다
// import org.apache.tomcat.jdbc.pool.DataSource;
import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddCustomerDataSourceDao {
	private DataSource dataSource;
	
	public AddCustomerDataSourceDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO customer (email, passwd, name, ssn, phone) VALUES (?, ?, ?, ?, ?)";
		
		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, customer.getEmail());
			pstmt.setString(2, customer.getPasswd());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getSsn());
			pstmt.setString(5, customer.getPhone());
			pstmt.executeUpdate();
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AddCustomerDataSourceDao dao = context.getBean("addCustomerDataSourceDao", AddCustomerDataSourceDao.class);
		Customer c = new Customer();
		c.setEmail("yubi@java.com");
		c.setPasswd("1234");
		c.setName("유비");
		c.setSsn("123456-1234567");
		c.setPhone("010-1111-1111");
		dao.addCustomer(c);
		System.out.println("insert 성공");
		context.close();
	}
}
