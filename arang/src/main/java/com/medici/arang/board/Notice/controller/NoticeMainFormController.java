package com.medici.arang.board.Notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.Notice.domain.NoticeVo;
import com.medici.arang.board.Notice.service.NoticeServiceImpl;
import com.medici.arang.board.gallery.domain.GalleryVo;

@Controller("board.gallery.controller.NoticeMainFormController")
public class NoticeMainFormController {
private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeMainFormController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}	
	
	@GetMapping("notice/mainForm")
	public String insertGallery(@ModelAttribute NoticeVo noticeVo) {
		return "notice/mainForm";
	}
	
	@PostMapping("notice/mainForm")
	public String insertGalleryForm(@ModelAttribute NoticeVo noticeVo) {
		return "notice/mainForm";
	}
}
