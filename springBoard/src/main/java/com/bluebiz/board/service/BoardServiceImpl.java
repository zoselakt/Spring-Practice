package com.bluebiz.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebiz.board.dao.BoardDao;
import com.bluebiz.board.domain.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao boardDao;

	@Override
	public int insert(BoardDto boardDto) throws Exception {
		return boardDao.insert(boardDto);
	}

	@Override
	public int update(BoardDto boardDto) throws Exception {
		return boardDao.update(boardDto);
	}

	@Override
	public int delete(Integer bnum) throws Exception {
		return boardDao.delete(bnum);
	}

	@Override
	public List<BoardDto> selectAll() throws Exception {
		return boardDao.selectAll();
	}

	@Override
	public List<BoardDto> selectOne(Integer bnum) throws Exception {
		readCnt(bnum);
		return boardDao.selectOne(bnum);
	}

	@Override
	public int count(Integer bnum) throws Exception {
		return boardDao.count(bnum);
	}

	@Override
	public int readCnt(Integer bnum) throws Exception {
		return boardDao.readCnt(bnum);
	}
}
