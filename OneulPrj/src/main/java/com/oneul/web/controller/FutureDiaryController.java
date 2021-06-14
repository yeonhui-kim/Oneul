package com.oneul.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneul.web.entity.FutureDiary;
import com.oneul.web.service.FutureDiaryService;

@Controller
@RequestMapping("/diary/futurediary/")
public class FutureDiaryController {

	@Autowired
	private FutureDiaryService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<FutureDiary> list = service.getList(1);
		
		model.addAttribute("list", list);
		return("diary.futurediary.list");
	}
	
	@RequestMapping("detail")
	public String detail(Model model, int id) {
		FutureDiary futureDiary = service.get(id);
		
		model.addAttribute("futureDiary", futureDiary);
		return("diary.futurediary.detail");
	}
	
	@PostMapping("reg")
	public String reg(@DateTimeFormat(pattern="yyyy-MM-dd")Date bookingDate, String content) {
		System.out.println("controller:"+bookingDate);
		FutureDiary futureDiary = new FutureDiary();
		
		futureDiary.setBookingDate(bookingDate);
		futureDiary.setContent(content);
		futureDiary.setMemberId(4);
		//futureDiary.setPub(pub);
		service.insert(futureDiary);
		return("redirect:list");
	}
	@GetMapping("reg")
	public String reg() {
		return("diary.futurediary.reg");
	}
	
	@GetMapping("edit")
	public String edit(int id,Model model) {
		FutureDiary futureDiary = service.get(id);
		
		model.addAttribute("futureDiary", futureDiary);
		return("diary.futurediary.edit");
	}
	
	@PostMapping("edit")
	public String edit(FutureDiary futureDiary) {
		service.update(futureDiary);
		return "redirect:detail?id="+futureDiary.getId();
	}
	
	@RequestMapping("del")
	public String del(int id) {
		
		service.delete(id);
		
		return("redirect:list");
	}
	
	
}
