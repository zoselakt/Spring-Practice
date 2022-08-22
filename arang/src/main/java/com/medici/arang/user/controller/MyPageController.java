package com.medici.arang.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.service.ArtistServiceImpl;

@Controller("controller.myPageController")
public class MyPageController {
	
	@Autowired
	ArtistServiceImpl artistService;
	
	@GetMapping("/mypage/mypage_artist")
	public String mypageForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		ArtistCommand artist = artistService.getArtistByEmail(email);
		
		// 주민번호 처리 코드
		String ssn = artist.getSsn();
		String testone = ssn.substring(0, 8);
		System.out.println(testone);
		testone += "******";
		System.out.println(testone);
		request.setAttribute("ssn", testone);
		
		// 커리어 처리 코드
		String[] careerList = artist.getCareer().split(";");
		request.setAttribute("careerList", careerList);
		
		request.setAttribute("artist", artist);
		
		return "mypage/mypage_artist";		
		
	}
	
	
	
	@GetMapping("/mypage/mypage_artist_modify")
	public String mypageUpdateForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		ArtistCommand artist = artistService.getArtistByEmail(email);
		request.setAttribute("artist", artist);
		
		// 주민번호 처리코드
		String ssn = artist.getSsn();
		String testone = ssn.substring(0, 8);
		System.out.println(testone);
		testone += "******";
		System.out.println(testone);
		request.setAttribute("ssn", testone);
		
		// 커리어 처리 코드
		String[] careerList = artist.getCareer().split(";");
		request.setAttribute("careerList", careerList);
		
		
		return "mypage/mypage_artist_modify";
	}
	
	
	private static final String SAVE_DIR = "C:\\JavaYoung\\JavaStudy\\eclipse-workspace\\arang\\src\\main\\webapp\\resources\\img\\";
	private static final String PATH_DIR = "/upload_img/";
	
	@PostMapping("/mypage/mypage_artist_modify")
	public String mypageUpdate(ArtistCommand inputArtsit, @RequestParam("imgFile") 
								MultipartFile file, HttpServletRequest request,
								Model model) {
		
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드
		long size = file.getSize(); //파일 사이즈
		
		System.out.println("파일명 : "  + fileRealName);
		System.out.println("용량크기(byte) : " + size);
		
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유문자열" + uniqueName);
		System.out.println("확장자명" + fileExtension);
		String forderName = inputArtsit.getName_eng();
		
		String path = SAVE_DIR + "artist\\" + forderName; //폴더 경로
		File Folder = new File(path);
		
		System.out.println(path);
		
		File saveFile = new File(SAVE_DIR + "artist/" + forderName + "/" + uniqueName + fileExtension);  // 적용 후
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		inputArtsit.setImgPath(PATH_DIR + "artist/" + forderName + "/" + uniqueName+fileExtension);
		String imgName = inputArtsit.getImgPath();
		System.out.println(imgName);
		String oriImg = request.getParameter("oriImg");
		inputArtsit.setImgPath(oriImg);
		System.out.println(inputArtsit.getPasswd());
		System.out.println(inputArtsit.getPhone());
		
		model.addAttribute("artist", inputArtsit);
		String ssn = request.getParameter("ssn");
		model.addAttribute("ssn", ssn);
		
		return "mypage/mypage_artist";
	}
	
	
	@PostMapping("/user/find_all_user")
	public String findForm(HttpServletRequest request) {
		
		List<ArtistCommand> artistList = artistService.getAllArtist();
		request.setAttribute("artistList", artistList);
		
		return "user/find_all_user";
	}
	
	
}
