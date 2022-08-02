package com.varxyz.jvx330.jdbc.example3;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{
	
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
		Customer customer = new Customer(rs.getLong("cid"),
				rs.getString("email"), rs.getString("passwd"),
				rs.getString("name"), rs.getString("ssn"),
				rs.getString("phone"), rs.getTimestamp("regDate"));
		return customer;
	}
}
