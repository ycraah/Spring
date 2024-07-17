package com.firstSpring.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/diceServlet")
public class TwoDiceServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest reqest, HttpServletResponse response) throws IOException {
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.printf("<p><img src='resources/img/dice%d.jpg'></p>", idx1);		
		out.printf("<p><img src='resources/img/dice%d.jpg'></p>", idx2);		
		out.println("</body>");
		out.println("</html>");
	}
}
