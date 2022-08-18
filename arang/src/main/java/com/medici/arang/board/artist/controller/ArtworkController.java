package com.medici.arang.board.artist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@MultipartConfig(
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*50, 		//50메가
	    maxRequestSize = 1024*1024*50*5) 	// 50메가 5개까지
@Controller("controller/artworkController")
public class ArtworkController {
	
	@GetMapping("/pases/add_artwork")
	public String artworkForm() {
		return "pages/add_artwork";
	}
	
	@ModelAttribute("categoryProvicerList")
	public List<String> getCategoryList(){
		List<String> list = new ArrayList<String>();
		list.add("서양화");
		list.add("동양화");
		list.add("유화");
		list.add("조각");
		list.add("설치미술");
		list.add("미디어아트");
		list.add("사진");
		
		return list;
	}
}
