package com.oneul.web.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.ServiceConfigurationError;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.oneul.web.entity.Member;
import com.oneul.web.service.MemberService;

@Controller("MemberController")
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String errMsg;
		
		if(request.getAttribute("loginFailMsg")!=null) {
			errMsg = (String) request.getAttribute("loginFailMsg");
			model.addAttribute("errMsg", errMsg);
		}
		
		return "member/login";
	}
	

	@RequestMapping("signup")
	public String signup() {
		return "member/signup";		
	}
	
	@RequestMapping("logintest")
	public String logintest() {
		return "member/logintest";		
	}
	
	
	@PostMapping("reg") //회원가입
	public String reg(String username,
						String password,
						String name,
						Date birthday,
						String email) {
		
		Member member = new Member();
		member.setUserId(username);
		String noopPassword = "{noop}"+password;
		member.setPassword(noopPassword);
		member.setName(name);
		member.setBirthday(birthday);
		member.setEmail(email);
		
		service.insert(member);
		
		return "redirect:login";
		//헬로
	}
	
	
	@RequestMapping("mypagetest")
	public String mypage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		
		Member member2 = service.get(username);
		String fileName = member2.getImage();
		
		
		Member member = new Member();
		member.setUserId(username);
		member.setImage(fileName);
		model.addAttribute("member", member2);
		
		return "member/mypagetest";
	}
	
	@PostMapping("upload") //프로필사진 업로드
	public String upload(MultipartFile file, HttpServletRequest request, Model model, Principal principal) {
		String fileName = file.getOriginalFilename();//파일이름
		
		ServletContext application = request.getServletContext();
		String path = "/upload/profile";
		String realPath = application.getRealPath(path);
		
		File pathFile = new File(realPath);
		if(!pathFile.exists()) //upload할 경로 존재x하면
			pathFile.mkdirs(); //경로 생성
		
		String filePath = realPath + File.separator + fileName;
		
		File saveFile = new File(filePath); //저장할 파일
		
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		
		Member member = new Member();
		member.setUserId(username);
		member.setImage(fileName);
		service.update(member);
		
		Member member2 = service.get(username);
		model.addAttribute("member", member2);
		
		return "member/mypagetest";
	}

}


