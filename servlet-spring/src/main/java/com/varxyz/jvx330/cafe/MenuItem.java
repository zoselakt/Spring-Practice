package com.varxyz.jvx330.cafe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
	private long mId;
	private MenuCategory cid;
	private String menuItem;
	private String addOther;
	private String addOther1;
	private String addOther2;
	private int menuPrice;
	private int menuItemCount;
	private boolean isHot;
	
	public MenuItem(String menuItem, int menuPrice) {
		this.menuItem = menuItem;
		this.menuPrice = menuPrice;
	}
}
