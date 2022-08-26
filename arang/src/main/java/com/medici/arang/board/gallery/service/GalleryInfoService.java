package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medici.arang.board.gallery.command.GalleryInfoCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;

@Service
public interface GalleryInfoService {
	public long insertGalleryInfo(GalleryInfoCommand infoCommand);
	public long deleteGalleryInfo(long galleryCode);
	public List<GalleryPageCommand> allFindGallery();
	public List<GalleryPageCommand> findGalleryByID(long code);
	public Page<GalleryPageCommand> allFindGalleryPage(Pageable pageable);
}
