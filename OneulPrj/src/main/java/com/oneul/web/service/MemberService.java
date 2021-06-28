package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.Member;

public interface MemberService {
	Member get(String userId);
	List<Member> getList();
	
	int check_id(String userId);
	int insert(Member member);
	
	int updatebyid(Member member);
	int updatebyname(Member member);
	
	int delete(int id);

}
