package com.varxyz.jvx330.di.example7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("MenuItemDao")
public class MenuItemDao {
	private static final List<MenuItem> MENU = new ArrayList<MenuItem>();
	
	public void save(MenuItem item) {
		if(!MENU.contains(item)) {
			MENU.add(item);
		}
	}
	
	public List<MenuItem> findAllMenuItemList(){
		return MENU;
	}
	
	public MenuItem findByName(String name) {
		for(MenuItem item : MENU) {
			if(item.getName().equals(name)) {
				return item;
			}
		}
		throw new RuntimeException(name+"menu does not exist");
	}
}
