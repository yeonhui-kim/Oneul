package com.oneul.web.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.CalendarEmotion;
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
	public String reg(@ModelAttribute GratitudeDiary gratitudeDiary, @ModelAttribute CalendarEmotion calendarEmotion) {
		//SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date(System.currentTimeMillis());
		gratitudeDiary.setMemberId(2);
		gratitudeDiary.setRegDate(now);

		//calendarEmotion.setMemberId(gratitudeDiary.getMemberId());
		//calendarEmotion.setRegDate(fmt.format(gratitudeDiary.getRegDate()));
		
		service.insertDiary(gratitudeDiary);
//		
//		//1. 현재 로그인한 사용자가 해당 날짜에 감정을 등록한적 있는지 확인
//		int cnt = service.selectCalEmotionCnt(calendarEmotion);
//		
//		if( cnt > 0 ) {
//			service.updateCalendar(calendarEmotion);
//		} else {
//			service.insertCalendar(calendarEmotion);
//		}
		
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
	public String edit(GratitudeDiary gratitudeDiary, CalendarEmotion calendarEmotion) {
		service.updateDiary(gratitudeDiary);
		//service.updateCalendar(calendarEmotion);
		
		return "redirect:detail?id="+gratitudeDiary.getId();
	}
}
