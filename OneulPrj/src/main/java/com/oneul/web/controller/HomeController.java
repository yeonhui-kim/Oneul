package com.oneul.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("HomeController")
@RequestMapping("/")
public class HomeController {
	
	//로그인페이지 조회
	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) {
		String errMsg;
		
		if(request.getAttribute("loginFailMsg")!=null) {
			errMsg = (String) request.getAttribute("loginFailMsg");
			model.addAttribute("errMsg", errMsg);
		}
		
		return "/login";
	}
}