package com.medici.arang.user.service;

import org.springframework.stereotype.Service;

import com.medici.arang.user.command.GalleristCommend;

@Service
public interface GalleristService {
	public void insertGallerist(GalleristCommend commend);
	public boolean isValidUser(String email, String passwd);
}
