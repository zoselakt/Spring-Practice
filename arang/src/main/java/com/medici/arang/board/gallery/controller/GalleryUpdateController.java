package com.medici.arang.board.gallery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.dao.GalleryDao;
import com.medici.arang.board.gallery.domain.GalleryVo;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;

@Controller("board.gallery.controller.GalleryUpdateController")
public class GalleryUpdateController {
	private GalleryServiceImpl galleryServiceImpl;
	
	public GalleryUpdateController(GalleryServiceImpl galleryServiceImpl) {
		this.galleryServiceImpl = galleryServiceImpl;
	}
	
	@GetMapping("gallery/UpdateGalleryForm")
	public String updateGallery(@ModelAttribute("GalleryVo") GalleryVo galleryVo) {
		return "gallery/UpdateGalleryForm";
	}
	
	@PostMapping("gallery/UpdateGalleryForm")
	public String updateGalleryForm(@ModelAttribute("GalleryVo")GalleryVo galleryVo, HttpServletRequest request) {
		long code = Long.parseLong(request.getParameter("code"));
		request.setAttribute("code", code);
		
		long galleryUpdate = galleryServiceImpl.updateGallery(galleryVo, code);
		request.setAttribute("galleryUpdate", galleryUpdate);
		return "gallery/mainForm";
	} 
}
