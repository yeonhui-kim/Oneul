package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.Member;

public interface MemberService {
	Member get(String userId);
	Member get(int id);
	List<Member> getList();
	
	int check(Member member);
	int insert(Member member);
	String findid(Member member);
	
	String makePwd(int length);
	void sendEmail(String toAddress, String subject, String body);

	
	int updatebyid(Member member);
	int updatebyname(Member member);
	
	int delete(int id);

}
