package com.oneul.web.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oneul.web.entity.Member;
import com.oneul.web.service.MemberService;

@Controller("MemberController")
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//회원가입페이지 조회
	@RequestMapping("signup") 
	public String signup(){
			
		return "member/signup";
	}
	
	//아이디 중복체크버튼
	@ResponseBody
	@PostMapping("checkId")
	public int check_id(String username) {
		
		//아이디 제약
		String unexp = "^[a-z0-9]{4,12}$";
		
		Member member = new Member();
		member.setUserId(username);
		
		int result = 2;
		if(username.equals("")) {
			return result;			
		}
		else if(!Pattern.matches(unexp, username)){
			result = 3;
			return result;
		}else {
			result = service.checkid(username);
			return result;
		}
	}
	
	//회원가입 실행
	@PostMapping("reg") 
	public String reg(String username,
						String password,
						String name,
						Date birthday,
						String email,
						Model model) {
		
		System.out.printf("origin pwd : %s\n", password);
		//암호화 도구
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		//암호화 하고 변수에 담음
		String encodedpwd = encoder.encode(password);
		System.out.printf("encoded pwd: %s\n", encodedpwd);
		
		
		Member member = new Member();
		member.setUserId(username);
		member.setPassword(encodedpwd);
		member.setName(name);
		member.setBirthday(birthday);
		member.setEmail(email);
		
		service.insert(member);
		
		return "redirect:/";
	}
	
	//아이디찾기페이지 조회
	@RequestMapping("findid")
	public String findid() {
		return "member/findid";		
	}
	
	//아이디 찾기 실행
	@PostMapping("findid")
	public String findid(String name, 
						 Date birthday, 
						 String email,
						 HttpServletRequest request, 
						 Model model) {
		
		//회원정보 체크
		Member member = new Member();
		member.setName(name);
		member.setBirthday(birthday);
		member.setEmail(email);
		int result = service.check(member);
		
		if(result==1) {
			//아이디 찾기 서비스
			String username = service.findid(member);
			member.setUserId(username);
			
			//아이디 session에 담기
			HttpSession session = request.getSession(true);
			session.setAttribute("member", member);
			
			return "redirect:foundid";
		}
		else {
			model.addAttribute("msg","존재하지 않는 회원정보입니다");
			return "member/findid";
		}
		
	}
	
	//아이디 찾은 후 페이지 조회
	@RequestMapping("foundid")
	public String foundid() {
		
		return "member/foundid";		
	}
	
	//비밀번호찾기 페이지 조회
	@RequestMapping("findpwd")
	public String findpwd() {
		return "member/findpwd";		
	}
	
	//비밀번호 찾기 수행
	@PostMapping("findpwd")
	public String findpwd(String username, 
						  String name, 
						  Date birthday, 
						  String email, 
						  Model model) {
		
		//회원정보체크
		Member member = new Member();
		member.setUserId(username);
		member.setName(name);
		member.setBirthday(birthday);
		member.setEmail(email);
		
		int result = service.check(member);
		
		if(result==1) { //회원정보 있으면
			//임시비밀번호생성
			String pwd = service.makePwd(10);
			
			//비밀번호 암호화
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedpwd = encoder.encode(pwd);
			
			//임시비밀번호로 변경
			member.setPassword(encodedpwd);
			service.updatebyname(member);
			
			//비밀번호 이메일 발송
			String title = "Oneul 임시비밀번호";
			String body = name+"님의 임시비밀번호는 "+pwd+" 입니다.";
			service.sendEmail(email, title, body);
			return "redirect:/?r=1";
			
		}else { //회원정보 없으면
			model.addAttribute("msg","존재하지 않는 회원정보입니다");
			return "member/findpwd";
		}
	}
	
	//회원정보수정 페이지 조회
	@RequestMapping("edit") 
	public String edit(Principal principal, Model model) {
		
		//회원아이디 얻기
		String username = principal.getName();
		
		Member member = new Member();
		member = service.get(username);
		
		model.addAttribute(member);
		
		return "member/edit";		
	}
	
	//수정 실행
	@PostMapping("edit")
	public String edit(Principal principal,
						String username,
						String password,
						String email) {
		
		//변경전 회원아이디
		String originUsername = principal.getName();
		
		//회원 식별 아이디
		Member member2 = new Member();
		member2 = service.get(originUsername);
		int id = member2.getId();
		
		//비밀번호 암호화
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedpwd = encoder.encode(password);
	
		Member member = new Member();
		member.setId(id);
		member.setUserId(username);
		member.setPassword(encodedpwd);
		member.setEmail(email);
		
		service.updatebyid(member);
		
		return "redirect:/doLogout";			
	}
	
	//아이디 중복체크버튼
	@ResponseBody
	@PostMapping("editCheckId")
	public int edit_check_id(String username, Principal principal) {
		
		//원래 아이디
		String prevname = principal.getName();
		
		//아이디 제약
		String unexp = "^[a-z0-9]{4,12}$";
		
		Member member = new Member();
		member.setUserId(username);
		
		int result = 2;
		if(username.equals(prevname)) {
			result = 4;
			return result;
		}
		else if(username.equals("")) {
			return result;			
		}
		else if(!Pattern.matches(unexp, username)){
			result = 3;
			return result;
		}else {
			result = service.checkid(username);
			return result;
		}
	}
	
	
	//프로필사진 업로드
	@PostMapping("upload") 
	public String upload(MultipartFile file, HttpServletRequest request, Model model, Principal principal) {
		//로그인 아이디 획득
		String username = principal.getName();
		
		//식별변호 획득
		Member member2 = service.get(username);
		int id = member2.getId();
		
		String fileName = file.getOriginalFilename();//파일이름
		
		ServletContext application = request.getServletContext();
		String path = "/upload/profile/"+id;
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
		
		Member member = new Member();
		member.setId(id);
		member.setUserId(username);
		member.setImage(fileName);
		service.updatebyname(member);
		
		
		model.addAttribute("member", member2);
		
		return "redirect:mypagetest";
	}
	
	//프로필기본사진으로 변경
	@GetMapping("basic")
	public String basic(Principal principal) {
		//로그인 아이디 획득
		String username = principal.getName();
		
		Member member = new Member();
		member.setUserId(username);
		member.setImage("basic.jpg");
		
		service.updatebyname(member);
		
		return "redirect:mypagetest";		
	}
	
	//회원탈퇴
	@GetMapping("out")
	public String out(Principal principal) {
		//로그인 아이디 획득
		String username = principal.getName();
		
		//식별변호 획득
		Member member = service.get(username);
		int id = member.getId();
		service.delete(id);
		
		
		return "redirect:/";
	}
}


