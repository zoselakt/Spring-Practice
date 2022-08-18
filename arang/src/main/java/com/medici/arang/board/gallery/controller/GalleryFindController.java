package com.medici.arang.board.gallery.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.gallery.domain.GalleryVo;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;

@Controller("board.gallery.controller.GalleryFindController")
public class GalleryFindController {
	private GalleryServiceImpl galleryServiceImpl;
	
	public GalleryFindController(GalleryServiceImpl galleryServiceImpl) {
		this.galleryServiceImpl = galleryServiceImpl;
	}
	
	@GetMapping("gallery/FindAllGalleryForm")
	public String GetFindAllGallery(GalleryVo galleryVo, HttpServletRequest request, Model model) {
		List<GalleryVo> galleryFindAll = galleryServiceImpl.findAllGalleryInfo();
		request.setAttribute("galleryFindAll", galleryFindAll);
		
		model.addAttribute("GalleryVo",galleryVo);
		return "gallery/FindAllGalleryForm";
	}
	@GetMapping("gallery/FindOneGalleryForm")
	public String GetFindOneGallery(@ModelAttribute("galleryFindOne")GalleryVo galleryVo, HttpServletRequest request, Model model) {
		long code = Long.parseLong(request.getParameter("code"));
		request.setAttribute("code", code);
		
		GalleryVo galleryFindOne = galleryServiceImpl.findOneGalleryInfo(code);
		request.setAttribute("galleryFindOne", galleryFindOne);
		
		model.addAttribute("galleryFindOne",galleryFindOne);
		return "gallery/FindOneGalleryForm";
	}
	
	
	@PostMapping("gallery/FindAllGalleryForm")
	public String PostFindAllGallery(@ModelAttribute("galleryFindAll") GalleryVo galleryVo, HttpServletRequest request, Model model) {
		List<GalleryVo> galleryFindAll = galleryServiceImpl.findAllGalleryInfo();
		request.setAttribute("GalleryFindAll", galleryFindAll);
		
		return "gallery/mainForm";
	} 
	
	@PostMapping("gallery/FindOneGalleryForm")
	public String PostFindOneGallery(@ModelAttribute("galleryFindOne") GalleryVo galleryVo, HttpServletRequest request, Model model) {
		long code = Long.parseLong(request.getParameter("code"));
		request.setAttribute("code", code);
		
		GalleryVo galleryFindOne = galleryServiceImpl.findOneGalleryInfo(code);
		request.setAttribute("galleryFindOne", galleryFindOne);
		return "gallery/mainForm";
	} 
}
