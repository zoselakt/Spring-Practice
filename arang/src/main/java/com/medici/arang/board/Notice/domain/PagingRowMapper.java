package com.medici.arang.board.Notice.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

public class PagingRowMapper implements RowMapper<PagingVo> {

	@Override
	public PagingVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		PagingVo vo = new PagingVo();
		vo.setCurrentPage(rs.getInt("currentPage"));
		vo.setStartPage(rs.getInt("startPage"));
		vo.setEndPage(rs.getInt("endPage"));
		vo.setTotalPage(rs.getInt("totalPage"));
		vo.setPageCount(rs.getInt("pageCount"));
		vo.setStartBlock(rs.getInt("startBlock"));
		vo.setEndBlock(rs.getInt("endBlock"));
		vo.setStart(rs.getInt("start"));
		vo.setEnd(rs.getInt("End"));
		return vo;
	}
}
