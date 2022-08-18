package com.medici.arang.board.Notice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.Notice.domain.NoticeVo;
import com.medici.arang.board.Notice.service.NoticeServiceImpl;

@Controller("board.Notice.controller.NoticeUpdateController")
public class NoticeUpdateController {
	private NoticeServiceImpl noticeServiceImpl;
	
	public NoticeUpdateController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	@GetMapping("notice/UpdateNoticeForm")
	public String updateNotice(@ModelAttribute NoticeVo noticeVo) {
		return "notice/UpdateNoticeForm";
	}
	@PostMapping("notice/UpdateNoticeForm")
	public String updateNoticeForm(@ModelAttribute NoticeVo noticeVo, HttpServletRequest request, Model model) {
		long update = Long.parseLong(request.getParameter("num"));
		request.setAttribute("update", update);
		
		long updateNotice = noticeServiceImpl.updateNotice(noticeVo, update);
		request.setAttribute("updateNotice", updateNotice);
		
		model.addAttribute("noticeVo", noticeVo);
		return "notice/mainForm";
	}
}
