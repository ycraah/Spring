package com.firstSpring.app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/*")
public class PerformanceFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//초기화 작업
		System.out.println("init시작");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long startTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		System.out.printf("[%s]",((HttpServletRequest)request).getRequestURI());
		System.out.printf("소요시간 = %dms", System.currentTimeMillis()-startTime);
	}

	@Override
	public void destroy() {
		
		System.out.println("destroy시작");
	}
	
}
