package com.oneul.web.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.Member;
import com.oneul.web.service.FreeDiaryCommentServiceImp;
import com.oneul.web.service.FreeDiaryService;

@Controller
@RequestMapping("/diary/freediary/")
public class FreeDiaryController {
	

	@Autowired
	private FreeDiaryService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<FreeDiary> list = service.getList();
		model.addAttribute("list",list);
		
		return "diary.freediary.list";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		
		return "diary.freediary.reg";
	}
	
	@PostMapping("reg")
	public String reg(FreeDiary freeDiary) {
		freeDiary.setPub(true);
		freeDiary.setMemberId(4);		
		service.insert(freeDiary);
		
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public String detail(int id,Model model) {
		
		FreeDiary freeDiary = service.get(id);
		model.addAttribute("freeDiary",freeDiary);
		
		return "diary.freediary.detail";
	}
	
	@RequestMapping("del")
	public String delete(int id) {
		service.delete(id);
		return "redirect:list";
	}
	
	@GetMapping("edit")
	public String edit(int id,Model model) {
		
		FreeDiary freeDiary = service.get(id);
		model.addAttribute("freeDiary",freeDiary);
		
		return "diary.freediary.edit";
	}
	
	@PostMapping("edit")
	public String edit(FreeDiary freeDiary) {
		service.update(freeDiary);
		return "redirect:detail?id="+freeDiary.getId();
	}
	
}
