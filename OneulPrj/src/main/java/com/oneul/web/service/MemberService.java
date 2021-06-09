package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.Member;

public interface MemberService {
	Member get(int id);
	List<Member> getList();
	
	int insert(Member member);
	int update(Member member);
	int delete(int id);
}
