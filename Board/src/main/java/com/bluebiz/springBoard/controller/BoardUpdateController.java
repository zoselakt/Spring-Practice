package com.bluebiz.springBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bluebiz.springBoard.command.BoardCommand;
import com.bluebiz.springBoard.domain.BoardDto;
import com.bluebiz.springBoard.service.BoardServiceImpl;

@Controller("boardUpdateController")
public class BoardUpdateController {
	private BoardServiceImpl boardServiceImpl;
	
	@Autowired
	public BoardUpdateController(BoardServiceImpl boardServiceImpl) {
		this.boardServiceImpl = boardServiceImpl;
	}
	
	@GetMapping("board/updateBoard")
	public String updateGet(@ModelAttribute BoardDto boardDto, Model model) {
		model.addAttribute("boardDto", boardDto);
		return "board/updateBoard";
	}
	@PostMapping("board/updateBoard")
	public String updatePost(@ModelAttribute BoardDto boardDto, Model model) throws Exception {
		model.addAttribute("boardDto", boardDto);
		boardServiceImpl.insert(boardDto);
		return "board/mainBoard";
	}
	
}
