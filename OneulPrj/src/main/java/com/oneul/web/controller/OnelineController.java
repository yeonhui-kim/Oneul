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

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.FreeDiaryComment;
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

		// -----------------------------------------------------
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");

		Member member = new Member();
		if (username != null)
			member = mservice.get(username);
		else
			member.setId(0);

		model.addAttribute("member", member);

		return "feed/oneline/list";

	}

	@GetMapping("detail")
	public String detail(Model model, int id, HttpServletRequest request) {
		Oneline detail = service.get(id); // 여기서 멤버 이미지 불러오자...
		model.addAttribute("detail", detail);

		List<OnelineComment> commentList = cservice.getViewList(id);
		model.addAttribute("commentList", commentList);
		System.out.println(commentList);

		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		Member member2 = mservice.get(username);

//      Member member = new Member();
//      member.setUserId(username);
		model.addAttribute("member", member2);

		return "feed/oneline/detail";
	}

	// ---------------detail에서 댓글 입력---------------------------
//   @PostMapping("CommentReg") // 댓글등록 1.멤버아이디,content,onelineId(게시글아이디),writerId로그인사용자아이디,image
//   public String commentReg(HttpServletRequest request, String comment ,int id) {
//      // ------로그인 유저네임-------
//      HttpSession session = request.getSession(true);
//      String username = (String) session.getAttribute("username");
//      Member member2 = mservice.get(username); 
//      Integer memberId = member2.getId(); //로그인한 멤버 아이디
//      String writerId = member2.getUserId(); // 로그인 유저아이디
//      String image = member2.getImage(); //로그인 이미지
//      
//      OnelineComment onelineComment = new OnelineComment();
//      onelineComment.setContent(comment);
//      onelineComment.setMemberId(memberId);
//      onelineComment.setWriterId(writerId);
//      onelineComment.setImage(image);
//      onelineComment.setOnelineId(id); //현재 게시글 아이디 넣어주기....                           
//      cservice.insert(onelineComment);
//
//      return "redirect:detail?id=" + id;
//   }

//   @GetMapping("detail")
//	public String detail(int id, Model model, HttpServletRequest request) {
//		// 다이어리 상세내역
//		FreeDiary freeDiary = service.get(id);
//		model.addAttribute("freeDiary", freeDiary);
//		// 상세페이지내 댓글리스
//		List<FreeDiaryComment> commentList = commentService.getViewList(id);
//		model.addAttribute("commentList", commentList);//DTo가필요할지도, 엔티티끼리 조인이필요함->다음을 그릇이 필요하다 ->DTO
//		System.out.println(commentList);
//		HttpSession session = request.getSession(true);
//       String username = (String) session.getAttribute("username");    
//       Member member2 = memberSerivce.get(username);
//       model.addAttribute("member", member2);
//
//		return "diary/freediary/detail";
//	}

	// 답글달기
	@PostMapping("detail")
	public String commentReg(OnelineComment onelineComment, HttpServletRequest request) {// 메소드이름은상관x
		HttpSession session = request.getSession(true);// 세션에 유저네임을 넣어놨다->해당유저네임을꺼내기
		String username = (String) session.getAttribute("username");

		Member member = new Member();
		member = mservice.get(username);
		int id = member.getId();

		onelineComment.setMemberId(id);

		// freeDiaryComment.setMemberId(4);//회원아이디
		onelineComment.setCommentId(onelineComment.getCommentId());// 부모댓글
		onelineComment.setOnelineId(onelineComment.getOnelineId());// 일기번호
		onelineComment.setContent(onelineComment.getContent());
		cservice.insert(onelineComment); //

		return "redirect:detail?id=" + onelineComment.getOnelineId();
	}

	@GetMapping("reg")
	public String reg(Model model) {

		return "feed/oneline/reg";
	}

	@PostMapping("reg") // list reg
	public String reg(String content, HttpServletRequest request, Model model) {

		// ------로그인 유저네임-------
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");// 1.세션에 가져온 유저네임을 문자열로 만들었다

		Member member2 = mservice.get(username); // 2.서비스객체에 .get(세션에가져온이름)을 넣었다
		String name = member2.getName(); // 로그인 이름
		Integer memberId = member2.getId(); // 로그인세션 memberId
		String writerId2 = member2.getUserId(); // 로그인 아이디
		String image = member2.getImage();

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

	// 댓글삭제
	@RequestMapping("commentdel")
	public String commentdelete(int id, int onelineId) {
		cservice.delete(id);
		return "redirect:detail?id=" + onelineId;
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

		return "redirect:detail?id=" + oneline.getId();
	}
	
	//댓글수정
		@PostMapping("commentedit")
		public String commentedit(OnelineComment onelineComment) {
			cservice.update(onelineComment);
			return "redirect:detail?id=" + onelineComment.getOnelineId();
		}

}