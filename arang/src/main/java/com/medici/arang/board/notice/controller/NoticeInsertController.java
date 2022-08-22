package com.medici.arang.board.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.service.NoticeServiceImpl;

@Controller("noticeInsertController")
public class NoticeInsertController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@GetMapping("notice/insertNoticeForm")
	public String insertForm(@ModelAttribute NoticeCommand command, Model model) {
		model.addAttribute("command",command);
		return "notice/insertNoticeForm";
	}
}
