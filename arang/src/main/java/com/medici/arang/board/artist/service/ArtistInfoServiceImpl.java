package com.medici.arang.board.artist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.board.artist.command.ArtistInfoCommand;
import com.medici.arang.board.artist.command.FindArtistInfoCommand;
import com.medici.arang.board.artist.dao.ArtistInfoDao;

public class ArtistInfoServiceImpl {
	
	@Autowired
	ArtistInfoDao artistInfoDao;
	
	public void addArtistInfo(ArtistInfoCommand artistInfoCommand) {
		artistInfoDao.addArtistInfo(artistInfoCommand);
	}
	
	public FindArtistInfoCommand findArtistInfo(long id) {
		return artistInfoDao.findArtistInfo(id);
	}
	
	public List<FindArtistInfoCommand> findArtist() {
		return artistInfoDao.findArtist();
	}
	
	public long getArtistCount() {
		return artistInfoDao.getArtistCount();
	}
}
