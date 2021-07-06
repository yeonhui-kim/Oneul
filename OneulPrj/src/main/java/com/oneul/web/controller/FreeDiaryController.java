package com.oneul.web.controller;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.oneul.web.entity.CalendarEmotion;
import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.FreeDiaryComment;
import com.oneul.web.entity.GratitudeDiary;
import com.oneul.web.entity.Member;
import com.oneul.web.entity.Question;
import com.oneul.web.service.CalendarEmotionService;
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
	private MemberService memberService;
	@Autowired
	private CalendarEmotionService calendarService;

	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);// 세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");
		Member member = new Member();
		member = memberService.get(username);
		int id = member.getId();

		// List<FreeDiary> list = service.getList();//모든 일기목록
		List<FreeDiary> list = service.getList(id);// 해당아이디 일기리스트
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
	public String reg(@DateTimeFormat(pattern = "yyyy-MM-dd") Date regDate, FreeDiary freeDiary, MultipartFile file,
			HttpServletRequest request, CalendarEmotion calendarEmotion) {
		HttpSession session = request.getSession(true);// 세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");

		Member member = new Member();
		member = memberService.get(username);
		int id = member.getId();

		freeDiary.setRegDate(regDate);
		freeDiary.setMemberId(id);

		// --------------------달력 서비스----------------------------
		calendarEmotion.setMemberId(freeDiary.getMemberId());
		calendarEmotion.setRegDate(freeDiary.getRegDate());

		// 1. 현재 로그인한 사용자가 해당 날짜에 감정을 등록한적 있는지 확인
		int cnt = calendarService.selectCalEmotionCnt(calendarEmotion);

		if (cnt > 0) {
			calendarService.updateCalendar(calendarEmotion);
		} else {
			calendarService.insertCalendar(calendarEmotion);
		}
		// --------------------달력 서비스----------------------------

		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		freeDiary.setImage(fileName);
		service.insert(freeDiary);

		System.out.println("일기id:" + freeDiary.getId());
		int diaryId = freeDiary.getId();
		if (!fileName.equals("")) {
			ServletContext application = request.getServletContext();
			String path = "/upload/diary/freeDiary/" + id + "/" + diaryId; // 회원id + 일기id..
			String realPath = application.getRealPath(path);

			File pathFile = new File(realPath);
			if (!pathFile.exists())
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
		}

		return "redirect:list";
	}

	@GetMapping("detail")
	public String detail(int id, Model model, HttpServletRequest request) {
		// 다이어리 상세내역
		FreeDiary freeDiary = service.get(id);
		model.addAttribute("freeDiary", freeDiary);
		// 상세페이지내 댓글리스
		List<FreeDiaryComment> commentList = commentService.getViewList(id);
		model.addAttribute("commentList", commentList);// DTo가필요할지도, 엔티티끼리 조인이필요함->다음을 그릇이 필요하다 ->DTO
		System.out.println(commentList);
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		Member member2 = memberService.get(username);
		model.addAttribute("member", member2);

		return "diary/freediary/detail";
	}

	// 답글달기
	@PostMapping("detail")
	public String commentReg(FreeDiaryComment freeDiaryComment, HttpServletRequest request) {// 메소드이름은상관x
		HttpSession session = request.getSession(true);// 세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");

		Member member = new Member();
		member = memberService.get(username);
		int id = member.getId();

		freeDiaryComment.setMemberId(id);

		// freeDiaryComment.setMemberId(4);//회원아이디
		freeDiaryComment.setCommentId(freeDiaryComment.getCommentId());// 부모댓글
		freeDiaryComment.setFreeDiaryId(freeDiaryComment.getFreeDiaryId());// 일기번호
		freeDiaryComment.setContent(freeDiaryComment.getContent());
		commentService.insert(freeDiaryComment); //

		return "redirect:detail?id=" + freeDiaryComment.getFreeDiaryId();
	}

	@RequestMapping("del")
	public String delete(int id) {

		FreeDiary freeDiary = service.get(id);
		freeDiary.getMemberId();
		freeDiary.getRegDate();

		CalendarEmotion calendarEmotion = new CalendarEmotion();
		calendarEmotion.setMemberId(freeDiary.getMemberId());
		calendarEmotion.setRegDate(freeDiary.getRegDate());

		// 1. 현재 로그인한 사용자가 해당 날짜에 감정을 등록한적 있는지 확인
		int cnt = calendarService.selectCalEmotionCnt(calendarEmotion);
		System.out.println(cnt);
		if (cnt == 1) {
			calendarService.deleteCalendar(calendarEmotion);
		}

		service.delete(id);

		return "redirect:list";
	}

	// 댓글삭제
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
	public String edit(FreeDiary freeDiary, 
						MultipartFile file, 
						HttpServletRequest request, 
						int changed,
						String originalFile, 
						CalendarEmotion calendarEmotion) {
		System.out.println("changed"+changed);
		System.out.println(originalFile);
		
		int id = freeDiary.getId();
 
		
		HttpSession session = request.getSession(true);//세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");
		
		Member member = new Member();
		member = memberService.get(username);
		int memberId = member.getId();

		freeDiary.setMemberId(id);

		// 파일 수정안됐을 경우 원래 파일로 저장
		if (changed == 0) {
			freeDiary.setImage(originalFile);
		}

		String fileName = file.getOriginalFilename();

		// 파일 수정됐을 경우
		// 이전 파일 지우고 수정된 파일로 저장
		if (!fileName.equals("") && changed == 1) {

			ServletContext application = request.getServletContext();
			// 이전 파일 삭제
			String prevFilePath = "/upload/diary/freeDiary/" + memberId + "/" + id;
			String prevFilerealPath = application.getRealPath(prevFilePath);
			String deleteFilePath = prevFilerealPath + File.separator + originalFile;
			System.out.println(deleteFilePath);

			File deleteFile = new File(deleteFilePath);
			if (deleteFile.exists()) {
				// 파일 삭제.
				deleteFile.delete();
				System.out.println("삭제완료");
			}

			String path = "/upload/diary/freeDiary/" + memberId + "/" + id;
			String realPath = application.getRealPath(path);

			File pathFile = new File(realPath);
			if (!pathFile.exists())
				pathFile.mkdirs();

			String filePath = realPath + File.separator + fileName;

			// System.out.println(filePath);
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
			freeDiary.setImage(fileName);
		}

		// 파일 삭제됐을 경우
		if (fileName.equals("") && changed == 1) {

			ServletContext application = request.getServletContext();

			String prevFilePath = "/upload/diary/freeDiary/" + memberId + "/" + id;
			String prevFilerealPath = application.getRealPath(prevFilePath);

			File folder = new File(prevFilerealPath);
			while (folder.exists()) {
				File[] folder_list = folder.listFiles(); // 파일리스트 얻어오기

				for (int j = 0; j < folder_list.length; j++) {
					folder_list[j].delete(); // 파일 삭제
					System.out.println("파일이 삭제되었습니다.");

				}

				if (folder_list.length == 0 && folder.isDirectory()) {
					folder.delete(); // 대상폴더 삭제
					System.out.println("폴더가 삭제되었습니다.");
				}
			}

			freeDiary.setImage(fileName);
		}

		if (freeDiary.getEmotionId() != null)
			calendarService.updateCalendar(calendarEmotion);

		service.update(freeDiary);
		return "redirect:detail?id=" + freeDiary.getId();
	}

	// 댓글수정
	@PostMapping("commentedit")
	public String commentedit(FreeDiaryComment freeDiaryComment) {
		commentService.update(freeDiaryComment);
		return "redirect:detail?id=" + freeDiaryComment.getFreeDiaryId();
	}

}
