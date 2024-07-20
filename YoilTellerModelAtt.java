package com.firstSpring.app;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerModelAtt {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		return "errorPage";
	}
	
	@RequestMapping("/yoil")
	public String main(MyDate date, Model m) {
		//유효성 검사
		if(!isValid(date)) {
			return "errorPage";
		}
		//요일 확인
		char yoil = getYoil(date);
		//Model에 작업 저장
		m.addAttribute("yoil", yoil);
		//출력
		return "dayOfWeek";
	}
	
	private char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}
	
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year,  month, day);
		int yoilIdx = cal.get(Calendar.DAY_OF_WEEK); 
		return " 일월화수목금토일".charAt(yoilIdx);
	}

	private boolean isValid(MyDate date) {
		if(0 < date.getYear() && 1 <= date.getMonth() && date.getMonth() <=12 && 1 <= date.getDay() && date.getDay() <= 31) return true;
		else return false;
	}
}
