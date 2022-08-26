package com.medici.arang.board.gallery.controller.gallery;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.command.GalleryInfoCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.board.gallery.service.GalleryInfoServiceImpl;
import com.medici.arang.board.gallery.service.GalleryServiceImpl;

@Controller("galleryUpdateController")
public class GalleryUpdateController {
	@Autowired
	private GalleryServiceImpl galleryServiceImpl;
	
	@Autowired
	private GalleryInfoServiceImpl galleryInfoServiceImpl;
		
	@GetMapping("gallery/gallery_update")
	public String galleyUpdate(GalleryCommand galleryCommand, GalleryInfoCommand gInfoCommand, 
			Model model, HttpServletRequest request, @RequestParam long code) {
		//세션유지
		HttpSession session = request.getSession();
		String galleristEmail = (String) session.getAttribute("email");
		System.out.println(galleristEmail);
		
		//value값 불러오기
		List<GalleryCommand> galleryUpdate = galleryServiceImpl.findOneGallery(code);
		model.addAttribute("galleryUpdate", galleryUpdate);
		
		List<GalleryPageCommand> galleryInfoCommand = galleryInfoServiceImpl.findGalleryByID(code);
		model.addAttribute("galleryInfoCommand", galleryInfoCommand);
		return "gallery/gallery_update";
	}
	
	//이미지 저장될 경로
	private static final String SAVE_DIR = "C:\\JavaYoung\\JavaStudy\\eclipse-workspace\\arang\\src\\main\\webapp\\resources\\img\\";
	private static final String PATH_DIR = "/upload_img/";
	
	@PostMapping("gallery/gallery_update")
	public String insertGalleryForm(GalleryCommand galleryCommand, GalleryInfoCommand infoCommand,
					@RequestParam("imgName2") List<MultipartFile> multiFileList,
					HttpServletRequest request, Model model) throws Exception {
		
		File fileCheck = new File(SAVE_DIR);
		//해당 폴더가 없으면 생성하는거
		if(!fileCheck.exists()) fileCheck.mkdirs();
		
		List<Map<String, String>> fileList = new ArrayList<>();
		List<String> imgList = new ArrayList<String>();
		
		for(int i = 0; i < multiFileList.size(); i++) {
			//실제 파일 이름
			String originFile = multiFileList.get(i).getOriginalFilename();
			//실제 파일 확장자
			String ext = originFile.substring(originFile.lastIndexOf("."));
			//UUID 가짜 이름 + 확장자
			UUID uuid = UUID.randomUUID();
			String[] uuids = uuid.toString().split("-");			
			String changeFile = uuids[0] + ext;
			imgList.add(changeFile);
			
			Map<String, String> map = new HashMap<>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);
			fileList.add(map);
		}
		System.out.println(imgList);
		String galleryImg = imgList.get(0);
		imgList.remove(0);
		/**
		 * 배열에 담기위해 배열을 스트링 타입으로 바꿔서 다시 담는곳.
		 * 각각의 값을 ; 로 구분함
		 */
		
		String imgPathList = "";		
		for (String string : imgList) {
			imgPathList += PATH_DIR;
			imgPathList += "gallery\\";
			imgPathList += string;
			imgPathList += ";";
		}
		System.out.println(imgPathList);
		
		//파일 실제 저장 하는 곳
		try {
			for(int i = 0; i < multiFileList.size(); i++) {
				File uploadFile = new File(SAVE_DIR + "gallery\\" + fileList.get(i).get("changeFile"));
				multiFileList.get(i).transferTo(uploadFile);
			}
		} catch (IllegalStateException | IOException e) {
			// 업로드 실패시 파일 삭제
			for(int i = 0; i < multiFileList.size(); i++) {
				new File(SAVE_DIR + "gallery\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}
		
		/**
		 * DB 처리 하는곳
		 * 이미지 경로의 경우 폼 그대로의 값을 넣지 않기 때문에 경로값 설정후 DB처리
		 */
		galleryCommand.setGalleryImgPath(PATH_DIR + "\\gallery\\" + galleryImg);
		infoCommand.setInfoImgPath(imgPathList);
		String imgName = galleryCommand.getGalleryImgPath();
		System.out.println(imgName);
		
		long getCode = galleryCommand.getCode();
		galleryServiceImpl.updateGallery(galleryCommand, getCode);
		
		return "redirect:gallery";
	}
}

