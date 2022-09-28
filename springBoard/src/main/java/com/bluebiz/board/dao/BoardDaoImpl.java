package com.bluebiz.board.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluebiz.board.domain.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.bluebiz.board.mapper.boardMapper.";

	@Override
	public int insert(BoardDto boardDto) throws Exception {
		return session.insert(namespace+"insert", boardDto);
	}

	@Override
	public int update(BoardDto boardDto) throws Exception {
		return session.update(namespace+"update", boardDto);
	}

	@Override
	public int delete(Integer bnum) throws Exception {
		return session.delete(namespace+"delete", bnum);
	}

	@Override
	public List<BoardDto> selectAll() throws Exception {
		return session.selectList(namespace+"selectAll");
	}

	@Override
	public List<BoardDto> selectOne(Integer bnum) throws Exception {
		return session.selectList(namespace+"selectOne", bnum);
	}

	@Override
	public int count(Integer bnum) throws Exception {
		return session.update(namespace+"count", bnum);
	}

	@Override
	public int readCnt(Integer bnum) throws Exception {
		return session.update(namespace+"readCnt", bnum);
	}
}
