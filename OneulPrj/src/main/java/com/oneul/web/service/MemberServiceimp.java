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

