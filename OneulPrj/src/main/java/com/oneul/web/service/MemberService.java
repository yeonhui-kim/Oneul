package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.Member;

public interface MemberService {
	Member get(String userId);
	List<Member> getList();
	
	int check(Member member);
	int insert(Member member);
	String findid(Member member);
	
	void sendEmail(String toAddress, String subject, String body);

	
	int updatebyid(Member member);
	int updatebyname(Member member);
	
	int delete(int id);

}
