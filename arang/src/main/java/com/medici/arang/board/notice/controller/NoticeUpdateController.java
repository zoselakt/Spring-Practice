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

@Controller("noticeUpdateController")
public class NoticeUpdateController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeUpdateController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
	@GetMapping("notice/updateNoticeForm")
	public String updateGet(@ModelAttribute NoticeCommand command, Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		//String getEmail = (String) session.getAttribute("email");
		
		String title = (String) session.getAttribute("title");
		String adminIdentified = (String) session.getAttribute("writer");
		String content = (String) session.getAttribute("content");
		
		command.setTitle(title);
		command.setWriter(adminIdentified);
		command.setContent(content);
		
		model.addAttribute("command", command);
		return "notice/updateNoticeForm";
	}
	@PostMapping("notice/updateNoticeForm")
	public String updatePost(@ModelAttribute NoticeCommand command, Model model,
			HttpServletRequest request) {
		long getLong = command.getNum(); 
		long noticeUpdate = noticeServiceImpl.updateNotice(command, getLong);
		
		request.setAttribute("noticeUpdate", noticeUpdate);
		model.addAttribute("command", command);
		return "redirect:notice";
	}
}
