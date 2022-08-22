package com.medici.arang.board.artist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medici.arang.board.artist.command.ArtworkCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.artist.command.FindArtworkInfoCommand;
import com.medici.arang.board.artist.service.ArtistInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkInfoServiceImpl;
import com.medici.arang.board.artist.service.ArtworkServiceImpl;
import com.medici.arang.user.service.ArtistServiceImpl;


@Controller
public class ArtworkInfoController {
	
	@Autowired
	public ArtworkServiceImpl artworkService;
	
	@Autowired
	public ArtistServiceImpl artistservice;
	
	@Autowired
	public ArtistInfoServiceImpl artistInfoService;
	
	@Autowired
	public  ArtworkInfoServiceImpl artworkInfoService;
	
	//	작품추가 페이지FORM
	@GetMapping("/artwork_board/artwork_info")
	public String artworkForm(@RequestParam("id") long id, 
								@RequestParam("wid") long wid, Model model) {
		System.out.println(id);
		System.out.println(wid);
		FindArtistInfoCommand artistInfo = artistInfoService.findArtistInfo(id);
		List<ArtworkCommand> artworkList = artworkService.allfindArtwork(id);
		FindArtworkInfoCommand artworkInfo = artworkInfoService.findArtworkInfo(wid);
		
		model.addAttribute("artistInfo", artistInfo);
		model.addAttribute("artworkList", artworkList);
		model.addAttribute("artworkInfo", artworkInfo);
		
		return "artwork_board/artwork_info";
	}
	
	
	
}

