package com.oneul.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oneul.web.entity.Member;
import com.oneul.web.entity.MyComment;
import com.oneul.web.entity.MyDiary;
import com.oneul.web.service.MemberService;
import com.oneul.web.service.MyPageService;

@Controller("MyPageController")
public class MypageController {
	
	// 사실 서비스는 하나만 가져와야 한다
	@Autowired
	private MemberService service;
	
	@Autowired
	private MyPageService myPageService;
	
	
	@GetMapping("/mypage")
	public String getMyPage(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String username =(String)session.getAttribute("username");
		Member member =  service.get(username);
		
		List<MyDiary> myDiary = myPageService.getDiaryList(member.getId());
		List<MyComment> myComment = myPageService.getCommentList(member.getId());
		
		
		
		
		model.addAttribute("member", member);
		model.addAttribute("myComment", myComment);
		model.addAttribute("myDiary", myDiary);
		
		System.out.println(myComment);
		System.out.println(member.getId());
	
		
		return "/mypage/mypage";
	}
	
	
	
//	
//	@PostMapping("/mypage/upload")
//	public String postMyPageUpload(MultipartFile multiFile, HttpServletRequest request, Model model) {
//		
//		HttpSession session = request.getSession(true);							//session으로 username 찾기		
//		String username = (String) session.getAttribute("username");			//session으로 username 찾기
//		
//		
//		
//		
//		
//		String multiFileName = multiFile.getOriginalFilename();						// fileAbsolutePath 찾기
//		// JPG, JPEG, GIF, PNG 얘가 이런 형식 만족하는지 check;
//		
//		ServletContext application = request.getServletContext(); 					// fileAbsolutePath 찾기
//		String folderRelativePath = "/upload/profile";								// fileAbsolutePath 찾기
//		String folderAbsolutePath = application.getRealPath(folderRelativePath);	// fileAbsolutePath 찾기
//		
//		File folder = new File(folderAbsolutePath);
//		if(!folder.exists()) //upload할 경로 존재x하면
//			folder.mkdirs(); //경로 생성
//		
//		String fileAbsolutePath = folderAbsolutePath + File.separator + multiFileName; // fileAbsolutePath 찾음
//		
//		File uploadFile = new File(fileAbsolutePath); //fileAbsolutePath로 만든 파일객체
//		
//		try {
//			multiFile.transferTo(uploadFile);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		Member updateMember = new Member();      //db 에 새로운 file name 전달
//		updateMember.setUserId(username);			//db 에 새로운 file name 전달
//		updateMember.setImage(multiFileName);		//db 에 새로운 file name 전달
//		service.update(updateMember);				//db 에 새로운 file name 전달
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		Member newMember = service.get(username);		// redirect 하기위해 model에 심기
//		model.addAttribute("member", newMember);		// redirect 하기위해 model에 심기
//		
//		
//		return "redirect:/mypage";
//	}
//	
	
	
	
	
	
}
