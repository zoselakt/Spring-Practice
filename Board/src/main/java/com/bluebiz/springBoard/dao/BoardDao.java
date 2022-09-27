package com.bluebiz.springBoard.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluebiz.springBoard.command.BoardCommand;
import com.bluebiz.springBoard.domain.BoardDto;
import com.bluebiz.springBoard.domain.BoardRowMapper;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class BoardDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BoardDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public long insert (BoardDto boardDto) {
		String sql = "insert into board (title, writer, content) values(?,?,?)";
		return jdbcTemplate.update(sql, boardDto.getTitle(), boardDto.getWriter(), boardDto.getContent());
	}
	
	public long update(BoardDto boardDto, long bnum) {
		String sql = "update board set title = ?, writer = ?, content = ? where bnum = ?";
		return jdbcTemplate.update(sql, boardDto.getTitle(), boardDto.getWriter(), boardDto.getContent(), bnum);
	}
	public long delete(long bnum) {
		String sql = "delete from board where bnum = ? ";
		return jdbcTemplate.update(sql, bnum);
	}
	
	public List<BoardDto> selectAll(){
		String sql = "select * from board";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
	public BoardDto selectOne(long bnum) {
		String sql = "select * from board where bnum = ?";
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper(), bnum);
	}
	public long BoardCount() {
		String sql = "select count(*) from board";
		return jdbcTemplate.update(sql);
	}
}
