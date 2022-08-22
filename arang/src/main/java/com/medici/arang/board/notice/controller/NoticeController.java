package com.medici.arang.board.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.service.NoticeServiceImpl;

@Controller("noticeController")
public class NoticeController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@GetMapping("notice/notice")
	public String noticeAllFind(NoticeCommand command, Model model) {
		//noticeServiceImpl.findAllNotice();
		model.addAttribute("command", command);
		return "notice/notice";
	}
	@GetMapping("notice/findOnenoticeForm")
	public String noticeOneFind(NoticeCommand command, Model model) {
		//noticeServiceImpl.findAllNotice();
		model.addAttribute("command", command);
		return "notice/findOnenoticeForm";
	}
}
