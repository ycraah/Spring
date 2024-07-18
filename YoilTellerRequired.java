package com.firstSpring.app;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerRequired {
	@RequestMapping("/yoil")
	public String main(@RequestParam(required=false, defaultValue="2024") int year,@RequestParam(required=false, defaultValue="1") int month, @RequestParam(required=false, defaultValue="1")int day, Model model) throws IOException{	
		if(!isValid(year, month, day)) {
			return "error";
		}
		
		char yoil = getYoil(year, month, day);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil";
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year,  month, day);
		return " 일월화수목금토일".charAt(cal.DAY_OF_WEEK);
	}
}
