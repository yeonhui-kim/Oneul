package com.oneul.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.GratitudeDiary;
import com.oneul.web.service.GratitudeDiaryService;

@Controller
@RequestMapping("/diary/gratitudeDiary")
public class GratitudeDiaryController {

	@Autowired
	private GratitudeDiaryService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		List<GratitudeDiary> list = service.getList();
		model.addAttribute("list",list);
		
		return "diary/gratitudeDiary/list";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		
		return "diary/gratitudeDiary/reg";
	}
	
	@PostMapping("reg")
	public String reg(GratitudeDiary gratitudeDiary, 
						String content1, String content2, String content3, Integer emotionId) {
		
		gratitudeDiary.setContent1(content1);
		gratitudeDiary.setContent2(content2);
		gratitudeDiary.setContent3(content3);
		gratitudeDiary.setPub(true);
		gratitudeDiary.setMemberId(4);
		gratitudeDiary.setEmotionId(emotionId);
		
		service.insert(gratitudeDiary);
		
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public String detail(int id, Model model) {
		
		GratitudeDiary gratitudeDiary = service.get(id);
		model.addAttribute("gratitudeDiary",gratitudeDiary);
		
		return "diary/gratitudeDiary/detail";
	}
	
	@RequestMapping("del")
	public String delete(int id) {
		service.delete(id);
		return "redirect:list";
	}
	
	@GetMapping("edit")
	public String edit(int id, Model model) {
		
		GratitudeDiary gratitudeDiary = service.get(id);
		model.addAttribute("gratitudeDiary",gratitudeDiary);
		
		return "diary/gratitudeDiary/edit";
	}
	
	@PostMapping("edit")
	public String edit(GratitudeDiary gratitudeDiary) {
		service.update(gratitudeDiary);
		return "redirect:detail?id="+gratitudeDiary.getId();
	}
}
