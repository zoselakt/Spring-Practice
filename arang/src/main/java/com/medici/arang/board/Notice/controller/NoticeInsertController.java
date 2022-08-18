package com.medici.arang.board.Notice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.Notice.domain.NoticeVo;
import com.medici.arang.board.Notice.service.NoticeServiceImpl;

@Controller("board.Notice.controller.NoticeInsertController")
public class NoticeInsertController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeInsertController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
	@GetMapping("notice/InsertNoticeForm")
	public String insertNotice(@ModelAttribute NoticeVo noticeVo) {
		return "notice/InsertNoticeForm";
	}
	
	@PostMapping("notice/InsertNoticeForm")
	public String insertNoticeForm(@ModelAttribute NoticeVo noticeVo, HttpServletRequest request, Model model) {
		long noticeInsert = noticeServiceImpl.insertNotice(noticeVo);
		request.setAttribute("noticeInsert", noticeInsert);
		
		model.addAttribute("noticeVo", noticeVo);
		return "notice/mainForm";
	}
}
