package com.medici.arang.board.gallery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.gallery.domain.GalleryVo;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;

@Controller("board.gallery.controller.GalleryInsertController")
public class GalleryInsertController {
	private GalleryServiceImpl galleryServiceImpl;
	
	@Autowired
	public GalleryInsertController(GalleryServiceImpl galleryServiceImpl) {
		this.galleryServiceImpl = galleryServiceImpl;
	}	
	
	@GetMapping("gallery/InsertGalleryForm")
	public String insertGallery(@ModelAttribute("GalleryVo") GalleryVo galleryVo) {
		return "gallery/InsertGalleryForm";
	}
	
	@PostMapping("gallery/InsertGalleryForm")
	public String insertGalleryForm(GalleryVo galleryVo, HttpServletRequest request, Model model) {
		long galleryInsert = galleryServiceImpl.insertGallery(galleryVo);
		request.setAttribute("galleryInsert", galleryInsert);
		
		model.addAttribute("GalleryVo", galleryVo);
//		galleryServiceImpl.insertGallery(galleryVo);
		return "gallery/mainForm";
	}
}
