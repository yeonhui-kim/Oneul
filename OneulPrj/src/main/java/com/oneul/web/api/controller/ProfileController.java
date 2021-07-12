package com.oneul.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneul.web.entity.Member;
import com.oneul.web.service.MemberServiceimp;

@RestController("ApiProfileController")
public class ProfileController {
	@Autowired
	private MemberServiceimp service;
	
	

	@RequestMapping("/api/profile/{username}")
	public Member profile(@PathVariable(name ="username") String userName) {
		
		
		return service.get(userName);
	}
}
