package com.oneul.web.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.oneul.web.service.MemberService;
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
	@Autowired
	private MemberService memberSerivce;

	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);//세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");
		Member member = new Member();
		member = memberSerivce.get(username);
		int id = member.getId();
		List<FreeDiary> list = service.getList();
		//List<FreeDiary> list = service.getList(id);
		model.addAttribute("list", list);

		return "diary/freediary/list";
	}

	@GetMapping("reg")
	public String reg(Model model) {
		List<Question> list = questionService.getList();
		model.addAttribute("list", list);

		return "diary/freediary/reg";
	}

	@PostMapping("reg")
	public String reg(FreeDiary freeDiary, MultipartFile file, HttpServletRequest request) {
		HttpSession session = request.getSession(true);//세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");
		
		Member member = new Member();
		member = memberSerivce.get(username);
		int id = member.getId();
		
		freeDiary.setMemberId(id);

		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		freeDiary.setImage(fileName);
		service.insert(freeDiary);
		ServletContext application = request.getServletContext();
		String path = "/upload";
		String realPath = application.getRealPath(path);

		File pathFile = new File(realPath);
		if (!pathFile.exists())
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

	@GetMapping("detail")
	public String detail(int id, Model model) {
		// 다이어리 상세내역
		FreeDiary freeDiary = service.get(id);
		model.addAttribute("freeDiary", freeDiary);
		// 상세페이지내 댓글리스
		List<FreeDiaryComment> commentList = commentService.getViewList(id);
		model.addAttribute("commentList", commentList);
		System.out.println(commentList);
		return "diary/freediary/detail";
	}
	//답글달기
	@PostMapping("detail")
	public String commentReg(FreeDiaryComment freeDiaryComment) {// 메소드이름은상관x

		 freeDiaryComment.setMemberId(4);//회원아이디
		 freeDiaryComment.setCommentId(freeDiaryComment.getCommentId());//부모댓글
		 freeDiaryComment.setFreeDiaryId(freeDiaryComment.getFreeDiaryId());//일기번호
		 freeDiaryComment.setContent(freeDiaryComment.getContent());
		 commentService.insert(freeDiaryComment); //

		return "redirect:detail?id=" + freeDiaryComment.getFreeDiaryId();
	}

	@RequestMapping("del")
	public String delete(int id) {
		service.delete(id);
		return "redirect:list";
	}
	//댓글삭제
	@RequestMapping("commentdel")
	public String commentdelete(int id, int freeDiaryId) {
		commentService.delete(id);
		return "redirect:detail?id=" + freeDiaryId;
	}

	@GetMapping("edit")
	public String edit(int id, Model model) {
		List<Question> list = questionService.getList();
		model.addAttribute("list", list);

		FreeDiary freeDiary = service.get(id);
		model.addAttribute("freeDiary", freeDiary);

		return "diary/freediary/edit";
	}

	@PostMapping("edit")
	public String edit(FreeDiary freeDiary) {
		service.update(freeDiary);
		return "redirect:detail?id=" + freeDiary.getId();
	}
	//댓글수정
	@PostMapping("commentedit")
	public String commentedit(FreeDiaryComment freeDiaryComment) {
		commentService.update(freeDiaryComment);
		return "redirect:detail?id=" + freeDiaryComment.getFreeDiaryId();
	}

}
