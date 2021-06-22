package com.oneul.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.FreeDiaryComment;
import com.oneul.web.entity.Oneline;
import com.oneul.web.entity.OnelineComment;
import com.oneul.web.service.FreeDiaryCommentService;
import com.oneul.web.service.OnelineCommentService;
import com.oneul.web.service.OnelineService;

@Controller("OnelineController")
@RequestMapping("/feed/oneline/")

public class OnelineController {

	@Autowired
	private OnelineService service;
	
	@Autowired
	private OnelineCommentService cservice;
	
	
	@RequestMapping("list") 
	public String list(Model model, int id) {	
		List<Oneline> list = service.getList(1, null, null); //서비스 클래스에있는 getList(인자3개)값을 list에 넣자
		model.addAttribute("list",list);//"list"라는 키값에 위에서 받아온 list데이터를 넣고 model로 전달된다.
		
		List<OnelineComment> clist = cservice.getViewList(id);
		model.addAttribute("clist",clist);
		
		return "feed/oneline/list";
	}
	
	@RequestMapping("detail")
	public String detail(Model model, int id) {
		Oneline oneline = service.get(id);	
		model.addAttribute("detail",oneline);

//		List<OnelineComment> clist = cservice.getViewList(id);
//		model.addAttribute("clist",clist);
		
		return "feed/oneline/detail";
	}
	
	
	
	
	//-----------------게시글 출력------------------------
//	@RequestMapping("list") 
//	public String list(Model model) {	
//		List<Oneline> list = service.getList(1, null, null); //서비스 클래스에있는 getList(인자3개)값을 list에 넣자
//		model.addAttribute("list",list);//"list"라는 키값에 위에서 받아온 list데이터를 넣고 model로 전달된다.
//		//test
//		return "feed/oneline/list";
//	}
	
	@GetMapping("reg")
	public String reg(Model model) {
	
		
		return "feed/oneline/reg";
	}
	
	
	
	@PostMapping("reg")
	public String reg(String content, String comment) {
		
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
	
	@GetMapping("edit")
	public String edit(int id, Model model) {
		Oneline oneline = service.get(id);
		model.addAttribute("Oneline",oneline);
		
		
		return "feed/oneline/edit";
		
	}
	
	@PostMapping("edit")
	public String edit(Oneline oneline) {
		service.update(oneline);
		
		return "redirect:list";
	}
	
	
	
}
