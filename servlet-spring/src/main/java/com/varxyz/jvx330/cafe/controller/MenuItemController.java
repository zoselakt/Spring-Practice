package com.varxyz.jvx330.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.jvx330.cafe.CafeProvider;
import com.varxyz.jvx330.cafe.MenuItem;
import com.varxyz.jvx330.cafe.service.CafeServiceImpl;

@Controller("cafe.controller.menuItemController")
public class MenuItemController {
	private CafeServiceImpl cafeServiceImpl;
	
	@Autowired
	public MenuItemController(CafeServiceImpl cafeServiceImpl) {
		this.cafeServiceImpl = cafeServiceImpl;
	}
	@GetMapping("cafe/cafeMainForm")
	public String menuItem(Model model, MenuItem menuItem) {
		model.addAttribute("MenuItem", menuItem);
		return "cafe/cafeMainForm";
	}
	
	@ModelAttribute("cafeItemList")
	public List<CafeProvider> getMenuItemList(){
		List<CafeProvider> list = new ArrayList<CafeProvider>(); 
		list.add(new CafeProvider("coffee", 1500));
		list.add(new CafeProvider("coldBrew", 2500));
		list.add(new CafeProvider("latte", 2000));
		list.add(new CafeProvider("smoothie", 2500));
		list.add(new CafeProvider("fraffe", 3000));
		return list;
	}
	@ModelAttribute("otherList")
	public List<String> getOtherList(){
		List<String> list = new ArrayList<String>();
		list.add("휘핑추가");
		list.add("샷추가");
		list.add("버블추가");
		list.add("디카페인");
		return list;
	}
	
	@PostMapping("cafe/cafeMainForm")
	public String menuItemForm(@ModelAttribute("MenuItem") MenuItem menuItem, Model model) {
		cafeServiceImpl.insertMenu(menuItem);
		
		String menu = menuItem.getMenuItem();
		String other = menuItem.getAddOther()+"-"+menuItem.getAddOther1();
		int price = menuItem.getMenuPrice();
		
		menuItem.setMenuItem(menu);
		menuItem.setAddOther(other);
		menuItem.setMenuPrice(price);
		
		model.addAttribute("MenuItem", menuItem);
		
		return "cafe/success_add_manu";
	}
}
