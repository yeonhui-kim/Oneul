package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.Member;

public interface MemberDao {
	Member getbyname(String userId);
	Member getbyid(int id);
	List<Member> getList();
	
	int insert(Member member);
	String findid(Member member);
	
	int updatebyid(Member member);
	int updatebyname(Member member);
	int delete(int id);
	
	int check(Member member);
	int checkid(String username);
}
