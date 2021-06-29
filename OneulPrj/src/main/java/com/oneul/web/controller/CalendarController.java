package com.oneul.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneul.web.service.CalendarEmotionService;

@Controller
@RequestMapping("/calendar/")
public class CalendarController {
	
	@Autowired
	private CalendarEmotionService calendarService;
	
	@RequestMapping("list")
	public String list(Model model) {
		
//		Map<String, String> event1 = new HashMap<String, String>();
//		event1.put("title", "일정1");
//		event1.put("start", "2021-06-22");
//		event1.put("id", "event1");
//		
//		Map<String, String> event2 = new HashMap<String, String>();
//		event2.put("title", "일정2");
//		event2.put("start", "2021-06-23");
//		event2.put("id", "event3");
//		
//		Map<String, String> event3 = new HashMap<String, String>();
//		event3.put("title", "일정3");
//		event3.put("start", "2021-06-24");
//		event3.put("id", "event3");
//		
//		List<Map<String, String>> jsonList = new ArrayList<Map<String, String>>();
//		
//		jsonList.add(event1);
//		jsonList.add(event2);
//		jsonList.add(event3);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		String json = "";
//		try {
//			json = mapper.writeValueAsString(jsonList);
//		} catch(Exception e) {
//			
//		}
//
//		
//		model.addAttribute("jsonString", json);
		
		
		return "calendar/calendar";
	}

}
