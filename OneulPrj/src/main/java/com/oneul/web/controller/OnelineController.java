package com.oneul.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.Oneline;
import com.oneul.web.service.OnelineService;

@Controller("OnelineController")
@RequestMapping("/feed/oneline/")

public class OnelineController {

	@Autowired
	private OnelineService service;
	
	@RequestMapping("list")
	public String list(Model model) {	
		List<Oneline> list = service.getList(1, null, null); //서비스 클래스에있는 getList(인자3개)값을 list에 넣자
		model.addAttribute("list",list);//"list"라는 키값에 위에서 받아온 list데이터를 넣고 model로 전달된다.
		//test
		return "feed/oneline/oneline";
	}
	
	@RequestMapping("reg")
	public String reg(Model model) {
	
		
		return "feed.onelineReg";
	}
	
	
	
	@PostMapping("reg")
	public String reg(String content) {
		
		Oneline oneline = new Oneline();
		oneline.setContent(content);
		oneline.setMemberId(5);
		
		service.insert(oneline);
		
		return "redirect:list";	//객체 형태로 리턴 //list로 돌아감
		
	}
	
	@RequestMapping("del")
	public String reg(int id) {
	
		service.delete(id);
		return "redirect:list";
	}
	
}
