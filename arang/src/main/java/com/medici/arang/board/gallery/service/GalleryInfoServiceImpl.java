package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.board.gallery.command.GalleryInfoCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
import com.medici.arang.board.gallery.dao.GalleryInfoDao;

/**
 * 
 * @author Administrator
 * List<GalleryPageCommand>로 된것은 모두 long 값을 code로 써야한다.
 */
public class GalleryInfoServiceImpl implements GalleryInfoService{
	
	@Autowired
	private GalleryInfoDao galleryInfoDao;
	
	public long insertGalleryInfo(GalleryInfoCommand infoCommand) {
		return galleryInfoDao.insertGalleryInfo(infoCommand);
	}
	
	public long deleteGalleryInfo(long galleryCode) {
		return galleryInfoDao.deleteGalleryInfo(galleryCode);
	}
	
	public List<GalleryPageCommand> allFindGallery() {
		return galleryInfoDao.allFindGallery();
	}
	
	public List<GalleryPageCommand> findGalleryByID(long code) {
		return galleryInfoDao.findGalleryByID(code);
	}
	
	//페이징 처리
	public Page<GalleryPageCommand> allFindGalleryPage(Pageable pageable) {
		return galleryInfoDao.allFindGalleryPage(pageable);
	}

	public long getCount() {
		return galleryInfoDao.getCount();
	}
}
