package com.medici.arang.board.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.service.NoticeServiceImpl;

@Controller("noticeUpdateController")
public class NoticeUpdateController {
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	public NoticeUpdateController(NoticeServiceImpl noticeServiceImpl) {
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
	// 파일업로드 경로 표시
	private static final String SAVE_DIR = "C:\\JavaYoung\\JavaStudy\\eclipse-workspace\\arang\\src\\main\\webapp\\resources\\img\\";
	private static final String PATH_DIR = "/upload_img/";
	
	@GetMapping("notice/updateNoticeForm")
	public String updateGet(@ModelAttribute NoticeCommand noticeCommand, Model model,
			HttpServletRequest request, @RequestParam long num) {
//		HttpSession session = request.getSession();
//		String getEmail = (String) session.getAttribute("email");
//		String adminIdentified = (String) session.getAttribute("writer");
//		command.setWriter(adminIdentified);
		List<NoticeCommand> noticeUpdate = noticeServiceImpl.findOneNotice(num);
		
		request.setAttribute("noticeCommand", noticeCommand);
		model.addAttribute("noticeUpdate", noticeUpdate);
		return "notice/updateNoticeForm";
	}
	@PostMapping("notice/updateNoticeForm")
	public String updatePost(@ModelAttribute NoticeCommand noticeCommand, Model model,
			@RequestParam(value = "imgName2") List<MultipartFile> multiFileList,
			HttpServletRequest request) {
		
		//파일업로드
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
			String noticeImg = imgList.get(0);
			imgList.remove(0);
			
			/**
			 * 배열에 담기위해 배열을 스트링 타입으로 바꿔서 다시 담는곳.
			 * 각각의 값을 ; 로 구분함
			 */
			String imgPathList = "";		
			for (String string : imgList) {
				imgPathList += PATH_DIR;
				imgPathList += "notice\\";
				imgPathList += string;
				imgPathList += ";";
			}
			System.out.println(imgPathList);
			
			//파일 실제 저장 하는 곳
			try {
				for(int i = 0; i < multiFileList.size(); i++) {
					File uploadFile = new File(SAVE_DIR + "notice\\" + fileList.get(i).get("changeFile"));
					multiFileList.get(i).transferTo(uploadFile);
				}
			} catch (IllegalStateException | IOException e) {
				// 업로드 실패시 파일 삭제
				for(int i = 0; i < multiFileList.size(); i++) {
					new File(SAVE_DIR + "notice\\" + fileList.get(i).get("changeFile")).delete();
				}
				e.printStackTrace();
			}
			
			/**
			 * DB 처리 하는곳
			 * 이미지 경로의 경우 폼 그대로의 값을 넣지 않기 때문에 경로값 설정후 DB처리
			 */
			
			noticeCommand.setImgPath(PATH_DIR + "\\notice\\" + noticeImg);
				
			String imgName = noticeCommand.getImgPath();
			System.out.println(imgName);
	
		long getLong = noticeCommand.getNum(); 
		long noticeUpdate = noticeServiceImpl.updateNotice(noticeCommand, getLong);

		request.setAttribute("noticeUpdate", noticeUpdate);
		model.addAttribute("noticeCommand", noticeCommand);
		return "redirect:notice";
	}
}
