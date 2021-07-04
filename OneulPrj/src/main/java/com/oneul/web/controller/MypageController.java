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
import com.oneul.web.entity.MyOneline;
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
		List<MyOneline> myOneline = myPageService.getOnelineList(member.getId());
		
		
		
		model.addAttribute("member", member);
		model.addAttribute("myComment", myComment);
		model.addAttribute("myDiary", myDiary);
		model.addAttribute("myOneline",myOneline);

	
		
		return "/mypage/mypage";
	}
	
	
	

	@PostMapping("/mypage/reg")
	public String postMyPageReg(MultipartFile multiFile, HttpServletRequest request, String email, String introduction) {
		
		System.out.println(email);
		System.out.println(introduction);
		
		HttpSession session = request.getSession(true);							// session으로 username 찾기		
		String userName = (String) session.getAttribute("username");			// session으로 username 찾기
		
		Member member =  service.get(userName);									// userName으로 member 객체얻기
		int id = member.getId();												// member의 id를 얻기
		ServletContext application = request.getServletContext(); 					// application 뺴놓기
		
		
		
		String originalFileName = member.getImage();									// 삭제할 파일이름얻음 여기서
		String uploadFileName = multiFile.getOriginalFilename(); 						// 업로드할 fileName 얻음
		
		
		// 파일이 온게 없으면 스트링만 update하고 끝
		if(uploadFileName == null || uploadFileName.equals("")) {
			
			
			// 업로드한 파일 DB 최신화
			member.setEmail(email);
			member.setIntroduction(introduction);
			service.updatebyname(member);
			
			
			return "redirect:/mypage";

		}
		
		
		
		
		// 파일이 온게잇으면 아래 로직 시작
		if(originalFileName != "basic.jpg") {											// basic.jpg 아닐때만 기존 파일 삭제
			
			
			String folderRelativePath = "/upload/profile/" +	id;						// fileAbsolutePath 찾기 여기서 id폴더를 추가함
			String folderAbsolutePath = application.getRealPath(folderRelativePath);	// fileAbsolutePath 찾기
			
			File folder = new File(folderAbsolutePath);
			if(!folder.exists()) //upload할 경로 존재x하면
				folder.mkdirs(); //경로 생성
			
			String fileAbsolutePath = folderAbsolutePath + File.separator + originalFileName; // fileAbsolutePath 찾음
			
			
			// db의 img의 이름이 basic.jpg 가아닐때 기존의 파일 삭제
			File file = new File(fileAbsolutePath); 
			if( file.exists() ){ 
				if(file.delete()){ 
					System.out.println("파일삭제 성공"); 
				}else{ 
					System.out.println("파일삭제 실패"); 
				} 
			}else{ 
				System.out.println("파일이 존재하지 않습니다."); 
			}
			
			

			
		}	
		
		
		
		
		
		// 업로드할 파일 경로 구하기
		String folderRelativePath = "/upload/profile/" +	id;						// fileAbsolutePath 찾기 여기서 id폴더를 추가함
		String folderAbsolutePath = application.getRealPath(folderRelativePath);	// fileAbsolutePath 찾기
		
		File folder = new File(folderAbsolutePath);
		if(!folder.exists()) //upload할 경로 존재x하면
			folder.mkdirs(); //경로 생성
		
		String fileAbsolutePath = folderAbsolutePath + File.separator + uploadFileName; // fileAbsolutePath 찾음
		
		
		File file = new File(fileAbsolutePath); 

		try {
			multiFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		// 업로드한 파일 DB 최신화
		member.setImage(uploadFileName);
		member.setEmail(email);
		member.setIntroduction(introduction);
		service.updatebyname(member);
		
		
		

		
		
		return "redirect:/mypage";
	}
	
	
	
	
	
	

	@GetMapping("/mypage/reg")
	public String postMyPageDel(HttpServletRequest request , String email, String introduction) {
		
		HttpSession session = request.getSession(true);							// session으로 username 찾기		
		String userName = (String) session.getAttribute("username");			// session으로 username 찾기
		
		Member member =  service.get(userName);									// userName으로 member 객체얻기
		int id = member.getId();												// member의 id를 얻기
		
		
		
		String fileName = member.getImage();								// 삭제할 파일이름얻음 여기서
		
		
		
		if(fileName != "basic.jpg") {										// basic.jpg 아닐때만 기존 파일 삭제
			
			
			ServletContext application = request.getServletContext(); 					// fileAbsolutePath 찾기
			String folderRelativePath = "/upload/profile/" +	id;						// fileAbsolutePath 찾기 여기서 id폴더를 추가함
			String folderAbsolutePath = application.getRealPath(folderRelativePath);	// fileAbsolutePath 찾기
			
			File folder = new File(folderAbsolutePath);
			if(!folder.exists()) //upload할 경로 존재x하면
				folder.mkdirs(); //경로 생성
			
			String fileAbsolutePath = folderAbsolutePath + File.separator + fileName; // fileAbsolutePath 찾음
			
			
			// db의 img의 이름이 basic.jpg 가아닐때 기존의 파일 삭제
			File file = new File(fileAbsolutePath); 
			if( file.exists() ){ 
				if(file.delete()){ 
					System.out.println("파일삭제 성공"); 
				}else{ 
					System.out.println("파일삭제 실패"); 
				} 
			}else{ 
				System.out.println("파일이 존재하지 않습니다."); 
			}
			
			
			
			//db 에 basic.jpg 과 introduction 과 email 전달
			member.setImage("basic.jpg");
			member.setEmail(email);
			member.setIntroduction(introduction);
			service.updatebyname(member);
		}	
			

	
		
		return "redirect:/mypage";
	}
	
	
	
}
