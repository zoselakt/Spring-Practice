package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Menu implements MenuService{

	@Bean
	public MenuDao menuDao() {
		return new MenuDao() ;
	}

	@Override
	public void addMenuItem(String name, int password) {
		System.out.println("메뉴 생성: " + this);
	}

	public void findList(List<MenuItem> menuitem) {
		System.out.println("찾을 메뉴: " + this);
	}

}
