package com.oneul.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;


@Configuration
@WebFilter("/*")
public class NavbarFilter implements Filter{
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = ((HttpServletRequest)request);
		HttpServletResponse res = ((HttpServletResponse)response);
		
		
		
		String uri = req.getRequestURI();
		if (uri.startsWith("/feed")) {
			req.setAttribute("menu", "feed");
			System.out.println("feedfeedfeedfeedfeedfeedfeedfeedfeedfeed");
		} else if (uri.startsWith("/calendar")) {
			req.setAttribute("menu", "calendar");
			System.out.println("calendarcalendarcalendarcalendarcalendarcalendar");

		} else if (uri.startsWith("/mypage")) {
			req.setAttribute("menu", "mypage");
			System.out.println("mypagemypagemypagemypagemypage");

		} else if (uri.startsWith("/diary/reg")) {
			req.setAttribute("menu", "reg");
			System.out.println("regregregregregregregregregregreg");

		} else if (uri.startsWith("/diary")) {
			req.setAttribute("menu", "diary");
			System.out.println("diarydiarydiarydiarydiarydiarydiarydiarydiary");

		}
		
		
		
		
		
		
		
		chain.doFilter(request, response);
	}
	
}
