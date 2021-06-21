package com.oneul.web.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.FreeDiaryComment;
import com.oneul.web.entity.GratitudeDiary;
import com.oneul.web.entity.Member;
import com.oneul.web.entity.Question;
import com.oneul.web.service.FreeDiaryCommentService;
import com.oneul.web.service.FreeDiaryCommentServiceImp;
import com.oneul.web.service.FreeDiaryService;
import com.oneul.web.service.QuestionService;

@Controller
@RequestMapping("/diary/freediary/")
public class FreeDiaryController {
	

	@Autowired
	private FreeDiaryService service;
	@Autowired
	private FreeDiaryCommentService commentService;
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<FreeDiary> list = service.getList();
		model.addAttribute("list",list);
		
		return "diary/freediary/list";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		List<Question> list = questionService.getList();
		model.addAttribute("list",list);
		
		return "diary/freediary/reg";
	}
	
	@PostMapping("reg")
	public String reg(FreeDiary freeDiary,
				MultipartFile file,
				HttpServletRequest request) {
		freeDiary.setMemberId(4);		
		service.insert(freeDiary);
			
			String fileName = file.getOriginalFilename();
			
			ServletContext application = request.getServletContext();
			String path = "/upload";
			String realPath = application.getRealPath(path);
			
			File pathFile = new File(realPath);
			if(!pathFile.exists())
				pathFile.mkdirs();
			
			String filePath = realPath + File.separator + fileName;
			
			File saveFile = new File(filePath);
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
		
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public String detail(int id,Model model) {
		
		FreeDiary freeDiary = service.get(id);
		model.addAttribute("freeDiary",freeDiary);
		
		List<FreeDiaryComment> commentList = commentService.getViewList(id);
		model.addAttribute("commentList",commentList);
		
		return "diary/freediary/detail";
	}
	
	@PostMapping("detail")
	public String commentReg(int id,FreeDiary freeDiary,FreeDiaryComment freeDiaryComment) {
		freeDiaryComment.setMemberId(4);
		freeDiaryComment.setFreeDiaryId(id);
		commentService.insert(freeDiaryComment);
		
		return "redirect:detail?id="+freeDiary.getId();
	}
	
	@RequestMapping("del")
	public String delete(int id) {
		service.delete(id);
		return "redirect:list";
	}
	
	@RequestMapping("commentdel")
	public String commentdelete(int id,int freeDiaryId) {
		commentService.delete(id);
		return "redirect:detail?id="+freeDiaryId;
	}
	
	@GetMapping("edit")
	public String edit(int id,Model model) {
		
		FreeDiary freeDiary = service.get(id);
		model.addAttribute("freeDiary",freeDiary);
		
		return "diary/freediary/edit";
	}
	
	@PostMapping("edit")
	public String edit(FreeDiary freeDiary) {
		service.update(freeDiary);
		return "redirect:detail?id="+freeDiary.getId();
	}
	
	
	
}
