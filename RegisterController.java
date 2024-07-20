package com.firstSpring.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	@RequestMapping("/register/add")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/register/save")
	public String save() {
		return "registerInfo";
	}
}
