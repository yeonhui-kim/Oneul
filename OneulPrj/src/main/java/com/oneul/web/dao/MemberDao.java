package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.Member;

public interface MemberDao {
	Member get(String userId);
	List<Member> getList();
	
	int insert(Member member);
	int update(Member member);
	int delete(int id);
	
	int check_id(String userId);
}
