package com.medici.arang.board.Notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medici.arang.board.Notice.domain.NoticeVo;
import com.medici.arang.board.Notice.domain.PagingVo;
import com.medici.arang.board.Notice.service.NoticeServiceImpl;

@Controller("board.Notice.controller.NoticeFindController")
public class NoticeFindController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeFindController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	/*
	@GetMapping("notice/FindAllNoticeForm")
	public String findAll(@ModelAttribute NoticeVo noticeVo, HttpServletRequest request, Model model) {	
		List<NoticeVo> noticeFindAll = noticeServiceImpl.findAllNotice();
		request.setAttribute("noticeFindAll", noticeFindAll);
		
		model.addAttribute("noticeFindAll",noticeFindAll);
		return "notice/FindAllNoticeForm";
	}
	*/
	@GetMapping("notice/FindOneNoticeForm")
	public String findOne(@ModelAttribute NoticeVo noticeVo, HttpServletRequest request, Model model) {
		long findOne = Long.parseLong(request.getParameter("num"));
		request.setAttribute("findOne", findOne);
		
		NoticeVo noticeFindOne = noticeServiceImpl.findOneNotice(findOne);
		request.setAttribute("noticeFindOne", noticeFindOne);
		
		model.addAttribute("noticeVo", noticeVo);
		return "notice/FindOneNoticeForm";
	}
	//-----------------------------------------------------------------------
	@GetMapping("notice/FindAllNoticeForm")
	public String paging(@ModelAttribute PagingVo pagingVo, Model model,
				@ModelAttribute NoticeVo noticeVo, HttpServletRequest request
			, @RequestParam(value = "currentPage", required=false) String currentPage
			, @RequestParam(value = "pageCount", required=false) String pageCount
			, @RequestParam(value = "num") long num)	{
		List<NoticeVo> paging = noticeServiceImpl.paging(num);
	
		//게시글 카운트
		NoticeVo totalCount = noticeServiceImpl.getCount(noticeVo); // 게시글 카운트
		int total = Integer.parseInt(totalCount.toString()); // 객체타입 형변환
		if(currentPage == null && pageCount == null) {
			currentPage = "1";
			pageCount = "5";
		}else if (currentPage == null) {
			currentPage = "1";
		}else if (pageCount == null) {
			pageCount = "5";
		}
		pagingVo = new PagingVo(total, Integer.parseInt(currentPage), Integer.parseInt(pageCount));
		request.setAttribute("pagingVo", pagingVo);
		request.setAttribute("noticeFindAll", paging);
		
		model.addAttribute("pagingVo", pagingVo);
		model.addAttribute("noticeFindAll", paging);
		return "notice/FindAllNoticeForm";
	}
	//----------------------------------------------------------------------
	@PostMapping("notice/FindAllNoticeForm")
	public String findAllNotice(@ModelAttribute NoticeVo noticeVo,HttpServletRequest request, Model model) {
		List<NoticeVo> noticeFindAll = noticeServiceImpl.findAllNotice();
		request.setAttribute("noticeFindAll", noticeFindAll);
		
		model.addAttribute("noticeVo",noticeVo);
		return "notice/mainForm";
	}
	@PostMapping("notice/FindOneNoticeForm")
	public String findOneNotice(@ModelAttribute NoticeVo noticeVo,HttpServletRequest request, Model model) {
		long findOne = Long.parseLong(request.getParameter("num"));
		request.setAttribute("findOne", findOne);
		
		NoticeVo noticeFindOne = noticeServiceImpl.findOneNotice(findOne);
		request.setAttribute("noticeFindOne", noticeFindOne);
		
		model.addAttribute("noticeVo", noticeVo);
		return "notice/mainForm";
	}
}
