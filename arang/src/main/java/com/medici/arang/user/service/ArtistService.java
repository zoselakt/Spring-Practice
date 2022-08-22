package com.medici.arang.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medici.arang.user.command.ArtistCommand;
import com.medici.arang.user.command.ArtistPageCommand;

public interface ArtistService {
	public void addArtist(ArtistCommand artistCommand);
	List<ArtistCommand> getAllArtist();
	ArtistCommand getArtistByEmail(String email);
	Page<ArtistPageCommand> findAllPage(Pageable pageable);
}