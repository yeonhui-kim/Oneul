package com.oneul.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneul.web.entity.Member;
import com.oneul.web.entity.Oneline;
import com.oneul.web.entity.PublicDiary;
import com.oneul.web.service.MemberService;
import com.oneul.web.service.OnelineCommentService;
import com.oneul.web.service.OnelineService;
import com.oneul.web.service.PublicDiaryService;

@Controller("PublicDiaryController")
@RequestMapping("/feed/publicdiary/")
public class PublicDiaryController {
	
	   @Autowired
	   private OnelineService service; //한줄일기 service

	   @Autowired
	   private OnelineCommentService cservice; //한줄일기 댓글 service

	   @Autowired
	   private MemberService mservice; //member서비스 
	   
	   @Autowired
	   private PublicDiaryService pservice;
	
	 @RequestMapping("list")
	   public String list(Model model, HttpServletRequest request,
			   @RequestParam(name = "p", defaultValue = "1") Integer page,
			   @RequestParam(name = "f", defaultValue = "FreeDiary") String field,
				@RequestParam(name = "q", defaultValue = "") String query) {
	      List<PublicDiary> list = pservice.getList(page,field,query);
	      /* list.get(0).getContent() */
	      
	      model.addAttribute("list", list);
	     
	      //-----------------------------------------------------
	      HttpSession session = request.getSession(true);
	      String username = (String) session.getAttribute("username");    
	      Member member2 = mservice.get(username);
	     
	      Member member = new Member();
	      member.setUserId(username);
	      model.addAttribute("member", member2);
	      
	      return "feed/publicdiary/list";
	   }
	

}
