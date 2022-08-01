package com.varxyz.jvx330.banking;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jvx330.banking.Service.BankingServiceimpl;

@Configuration
public class DataSourceConfigbank {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jvx330?serverTimezone=Asia/Seoul");
		ds.setUsername("root");
		ds.setPassword("1234");
		ds.setInitialSize(2); // 커넥션 풀 초기화 시 초기 커넥션 갯수(기본값: 10)
		ds.setMaxActive(10); // 풀에서 가져올 수 있는 최대 커넥션 갯수 (기본값: 100)
		ds.setMaxIdle(10); // 풀에 유지할 수 있는 최대 커넥션 갯수 (기본값: 100)
		return ds;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public AccountDao accountDao() {
		return new AccountDao(dataSource());
	}	
	@Bean
	public CustomerDao customerDao() {
		return new CustomerDao(dataSource());
	}
	@Bean
	public BankingServiceimpl bankingServiceimpl() {
		return new BankingServiceimpl(customerDao());
	}
}
