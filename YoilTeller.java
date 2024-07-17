package com.firstSpring.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class YoilTeller{
	@RequestMapping("/yoil")
	public String main(int year, int month, int day, Model model) throws IOException {
		//유효성 검사
		if(!isValid(year,month,day)) {
			return "error";
		}
		
		String yoil = getYoil(year, month, day);
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil";
	}

	private String getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String[] yoilArr = {"", "일", "월", "화", "수", "목", "금", "토"};
		String yoil = yoilArr[dayOfWeek];
		return yoil;
	}

	private boolean isValid(int year, int month, int day) {
		if(0 < year && 0<=month && month<12 && 1<=day && day<=31) {
			return true;
		}
		return false;
	}
}
