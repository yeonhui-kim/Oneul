package com.oneul.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneul.web.entity.CalendarEmotion;
import com.oneul.web.entity.Member;
import com.oneul.web.service.CalendarEmotionService;
import com.oneul.web.service.MemberService;

@Controller
@RequestMapping("/calendar/")
public class CalendarController {
	
	@Autowired
	private CalendarEmotionService calendarService;
	@Autowired
	private MemberService memberSerivce;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request, 
						@RequestParam(name="currentMonth", required = false) String currentMonth,
						Model model) {
		
		HttpSession session = request.getSession(true);//세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");
		Member member = memberSerivce.get(username);
		int id = member.getId();
		
		CalendarEmotion param = new CalendarEmotion();
		param.setMemberId(id);
		List<Map<String, Object>> emotionList = calendarService.getListCalendar(param);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = "";
		try {
			json = mapper.writeValueAsString(emotionList);
		} catch(Exception e) {
		}
		model.addAttribute("jsonString", json);
		
		return "calendar/calendar";
	}
	
	

}
