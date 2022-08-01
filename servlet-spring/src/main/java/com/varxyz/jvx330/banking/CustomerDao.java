package com.varxyz.jvx330.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import static java.sql.Types.*;
import com.varxyz.jvx330.banking.bean.Customer;

import lombok.NoArgsConstructor;

@Repository("customerDao")
@NoArgsConstructor
public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public long addCustomer(Customer customer) {
		String sql = "INSERT INTO addcustomer(customerid, password, name, ssn, phone) values (?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) ->{
				PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"cid"});
				pstmt.setString(1, customer.getCustomerid());
				pstmt.setString(2, customer.getPassword());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getSsn());
				pstmt.setString(5, customer.getPhone());
				return pstmt;
			};
		jdbcTemplate.update(creator, keyHolder);
		return keyHolder.getKey().longValue();
	}
	
	public List<Customer> findAllCustomer(){
		String sql = "SELECT customerid, password, name, ssn, phone FROM addcustomer";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
	}
	
	public long modifyPassword(int password){
		String sql = "UPDATE addcustomer set password = ? where cid = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				Customer customer = new Customer();
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getSsn());
				pstmt.setString(3, customer.getPhone());
				return pstmt;
			}
		}, null);
	}
	
	public long modifyCustomer(Customer customer){
		String sql = "UPDATE addcustomer SET name = ?, ssn = ?, phone = ? WHERE cid = ?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"cid"});
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setLong(4, customer.getCid());
			return pstmt;
		};
		jdbcTemplate.update(creator, keyHolder);
		return keyHolder.getKey().longValue();
	}

	public long deleteCustomer(Customer customer) {
		String sql = "delete from addcustomer where cid = ?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int[] types = new int[] {BIGINT};
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				Customer customer = new Customer();
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getSsn());
				pstmt.setString(3, customer.getPhone());
				return pstmt;
			}
		}, keyHolder);
		
	}
}
