package com.bluebiz.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bluebiz.board.domain.BoardDto;
import com.bluebiz.board.service.BoardService;

@Controller("boardDeleteController")
public class BoardDeleteController {
	private BoardService boardService;
	
	@Autowired
	public BoardDeleteController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("deleteBoard")
	public String delete(Model model, BoardDto boardDto) {
		model.addAttribute("boardDto", boardDto);
		return "deleteBoard";
	}
	
	@PostMapping("deleteBoard")
	public String deleteBoard(Model model, BoardDto boardDto, 
			@RequestParam int bnum) throws Exception {
		
		model.addAttribute("boardDto", boardDto);
		
		boardService.delete(bnum);
		
		return "redirect:mainBoard";
	}
}
