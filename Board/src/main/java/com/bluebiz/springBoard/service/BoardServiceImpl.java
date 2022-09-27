package com.bluebiz.springBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bluebiz.springBoard.dao.BoardDao;
import com.bluebiz.springBoard.domain.BoardDto;

public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDao dao;
	
	@Override
	public long insert(BoardDto command) {
		return dao.insert(command);
	}

	@Override
	public long update(BoardDto command, long bnum) {
		return dao.update(command, bnum);
	}

	@Override
	public long delete(long bnum) {
		return dao.delete(bnum);
	}

	@Override
	public List<BoardDto> selectAll() {
		return dao.selectAll();
	}

	@Override
	public BoardDto selectOne(long bnum) {
		return dao.selectOne(bnum);
	}

	@Override
	public long BoardCount() {
		return dao.BoardCount();
	}

}
