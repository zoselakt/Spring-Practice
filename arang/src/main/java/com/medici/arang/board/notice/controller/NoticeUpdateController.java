package com.medici.arang.board.notice.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String updateGet(@ModelAttribute NoticeCommand noticeCommand, Model model,
			HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		String getEmail = (String) session.getAttribute("email");
//		String adminIdentified = (String) session.getAttribute("writer");
//		command.setWriter(adminIdentified);
		
		model.addAttribute("noticeCommand", noticeCommand);
		return "notice/updateNoticeForm";
	}
	@PostMapping("notice/updateNoticeForm")
	public String updatePost(@ModelAttribute NoticeCommand noticeCommand, Model model,
			HttpServletRequest request) {
		long getLong = noticeCommand.getNum(); 
		long noticeUpdate = noticeServiceImpl.updateNotice(noticeCommand, getLong);

		request.setAttribute("noticeUpdate", noticeUpdate);
		model.addAttribute("noticeCommand", noticeCommand);
		return "redirect:notice";
	}
}
