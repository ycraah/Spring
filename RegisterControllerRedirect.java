package com.firstSpring.app;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@GetMapping("/add")
	public String register() {
		return "register";
	}
	
	@PostMapping("/save")
	public String save(User user, Model m) throws Exception{
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			
//			return "forward:/register/add";
			return "redirect:/register/add?msg="+msg;
		}
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
