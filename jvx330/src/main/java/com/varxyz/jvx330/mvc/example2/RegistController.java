package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistController {
	@GetMapping("/example2/step1")
	public String handleStep1() {
		return "example2/step1";
	}
	@PostMapping("/example2/step2")
	public String handleStep2() {
		return "example2/step2";
	}
	@PostMapping("/example2/step3")
	public String handleStep3() {
		return "example2/step3";
	}
}