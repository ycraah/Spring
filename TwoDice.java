package com.firstSpring.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	@RequestMapping("/dice")
	public static void main(HttpServletResponse response) throws IOException{
		//작업
		Random rand = new Random();
		int randomNum1 = rand.nextInt(6)+1;
		int randomNum2 = rand.nextInt(6)+1;
		
		//출력
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.printf("<img src=\'resources/img/dice%d.jpg\'>", randomNum1);
		out.printf("<img src=\'resources/img/dice%d.jpg\'>", randomNum2);
		out.print("</body>");
		out.print("</html>");
	}
}
