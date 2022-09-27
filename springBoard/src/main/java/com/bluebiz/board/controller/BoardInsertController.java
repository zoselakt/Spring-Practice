package com.bluebiz.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bluebiz.board.domain.BoardDto;
import com.bluebiz.board.service.BoardService;

@Controller("boardInsertController")
public class BoardInsertController {
	private BoardService boardService;
	
	@Autowired
	public BoardInsertController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("insertBoard")
	public String insert(Model model, @ModelAttribute BoardDto boardDto) {
		model.addAttribute("boardDto", boardDto);
		return "insertBoard";
	}
	
	@PostMapping("insertBoard")
	public String insertBoard(Model model, @ModelAttribute BoardDto boardDto) throws Exception {
		model.addAttribute("boardDto", boardDto);
		boardService.insert(boardDto);
		return "redirect:mainBoard";
	}
}
