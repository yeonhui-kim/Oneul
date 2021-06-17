package com.oneul.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/calendar/")
public class CalendarController {
	
	@RequestMapping("list")
	public String list(Model model) {
		
		
		
		return "calendar/calendar";
	}

}
