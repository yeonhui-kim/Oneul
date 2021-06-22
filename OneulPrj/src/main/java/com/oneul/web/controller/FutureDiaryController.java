package com.oneul.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oneul.web.entity.FutureDiary;
import com.oneul.web.entity.FutureDiaryComment;
import com.oneul.web.service.FutureDiaryCommentService;
import com.oneul.web.service.FutureDiaryService;

@Controller
@RequestMapping("/diary/futurediary/")
public class FutureDiaryController {

	@Autowired
	private FutureDiaryService service;
	
	@Autowired
	private FutureDiaryCommentService commentService;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<FutureDiary> list = service.getList(1);
		
		model.addAttribute("list", list);
		return("diary/futurediary/list");
	}
	
	@RequestMapping("detail")
	public String detail(Model model, int id) {
		FutureDiary futureDiary = service.get(id);
		
		model.addAttribute("futureDiary", futureDiary);
		
		List<FutureDiaryComment> list = commentService.getViewList(id);
		model.addAttribute("commentList", list);
		return("diary/futurediary/detail");
	}
	
//	@PostMapping("detail")
//	public String detail() {
//		
//	}
	
	@PostMapping("reg")
	public String reg(@DateTimeFormat(pattern = "yyyy-MM-dd")Date bookingDate, 
					  String content,
					  MultipartFile file,
					  String pub,
					  String emotion,
					  HttpServletRequest request) {
		int p = Integer.parseInt(pub);
		int emt = Integer.parseInt(emotion);
		String fileName = file.getOriginalFilename();
		
		ServletContext application = request.getServletContext();
		String path = "/upload";
		String realPath = application.getRealPath(path);
		
		File pathFile = new File(realPath);
		if(!pathFile.exists())
			pathFile.mkdirs();
		
		String filePath = realPath + File.separator + fileName;
		
		System.out.println(filePath);
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
		
		FutureDiary futureDiary = new FutureDiary();	
		futureDiary.setBookingDate(bookingDate);
		futureDiary.setContent(content);
		futureDiary.setMemberId(4);
		futureDiary.setPub(p);
		futureDiary.setEmotionId(emt);
		futureDiary.setImage(fileName);
		service.insert(futureDiary);
		
		return("redirect:list");
	}
	@GetMapping("reg")
	public String reg() {
		return("diary/futurediary/reg");
	}
	
	@GetMapping("edit")
	public String edit(int id,Model model) {
		FutureDiary futureDiary = service.get(id);
		
		model.addAttribute("futureDiary", futureDiary);
		return("diary/futurediary/edit");
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
