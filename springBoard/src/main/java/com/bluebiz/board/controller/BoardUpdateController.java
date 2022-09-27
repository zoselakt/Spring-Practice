package com.bluebiz.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bluebiz.board.domain.BoardDto;
import com.bluebiz.board.service.BoardService;

@Controller("boardUpdateController")
public class BoardUpdateController {
	private BoardService boardService;
	
	@Autowired
	public BoardUpdateController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("updateBoard")
	public String update(Model model, @ModelAttribute BoardDto boardDto, @RequestParam int bnum ) throws Exception {
		List<BoardDto> selectOne = boardService.selectOne(bnum);
		
		model.addAttribute("boardDto", boardDto);
		model.addAttribute("selectOne", selectOne);
		
		return "updateBoard";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Model model, @ModelAttribute BoardDto boardDto) throws Exception {
		boardService.update(boardDto);
		
		model.addAttribute("boardDto", boardDto);
		
		return "redirect:mainBoard";
	}
}
