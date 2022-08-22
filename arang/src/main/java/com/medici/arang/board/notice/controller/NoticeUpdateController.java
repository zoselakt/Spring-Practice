package com.medici.arang.board.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.service.NoticeServiceImpl;

@Controller("noticeUpdateController")
public class NoticeUpdateController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@GetMapping("notice/updateNoticeForm")
	public String updateForm(@ModelAttribute NoticeCommand command, Model model) {
		model.addAttribute("command",command);
		return "notice/updateNoticeForm";
	}
	@GetMapping("notice/deleteNoticeForm")
	public String deleteNoticeForm(@ModelAttribute NoticeCommand command, Model model) {
		model.addAttribute("command",command);
		return "notice/deleteNoticeForm";
	}
}
