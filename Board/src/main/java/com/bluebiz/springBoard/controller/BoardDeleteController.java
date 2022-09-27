package com.bluebiz.springBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bluebiz.springBoard.service.BoardServiceImpl;

@Controller("boardDeleteController")
public class BoardDeleteController {
private BoardServiceImpl boardServiceImpl;
	
	@Autowired
	public BoardDeleteController(BoardServiceImpl boardServiceImpl) {
		this.boardServiceImpl = boardServiceImpl;
	}
}
