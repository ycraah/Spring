package com.firstSpring.app;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerDate {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		return "error";
	}
	
	@RequestMapping("/yoil")
	public String main(MyDate date, Model model) throws IOException{	
		
		
		char yoil = getYoil(date);
		model.addAttribute("MyDate", date);
		model.addAttribute("yoil", yoil);
		
		return "yoil";
	}

	private char getYoil(MyDate date) {
		Calendar cal = Calendar.getInstance();
		cal.set(date.getYear(),  date.getMonth(), date.getDay());
		return " 일월화수목금토일".charAt(cal.DAY_OF_WEEK);
	}
}
