package com.firstSpring.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class printRequestParam {
	@RequestMapping("printParam")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Enumeration<String> parameterNames = request.getParameterNames();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		while(parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			out.print("<p>" + paramName + " : " + paramValue + "</p>");
		}
		out.print("</body>");
		out.print("</html>");		
	}

}
