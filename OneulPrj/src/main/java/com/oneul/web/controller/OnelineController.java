package com.oneul.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.Member;
import com.oneul.web.entity.Oneline;
import com.oneul.web.entity.OnelineComment;
import com.oneul.web.service.MemberService;
import com.oneul.web.service.OnelineCommentService;
import com.oneul.web.service.OnelineService;

@Controller("OnelineController")
@RequestMapping("/feed/oneline/")

public class OnelineController {

   @Autowired
   private OnelineService service;

   @Autowired
   private OnelineCommentService cservice;

   @Autowired
   private MemberService mservice;

   @RequestMapping("list")
   public String list(Model model, HttpServletRequest request) {
      List<Oneline> list = service.getList();
      /* list.get(0).getContent() */
      model.addAttribute("list", list);
      
      //-----------------------------------------------------
      HttpSession session = request.getSession(true);
      String username = (String) session.getAttribute("username");    
      Member member2 = mservice.get(username);
     
      Member member = new Member();
      member.setUserId(username);
      model.addAttribute("member", member2);
      
      return "feed/oneline/list";
   }

   @GetMapping("detail")
   public String detail(Model model, int id, HttpServletRequest request) {
      Oneline oneline = service.get(id);
      model.addAttribute("detail", oneline);

      List<OnelineComment> clist = cservice.getViewList(id);
      model.addAttribute("clist", clist);
      
      HttpSession session = request.getSession(true);
      String username = (String) session.getAttribute("username");    
      Member member2 = mservice.get(username);
     
      Member member = new Member();
      member.setUserId(username);
      model.addAttribute("member", member2);

      return "feed/oneline/detail";
   }

   // ---------------detail에서 댓글 입력---------------------------
   @PostMapping("CommentReg") // 댓글등록 1.멤버아이디,content,onelineId(게시글아이디),writerId로그인사용자아이디,image
   public String commentReg(HttpServletRequest request, String comment ,int id) {
      // ------로그인 유저네임-------
      HttpSession session = request.getSession(true);
      String username = (String) session.getAttribute("username");
      Member member2 = mservice.get(username); 
      Integer memberId = member2.getId(); //로그인한 멤버 아이디
      String writerId = member2.getUserId(); // 로그인 유저아이디
      String image = member2.getImage(); //로그인 이미지
      
      OnelineComment onelineComment = new OnelineComment();
      onelineComment.setContent(comment);
      onelineComment.setMemberId(memberId);
      onelineComment.setWriterId(writerId);
      onelineComment.setImage(image);
      onelineComment.setOnelineId(id); //현재 게시글 아이디 넣어주기....                           
      cservice.insert(onelineComment);

      return "redirect:detail?id=" + id;
   }

   @GetMapping("reg")
   public String reg(Model model) {

      return "feed/oneline/reg";
   }

   @PostMapping("reg") // list reg
   public String reg(String content,HttpServletRequest request, Model model) {

      // ------로그인 유저네임-------
      HttpSession session = request.getSession(true);
      String username = (String) session.getAttribute("username");// 1.세션에 가져온 유저네임을 문자열로 만들었다

      Member member2 = mservice.get(username); // 2.서비스객체에 .get(세션에가져온이름)을 넣었다
      String name = member2.getName(); //로그인 이름
      Integer memberId = member2.getId(); // 로그인세션 memberId
      String writerId2 = member2.getUserId(); // 로그인 아이디
      String image = member2.getImage();

//      Member member = new Member();
//      member.setUserId(username);
//      member.setName(name);
//      member.setImage(image);
//      model.addAttribute("member", member2);

      Oneline oneline = new Oneline();
      oneline.setContent(content);
      oneline.setMemberId(memberId);
      oneline.setWriterId(writerId2);
      oneline.setImage(image);

      service.insert(oneline);

      return "redirect:list"; // 객체 형태로 리턴 //list로 돌아감

   }

   @RequestMapping("del")
   public String del(int id) {

      service.delete(id);
      return "redirect:list";
   }

   @RequestMapping("cdel")
   public String cdel(int id) {

      cservice.delete(id);
      return "redirect:list";
   }

   @GetMapping("edit")
   public String edit(int id, Model model) {
      Oneline oneline = service.get(id);
      model.addAttribute("Oneline", oneline);

      return "feed/oneline/edit";

   }

   @PostMapping("edit")
   public String edit(Oneline oneline) {
      service.update(oneline);

      return "redirect:list";
   }

}