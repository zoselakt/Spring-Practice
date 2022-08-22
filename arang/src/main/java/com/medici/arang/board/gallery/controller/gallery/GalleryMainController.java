package com.medici.arang.board.gallery.controller.gallery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.board.gallery.service.GalleryInfoServiceImpl;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;
import com.medici.arang.user.command.ArtistPageCommand;

@Controller
public class GalleryMainController {
	
	@Autowired
	GalleryInfoServiceImpl galleryInfoService;
	
	@Autowired
	GalleryServiceImpl galleryService;
	
	@GetMapping("/gallery/gallery")
	public String Gallery(Model model, HttpServletRequest request) {
		List<GalleryPageCommand> galleryList = galleryInfoService.allFindGallery();
		
		for (GalleryPageCommand galleryCommand : galleryList) {
			String a = galleryCommand.getInfoImgPath();
			String[] b =  a.split(";");
			String c = b[0];
			galleryCommand.setInfoImgPath(c);
		}
		
		long galleryCount = galleryService.getGalleryCount();
		
		model.addAttribute("galleryCount", galleryCount);
		model.addAttribute("galleryList", galleryList);
		
		// 페이징
		int page = 0;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));			
		}
		//페이징
		Pageable pageable = PageRequest.of(page, 1, Sort.Direction.DESC, "code");
		Page<GalleryPageCommand> galleryPagingList = 
				galleryInfoService.allFindGalleryPage(pageable);
		
		//현재페이지
		int pageNumber = galleryPagingList.getPageable().getPageNumber();
		//총 페이지수
		int totalPages = galleryPagingList.getTotalPages();
		//블럭의 수
		int pageBlock = 5;
		//현재 페이지가 7이라면 1*5+1=6
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1;
		//6+5-1=10. 6,7,8,9,10해서 10.
		int endBlockPage = startBlockPage+pageBlock-1;
		endBlockPage= totalPages<endBlockPage? totalPages:endBlockPage;
		
		for (GalleryPageCommand galleryCommand : galleryPagingList) {
			String a = galleryCommand.getInfoImgPath();
			String[] b =  a.split(";");
			String c = b[0];
			galleryCommand.setInfoImgPath(c);
		}
		
		
		
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("galleryPagingList", galleryPagingList);
		
		return "gallery/gallery";
	}
	
	@GetMapping("/gallery/gallery_focus")
	public String GalleryInfoForm(@RequestParam("code") long code, Model model) {
		GalleryPageCommand galleryCommand = galleryInfoService.findGalleryByID(code);
		model.addAttribute("galleryCommand", galleryCommand);
		
		return "gallery/gallery_focus";
	}
	
}
