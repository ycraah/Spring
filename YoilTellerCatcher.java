package com.firstSpring.app;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		return "error";
	}
	
	@RequestMapping("/yoil")
	public String main(@RequestParam int year,@RequestParam int month, @RequestParam int day, Model model) throws IOException{	
		
		
		char yoil = getYoil(year, month, day);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil";
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year,  month, day);
		return " 일월화수목금토일".charAt(cal.DAY_OF_WEEK);
	}
}
