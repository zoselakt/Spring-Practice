package com.medici.arang.board.gallery.controller.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.command.GalleryInfoCommand;
import com.medici.arang.board.gallery.service.GalleryInfoServiceImpl;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;

@Controller("galleryDeleteController")
public class GalleryDeleteController {
	@Autowired
	private GalleryServiceImpl galleryServiceImpl;
	
	@Autowired
	private GalleryInfoServiceImpl galleryInfoServiceImpl;
	
	@GetMapping("gallery/gallery_delete")
	public String gallerydeleteGet(@ModelAttribute GalleryCommand galleryCommand, Model model) {
		model.addAttribute("galleryCommand",galleryCommand);
		return "gallery/gallery_delete";
	}
	
	@PostMapping("gallery/gallery_delete")
	public String gallerydeletePost(@ModelAttribute GalleryCommand galleryCommand, GalleryInfoCommand galleryInfoCommand, 
			Model model, HttpServletRequest request) {
		long getGalleryCode = galleryInfoCommand.getGalleryCode(); 
		long galleryInfoDelete = galleryInfoServiceImpl.deleteGalleryInfo(getGalleryCode);
		
		long getLong = galleryCommand.getCode(); 
		long galleryDelete = galleryServiceImpl.deleteGallery(getLong);
		
		request.setAttribute("galleryDelete", galleryDelete);
		model.addAttribute("galleryCommand", galleryCommand);
		model.addAttribute("galleryInfoDelete", galleryInfoDelete);
		model.addAttribute("galleryDelete", galleryDelete);
		return "redirect:gallery";
	}
}
