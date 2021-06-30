package com.oneul.web.service;

import java.io.PrintWriter;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.MemberDao;
import com.oneul.web.entity.Member;

@Service
public class MemberServiceimp implements MemberService {
	
	@Autowired
	private MemberDao memberdao;
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public Member get(String userId) {

		return memberdao.get(userId);
	}

	@Override
	public List<Member> getList() {

		return null;
	}
	
	@Override
	public int check(Member member) {
		
		return memberdao.check(member);
	}

	@Override
	public int insert(Member member) {

		return memberdao.insert(member);
	}
	
	@Override
	public String findid(Member member) {
		
		return memberdao.findid(member);
	}
	
	@Override
	public String makePwd(int length) {
		int index = 0; char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
													'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
													'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
													'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
													'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
													'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' }; 
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			index = (int) (charArr.length * Math.random()); sb.append(charArr[index]); 
			} 
		return sb.toString();
	}
	
	@Override
	public void sendEmail(String toAddress, String subject, String body) {
	    
	  MimeMessage message = sender.createMimeMessage();
	  MimeMessageHelper helper = new MimeMessageHelper(message);
	  try {
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	    helper.setText(body);
	  } catch (MessagingException e) {
	    e.printStackTrace();
	  }
	 
	  sender.send(message);
	  
	}
	
	@Override
	public int updatebyid(Member member) {

		return memberdao.updatebyid(member);
	}
	
	@Override
	public int updatebyname(Member member) {

		return memberdao.updatebyname(member);
	}
	
	@Override
	public int delete(int id) {

		return memberdao.delete(id);
	}




		
}

