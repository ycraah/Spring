package com.firstSpring.app;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller {
	@RequestMapping("/yoil")
	public String main(int year, int month, int day, Model model){
		//유효성 검사
		if(!isValid(year, month, day)) {
			//오류페이지
			return "error";
		}
		
		//작업
		char yoil = getYoil(year, month, day);
		
		//model에 전달
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		//정상페이지
		return "yoil";
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		int yoilNum = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토일".charAt(yoilNum);
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}
}
