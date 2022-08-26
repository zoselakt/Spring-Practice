package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.dao.GalleryDao;
import com.medici.arang.user.command.GalleristCommend;

public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	private GalleryDao galleryDao = new GalleryDao();

	@Override
	public long insertGallery(GalleryCommand galleryCommand) {
		return galleryDao.insertGallery(galleryCommand);
	}
	
	@Override
	public GalleryCommand findAllGalleryByRepresenterNum(String num) {
		return galleryDao.findAllGalleryByRepresenterNum(num);
	}
	@Override
	public long getGalleryCount() {
		return galleryDao.getGalleryCount();
	}
	@Override
	public long updateGallery(GalleryCommand galleryCommand, long gallery_code) {
		return galleryDao.updateGallery(galleryCommand, gallery_code);
	}

	@Override
	public long deleteGallery(long gallery_code) {
		return galleryDao.deleteGallery(gallery_code);
	}

	@Override
	public List<GalleryCommand> findAllGalleryInfo() {
		return galleryDao.findAllGalleryInfo();
	}
	
	@Override
	public GalleristCommend GalleristbyEmail(String email) {
		return galleryDao.GalleristbyEmail(email);
	}
	
	@Override
	public List<GalleryCommand> findImgPath() {
		return galleryDao.findImgPath();
	}
	
	@Override
	public List<GalleryCommand> findOneGallery(long gallery_code) {
		return galleryDao.findOneGallery(gallery_code);
	}
}
