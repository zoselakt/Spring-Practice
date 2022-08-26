package com.medici.arang.board.gallery.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GalleryVo {
	private long code; //갤러리 고유코드
	private String galleristEmail;
	private String galleryName_kor; //한글갤러리명
	private String galleryName_eng; //영어 갤러리명
	private String address; // 주소
	private String galleryEmail; // 이메일
	private String galleryPhone; // 전화번호
	private String since; // 연혁
	private String area; // 전시면적 및 층수
	private String openClose; // 운영시간
	private String representer; //운영대표
	private String representerNum; //사업자등록번호
	private String galleryImgPath; // 갤러리 이미지 추가
	private Timestamp regDate;
}
