package com.medici.arang.board.gallery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.gallery.domain.GalleryVo;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;

@Controller("board.gallery.controller.GallerydeleteController")
public class GalleryDeleteController {
	private GalleryServiceImpl galleryServiceImpl;
	
	public GalleryDeleteController(GalleryServiceImpl galleryServiceImpl) {
		this.galleryServiceImpl = galleryServiceImpl;
	}
	
	@GetMapping("gallery/DeleteGalleryForm")
	public String insertGallery(GalleryVo galleryVo, HttpServletRequest request, Model model, HttpSession session) {
		
		model.addAttribute("GalleryVo", galleryVo);
		return "gallery/DeleteGalleryForm";
	}
	
	@PostMapping("gallery/DeleteGalleryForm")
	public String insertGalleryForm(GalleryVo galleryVo, HttpServletRequest request, Model model) {
		long code = Long.parseLong(request.getParameter("code"));
		request.setAttribute("code", code);
		
		long galleryDelete = galleryServiceImpl.deleteGallery(code);
		request.setAttribute("galleryDelete", galleryDelete);
		
		model.addAttribute("GalleryVo", galleryVo);
		return "gallery/mainForm";
	} 
}
