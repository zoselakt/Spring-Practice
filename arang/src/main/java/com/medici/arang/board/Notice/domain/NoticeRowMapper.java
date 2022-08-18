package com.medici.arang.board.Notice.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NoticeRowMapper implements RowMapper<NoticeVo> {

	@Override
	public NoticeVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoticeVo vo = new NoticeVo();
		vo.setNum(rs.getLong("num"));
		vo.setTitle(rs.getString("title"));
//		vo.setWriter(rs.getString("writer"));
		vo.setContent(rs.getString("content"));
		vo.setReadCnt(rs.getInt("readCnt"));
		vo.setRegDate(rs.getTimestamp("regDate"));
		return vo;
	}
}