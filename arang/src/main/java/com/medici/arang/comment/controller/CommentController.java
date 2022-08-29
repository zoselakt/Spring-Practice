package com.medici.arang.comment.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.service.NoticeServiceImpl;
import com.medici.arang.comment.command.CommentCommand;
import com.medici.arang.comment.service.CommentServiceImpl;

@Controller("commentController")
public class CommentController {
	private CommentServiceImpl commentServiceImpl;
	
	@Autowired
	public CommentController(CommentServiceImpl commentServiceImpl) {
		this.commentServiceImpl = commentServiceImpl;
	}
	
	@GetMapping("comment/comment")
	public String commentGet(CommentCommand CommentCommand, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String getSession = (String) session.getAttribute("email");
		CommentCommand.setComment_id(getSession);
		
		
		model.addAttribute("CommentCommand", CommentCommand);
		return "comment/comment";
	}
	
	@PostMapping("comment/comment")
	public String noticeOnePost(Model model, CommentCommand commentCommand, 
			@RequestParam long num) {
		long commentInsert = commentServiceImpl.insertComment(commentCommand);
		
		model.addAttribute("commentCommand", commentCommand);
		model.addAttribute("commentInsert", commentInsert);
		return "notice/findOneNoticeForm";
	}	
	
}
