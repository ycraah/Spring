package com.firstSpring.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class YoilTeller{
	@RequestMapping("/date")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//입력
		String yyyy = request.getParameter("year");
		String MM = request.getParameter("month");
		String dd = request.getParameter("day");
		
		int year = Integer.parseInt(yyyy);
		int month = Integer.parseInt(MM);
		int day = Integer.parseInt(dd);
			
		//작업
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);

		//출력
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String[] yoilArr = {"", "일", "월", "화", "수", "목", "금", "토"};
		String yoil = yoilArr[dayOfWeek];
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + year + "년 " + month + "월 " + day +"일은 " + yoil + "요일입니다." + "</p>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
