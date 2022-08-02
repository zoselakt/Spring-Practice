package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlyController {
	
	@RequestMapping("/example1/fly")
	public ModelAndView flyToTheSky() {
		String flyme = "fly me to the moon";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1/fly");
		mav.addObject("flyme", flyme);
		
		return mav;
	}
}
