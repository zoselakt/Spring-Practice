package com.medici.arang.board.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.service.NoticeServiceImpl;

@Controller("noticeInsertController")
public class NoticeInsertController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeInsertController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
	@GetMapping("notice/insertNoticeForm")
	public String insertGet(@ModelAttribute NoticeCommand noticeCommand, Model model) {
		model.addAttribute("noticeCommand", noticeCommand);
		return "notice/insertNoticeForm";
	}
	
	@PostMapping("notice/insertNoticeForm")
	public String insertPost(@ModelAttribute NoticeCommand noticeCommand, 
			Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String adminIdentified = (String) session.getAttribute("email");
		System.out.println(adminIdentified);
		noticeCommand.setWriter(adminIdentified);
		
		noticeServiceImpl.insertNotice(noticeCommand);
		
		model.addAttribute("noticeCommand", noticeCommand);
		return "redirect:notice";
	}
}
