package com.medici.arang.board.notice.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.domain.NoticeRowMapper;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class NoticeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public NoticeDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insertNotice(NoticeCommand command) {
		String sql = "INSERT INTO notice (title, writer, content, readCnt) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, command.getTitle(), command.getWriter(),
				command.getContent(), command.getReadCnt());
	}
	public void updateNotice(NoticeCommand command, long num) {
		String sql = "UPDATE notice SET title = ?, writer = ?, content = ? WHERE num = ?";
		jdbcTemplate.update(sql, command.getTitle(), command.getWriter(),
				command.getContent(), num);
	}
	public void deleteNotice(long num) {
		String sql = "DELETE FROM notice WHERE num = ?";
		jdbcTemplate.update(sql ,num);
	}
	public List<NoticeCommand> findAllNotice(){
		String sql = "SELECT * FROM notice";
		return jdbcTemplate.query(sql, new NoticeRowMapper());
	}
	public NoticeCommand findOneNotice(long num) {
		NoticeCount(num);
		String sql = "SELECT * FROM notice WHERE num =?";
		return jdbcTemplate.queryForObject(sql, new NoticeRowMapper(), num);
	}
	public long NoticeCount(long num) {
		String sql = "UPDATE notice SET readCnt = readCnt + 1 WHERE num = ?";
		return jdbcTemplate.update(sql, num);
	}
}
