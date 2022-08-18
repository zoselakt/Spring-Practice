package com.medici.arang.board.gallery.domain;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class GalleryVo {
	private long code;
	private String galleryName;
	private String galleristName;
	private String address;
	private String galleryEmail;
	private String galleryPhone;
	private String area;
	private int payment;
	private int galleryFloor;
	private int corporateRegistrationNum;
	private String imgPath;
}
