package com.bluebiz.springBoard.service;

import java.util.List;

import com.bluebiz.springBoard.command.BoardCommand;
import com.bluebiz.springBoard.domain.BoardDto;

public interface BoardService {
	public long insert (BoardDto command);
	public long update(BoardDto command, long bnum);
	public long delete(long bnum);
	public List<BoardDto> selectAll();
	public BoardDto selectOne(long bnum);
	public long BoardCount();
}
