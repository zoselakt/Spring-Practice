package com.medici.arang.board.gallery.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
/**
 * 
 * @author Administrator
 * 갤러리와 갤러리 인포 두 정보를 모두 가지며 조인시켜주는 command
 */
public class GalleryPageCommand {
	private long code; 
	private String galleristEmail; 
	private String galleryName_kor; 
	private String galleryName_eng; 
	private String address; 
	private String galleryEmail;
	private String galleryPhone;
	private String since;
	private String area;
	private String openClose; 
	private String representer;
	private String representerNum;
	private String galleryImgPath;
	
	//info의 내용
	private String description;
	private String infoImgPath;
}
