package com.oneul.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.service.FreeDiaryService;

@Controller
@RequestMapping("/diary/freediary/")
public class FreeDiaryController {
	
	@Autowired
	private FreeDiaryService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		List<FreeDiary> list = service.getList(1,null,null);
		model.addAttribute("list",list);
		
		return "diary.freediary.list";
	}

	
	
}
