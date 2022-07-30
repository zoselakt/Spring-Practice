package com.varxyz.jvx330.di.example6;

import java.util.List;

public class MenuDao {
	public List<MenuItem> findMenu(){
		return List.of(new MenuItem("아메리카노"), new MenuItem("카페라떼"));
	}
}
