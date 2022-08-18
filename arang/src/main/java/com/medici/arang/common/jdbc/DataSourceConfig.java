package com.medici.arang.common.jdbc;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.medici.arang.board.Notice.dao.NoticeDao;
import com.medici.arang.board.Notice.service.NoticeServiceImpl;
import com.medici.arang.board.gallery.dao.GalleryDao;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;

@Configuration
public class DataSourceConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/arang?serverTimezone=Asia/Seoul");
		ds.setUsername("root");
		ds.setPassword("admin");
		ds.setInitialSize(2);	// 커넥션 풀 초기화시 생설할 초기 커넥션 갯수(기본값 10)
		ds.setMaxActive(10);	//풀에서 가져올 수 있는 최대 커넥션 갯수(기본값 100)
		ds.setMaxIdle(10);		//풀에 유지할 수 있는 최대 커넥션 수(기본값은 maxActive와 동일)
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public GalleryDao galleryDao() {
		return new GalleryDao(dataSource());
	}
	@Bean
	public GalleryServiceImpl galleryServiceImpl() {
		return new GalleryServiceImpl(galleryDao());
	}
	@Bean
	public NoticeDao noticeDao() {
		return new NoticeDao();
	}
	@Bean
	public NoticeServiceImpl noticeServiceImpl() {
		return new NoticeServiceImpl();
	}
}
