package com.medici.arang.board.gallery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.gallery.domain.GalleryVo;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;

@Controller("board.gallery.controller.GalleryMainFormController")
public class GalleryMainFormController {
private GalleryServiceImpl galleryServiceImpl;
	
	@Autowired
	public GalleryMainFormController(GalleryServiceImpl galleryServiceImpl) {
		this.galleryServiceImpl = galleryServiceImpl;
	}	
	
	@GetMapping("gallery/mainForm")
	public String insertGallery(GalleryVo galleryVo, HttpServletRequest request, Model model, HttpSession session) {
		
		model.addAttribute("GalleryVo", galleryVo);
		return "gallery/mainForm";
	}
	
	@PostMapping("gallery/mainForm")
	public String insertGalleryForm(GalleryVo galleryVo, HttpServletRequest request, Model model) {
		
		model.addAttribute("GalleryVo", galleryVo);
		return "gallery/mainForm";
	}
}