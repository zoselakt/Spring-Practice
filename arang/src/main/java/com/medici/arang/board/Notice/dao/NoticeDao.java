package com.medici.arang.board.Notice.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.medici.arang.board.Notice.domain.NoticeRowMapper;
import com.medici.arang.board.Notice.domain.NoticeVo;
import com.medici.arang.board.Notice.domain.PagingRowMapper;
import com.medici.arang.board.Notice.domain.PagingVo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoticeDao {
	private JdbcTemplate jdbcTemplate;
	
	public NoticeDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	public long insertNotice(NoticeVo noticeVo) {
		String sql = " INSERT INTO notice (num, title, content, readCnt) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, noticeVo.getNum(), noticeVo.getTitle(), noticeVo.getContent(), noticeVo.getReadCnt());
	}
	public long updateNotice(NoticeVo noticeVo, long num) {
		String sql = "UPDATE notice SET num = ?, title = ?, content = ? WHERE num = ?";
		return jdbcTemplate.update(sql, noticeVo.getNum(), noticeVo.getTitle(), noticeVo.getContent(), num);
	}
	public long deleteNotice(long num) {
		String sql = "DELETE FROM notice WHERE num = ?";
		return jdbcTemplate.update(sql, num);
	}
	public List<NoticeVo> findAllNotice(){
		String sql = "SELECT * FROM notice";
		return jdbcTemplate.query(sql, new NoticeRowMapper());
	}
	public NoticeVo findOneNotice(long num) {
		readCnt(num);
		String sql = "SELECT * FROM notice WHERE num = ?";
		return jdbcTemplate.queryForObject(sql, new NoticeRowMapper(), num);
	}
	public int readCnt(long num) {
		String sql = "UPDATE notice SET readCnt = readCnt + 1 WHERE num = ?";
		return jdbcTemplate.update(sql, num);
	}
	
	public List<NoticeVo> paging(long num){
		String sql = "select * from (select * from notice order by num = ? desc) as rownum_table limit ${start}, ${End}";
		return jdbcTemplate.query(sql, new NoticeRowMapper(), num);
	}
	public NoticeVo getCount(NoticeVo noticeVo) {
		String sql = "select * from (select count(*) from notice) notice";
		return jdbcTemplate.queryForObject(sql, new NoticeRowMapper());
	}
}
