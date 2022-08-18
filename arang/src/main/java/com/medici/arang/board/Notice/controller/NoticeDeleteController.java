package com.medici.arang.board.Notice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.Notice.domain.NoticeVo;
import com.medici.arang.board.Notice.service.NoticeServiceImpl;

@Controller("board.Notice.controller.NoticeDeleteController")
public class NoticeDeleteController {
	private NoticeServiceImpl noticeServiceImpl;
	
	public NoticeDeleteController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
	@GetMapping("notice/DeleteNoticeForm")
	public String deleteNotice(@ModelAttribute NoticeVo noticeVo) {
		return "notice/DeleteNoticeForm";
	}
	@PostMapping("notice/DeleteNoticeForm")
	public String deleteNoticeForm(@ModelAttribute NoticeVo noticeVo, HttpServletRequest request, Model model) {
		long delete = Long.parseLong(request.getParameter("num"));
		request.setAttribute("delete", delete);
		
		long deleteNotice = noticeServiceImpl.deleteNotice(delete);
		request.setAttribute("deleteNotice", deleteNotice);
		
		model.addAttribute("noticeVo", noticeVo);
		return "notice/mainForm";
	}
}
