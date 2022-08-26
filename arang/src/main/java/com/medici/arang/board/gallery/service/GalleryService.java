package com.medici.arang.board.gallery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.user.command.GalleristCommend;

@Service
public interface GalleryService {
	public long insertGallery(GalleryCommand galleryCommand);
	public long updateGallery(GalleryCommand galleryCommand, long code);
	public long deleteGallery(long code);
	public List<GalleryCommand> findAllGalleryInfo();
	public GalleryCommand findAllGalleryByRepresenterNum(String num);
	public GalleristCommend GalleristbyEmail(String email);
	public List<GalleryCommand> findOneGallery(long code);
	public List<GalleryCommand> findImgPath();
	public long getGalleryCount();
}

