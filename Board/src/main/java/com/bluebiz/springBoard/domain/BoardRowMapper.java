package com.bluebiz.springBoard.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bluebiz.springBoard.command.BoardCommand;

public class BoardRowMapper implements RowMapper<BoardDto> {

	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBnum(rs.getLong("bnum"));
		boardDto.setTitle(rs.getNString("title"));
		boardDto.setWriter(rs.getNString("title"));
		boardDto.setContent(rs.getNString("title"));
		boardDto.setRegDate(rs.getTimestamp("regDate"));
		return boardDto;
	}
}
