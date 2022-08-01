package com.varxyz.jvx330.jdbc.example3;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.example3.CustomerRowMapper;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public List<Customer> findAllCustomers(){
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regdate FROM Customer";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	public List<Customer> findCustomerByRegDate(Date regDate){
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regdate FROM Customer WHERE DATE(regDate) = ?";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regdate FROM Customer WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper());
	}
	
	public long countCustomers() {
		String sql = "SELECT count(*) FROM customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
