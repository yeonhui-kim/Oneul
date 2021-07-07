package com.oneul.web.controller;

//import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneul.web.entity.CalendarEmotion;
import com.oneul.web.entity.GratitudeDiary;
import com.oneul.web.entity.GratitudeDiaryComment;
import com.oneul.web.entity.Member;
import com.oneul.web.service.CalendarEmotionService;
import com.oneul.web.service.GratitudeDiaryCommentService;
import com.oneul.web.service.GratitudeDiaryService;
import com.oneul.web.service.MemberService;

@Controller
@RequestMapping("/diary/gratitudeDiary")
public class GratitudeDiaryController {

	@Autowired
	private CalendarEmotionService calendarService;
	@Autowired
	private GratitudeDiaryService service;
	@Autowired
	private MemberService memberSerivce;
	@Autowired
	private GratitudeDiaryCommentService commentService;
	
	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);//세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");
		Member member = new Member();
		member = memberSerivce.get(username);
		int id = member.getId();
		
		List<GratitudeDiary> list = service.getList(id);
		
		model.addAttribute("list",list);
		
		return "diary/gratitudeDiary/list";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		
		return "diary/gratitudeDiary/reg";
	}
	
	@PostMapping("reg")
	public String reg(@ModelAttribute GratitudeDiary gratitudeDiary, 
						@ModelAttribute CalendarEmotion calendarEmotion, 
						@DateTimeFormat(pattern = "yyyy-MM-dd")Date regDate,
						HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);//세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");
		Member member = new Member();
		member = memberSerivce.get(username);
		int id = member.getId();
		
		gratitudeDiary.setMemberId(id);
		gratitudeDiary.setRegDate(regDate);

		// --------------------달력 서비스----------------------------
		calendarEmotion.setMemberId(gratitudeDiary.getMemberId());
		calendarEmotion.setRegDate(gratitudeDiary.getRegDate());
		
		//1. 현재 로그인한 사용자가 해당 날짜에 감정을 등록한적 있는지 확인
		int cnt = calendarService.selectCalEmotionCnt(calendarEmotion);
		
		if( cnt > 0 ) {
			calendarService.updateCalendar(calendarEmotion);
		} else {
			calendarService.insertCalendar(calendarEmotion);
		}
		// --------------------달력 서비스----------------------------
		
		service.insertDiary(gratitudeDiary);
		
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public String detail(int id, Model model, HttpServletRequest request) {
		
		GratitudeDiary gratitudeDiary = service.get(id);
		model.addAttribute("gratitudeDiary",gratitudeDiary);
		
		// 상세페이지내 댓글리스
		List<GratitudeDiaryComment> commentList = commentService.getViewList(id);
		model.addAttribute("commentList", commentList);
		// 회원정보보내기
		HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("username");    
        Member member = memberSerivce.get(username);
        model.addAttribute("member", member);
		
		return "diary/gratitudeDiary/detail";
	}
	
	//답글달기
	@PostMapping("detail")
	public String commentReg(GratitudeDiaryComment gratitudeDiaryComment, HttpServletRequest request) {// 메소드이름은상관x
		HttpSession session = request.getSession(true);//세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");
		Member member = new Member();
		member = memberSerivce.get(username);
		int id = member.getId();
		
		gratitudeDiaryComment.setMemberId(id);
		
		gratitudeDiaryComment.setCommentId(gratitudeDiaryComment.getCommentId());//부모댓글
		gratitudeDiaryComment.setGratitudeDiaryId(gratitudeDiaryComment.getGratitudeDiaryId());//일기번호
		gratitudeDiaryComment.setContent(gratitudeDiaryComment.getContent());
		 commentService.insert(gratitudeDiaryComment); //

		return "redirect:detail?id=" + gratitudeDiaryComment.getGratitudeDiaryId();
	}
	
	@RequestMapping("del")
	public String delete(int id) {

		GratitudeDiary gratitudeDiary = service.get(id);
		gratitudeDiary.getMemberId();
		gratitudeDiary.getRegDate();
		
		CalendarEmotion calendarEmotion = new CalendarEmotion();
		calendarEmotion.setMemberId(gratitudeDiary.getMemberId());
		calendarEmotion.setRegDate(gratitudeDiary.getRegDate());
		
		//1. 현재 로그인한 사용자가 해당 날짜에 감정을 등록한적 있는지 확인
		int cnt = calendarService.selectCalEmotionCnt(calendarEmotion);
		System.out.println(cnt);
		if(cnt == 1) {
			calendarService.deleteCalendar(calendarEmotion);
		}
			
		service.delete(id);
		
		return "redirect:list";
	}
	
	//댓글삭제
	@RequestMapping("commentdel")
	public String commentdelete(int id, int gratitudeDiaryId) {
		commentService.delete(id);
		return "redirect:detail?id=" + gratitudeDiaryId;
	}
	
	@GetMapping("edit")
	public String edit(int id, Model model) {
		
		GratitudeDiary gratitudeDiary = service.get(id);
		model.addAttribute("gratitudeDiary",gratitudeDiary);
		
		return "diary/gratitudeDiary/edit";
	}
	
	@PostMapping("edit")
	public String edit(GratitudeDiary gratitudeDiary,
			  					Integer prevEmotionId,
						@DateTimeFormat(pattern = "yyyy-MM-dd")Date regDate,
						@DateTimeFormat(pattern = "yyyy-MM-dd")Date prevRegDate,
						CalendarEmotion calendarEmotion)
	{
		int cnt = calendarService.selectCalEmotionCnt(calendarEmotion);
		int cntPrev = calendarService.selectCalEmotionPrevCnt(calendarEmotion);
		
		if(gratitudeDiary.getEmotionId() != null) { //감정 변경했을 경우
			if(prevRegDate == regDate) { // 날짜 변경 안했을 경우
				calendarService.updateCalendar(calendarEmotion); // 감정 update				
			}else { // 날짜 변경했을 경우
				if(cnt == 0) { // 등록된 일기 없을때
					calendarService.insertCalendar(calendarEmotion); // 감정 insert
				}else { // 등록된 일기 있을때
					calendarService.updateCalendar(calendarEmotion); // 감정 update	
				}
				if(cntPrev == 0) { // 변경 전 날짜에 등록된 일기 없을 때
					calendarService.deleteCalendarPrev(calendarEmotion); // 변경 전 날짜의 감정 삭제
				}
			}
		}else { // 감정 변경 안했을 경우
			if(prevRegDate != regDate) { // 날짜 변경 했을 경우
				int prevEmotion = prevEmotionId; 
				calendarEmotion.setEmotionId(prevEmotion); // 전에 등록했던 감정을 캘린더에 set
				if(cnt == 0) { // 등록된 일기 없을때
					calendarService.insertCalendar(calendarEmotion); // 감정 insert
				}else { // 등록된 일기 있을때
					calendarService.updateCalendar(calendarEmotion); // 감정 update	
				}
				
			} //날짜 변경 안했을 경우
		}
		
		
		service.updateDiary(gratitudeDiary);
		
		return "redirect:detail?id="+gratitudeDiary.getId();
	}
	//댓글수정
	@PostMapping("commentedit")
	public String commentedit(GratitudeDiaryComment gratitudeDiaryComment) {
		commentService.update(gratitudeDiaryComment);
		return "redirect:detail?id=" + gratitudeDiaryComment.getGratitudeDiaryId();
	}
	
}
