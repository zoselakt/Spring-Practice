package com.medici.arang.user.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.medici.arang.user.dao.GalleristDao;
import com.medici.arang.user.command.GalleristCommend;

public class GalleristServiceImpl implements GalleristService{
	
	@Autowired
	private GalleristDao galleristDao = new GalleristDao();
	
	@Override
	public void insertGallerist(GalleristCommend commend) {
		galleristDao.insertGallerist(commend);
	}

	@Override
	public boolean isValidUser(String email, String passwd) {
		return galleristDao.isValidUser(email, passwd);
	}
	
}