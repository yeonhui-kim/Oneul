package com.oneul.web.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.Member;
import com.oneul.web.service.MemberService;

@Controller("MemberController")
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("signup")
	public String signup() {
		return "member/signup";		
	}
	
	@RequestMapping("logintest")
	public String logintest() {
		return "member/logintest";		
	}
	
	
	@PostMapping("reg")
	public String reg(String username,
						String password,
						String name,
						Date birthday,
						String email) {
		
		Member member = new Member();
		member.setUserId(username);
		member.setPassword(password);
		member.setName(name);
		member.setBirthday(birthday);
		member.setEmail(email);
		
		service.insert(member);
		
		return "redirect:login";
		//헬로
	}
	
}


