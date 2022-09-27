package com.bluebiz.springBoard;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.bluebiz.springBoard.dao.BoardDao;
import com.bluebiz.springBoard.service.BoardServiceImpl;

import lombok.NoArgsConstructor;

@Configuration
public class DataSourceConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("kimgd");
		ds.setPassword("1234");
		ds.setInitialSize(2);	// Ŀ�ؼ� Ǯ �ʱ�ȭ�� ������ �ʱ� Ŀ�ؼ� ����(�⺻�� 10)
		ds.setMaxActive(10);	//Ǯ���� ������ �� �ִ� �ִ� Ŀ�ؼ� ����(�⺻�� 100)
		ds.setMaxIdle(10);		//Ǯ�� ������ �� �ִ� �ִ� Ŀ�ؼ� ��(�⺻���� maxActive�� ����)
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao(dataSource());
	}
	
	@Bean
	public BoardServiceImpl boardServiceImpl() {
		return new BoardServiceImpl();
	}
}
