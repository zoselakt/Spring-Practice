package com.bluebiz.springBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bluebiz.springBoard.command.BoardCommand;
import com.bluebiz.springBoard.service.BoardServiceImpl;

@Controller("boardSelectController")
public class BoardSelectController {
	private BoardServiceImpl boardServiceImpl;
	
	@Autowired
	public BoardSelectController(BoardServiceImpl boardServiceImpl) {
		this.boardServiceImpl = boardServiceImpl;
	}
	
	@GetMapping("board/mainBoard")
	public String selectAll(@ModelAttribute BoardCommand boardCommand, Model model) {
		model.addAttribute("boardCommand", boardCommand);
		return "board/mainBoard";
	}
	@GetMapping("board/detailBoard")
	public String selectOne(@ModelAttribute BoardCommand boardCommand, Model model) {
		model.addAttribute("boardCommand", boardCommand);
		return "board/detailBoard";
	}
}
