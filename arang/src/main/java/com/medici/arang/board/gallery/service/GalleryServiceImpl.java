package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.board.gallery.dao.GalleryDao;
import com.medici.arang.board.gallery.domain.GalleryVo;

public class GalleryServiceImpl implements GalleryService{
	private GalleryDao galleryDao = new GalleryDao();
	
	@Autowired
	public GalleryServiceImpl(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}

	@Override
	public long insertGallery(GalleryVo galleryVo) {
		return galleryDao.insertGallery(galleryVo);
	}

	@Override
	public long updateGallery(GalleryVo galleryVo, long gallery_code) {
		return galleryDao.updateGallery(galleryVo, gallery_code);
	}

	@Override
	public long deleteGallery(long gallery_code) {
		return galleryDao.deleteGallery(gallery_code);
	}

	@Override
	public List<GalleryVo> findAllGalleryInfo() {
		return galleryDao.findAllGalleryInfo();
	}

	@Override
	public GalleryVo findOneGalleryInfo(long gallery_code) {
		return galleryDao.findOneGalleryInfo(gallery_code);
	}

	@Override
	public long insertFileUpload(GalleryVo galleryVo) {
		return galleryDao.insertFileUpload(galleryVo);
	}
}
