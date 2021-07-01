package com.oneul.web.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.Member;

@RestController("ApiDiaryController")
@RequestMapping("/api/diary")
public class DiaryController {
	
	
	
	
	
	@GetMapping("/freediary/{p}")
	public FreeDiary freeDiaryList(@PathVariable(name ="p") Integer page, @RequestParam( name = "q", defaultValue = "") String query) {
		
		

		return null;
	}
}
