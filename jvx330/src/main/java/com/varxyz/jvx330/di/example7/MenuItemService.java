package com.varxyz.jvx330.di.example7;

import java.util.List;

public interface MenuItemService {
	/**
	 * 신규등록
	 * @param item
	 */
	void addMenuItem(MenuItem item);

	
	/**
	 * 전체 메뉴목록 리턴
	 * @return
	 */
	List<MenuItem> getAllMenuItemList();


	/**
	 * 메뉴명으로 메뉴 아이템 조회
	 * @param name
	 * @return
	 */
	MenuItem getMenuItem(String name);
}
