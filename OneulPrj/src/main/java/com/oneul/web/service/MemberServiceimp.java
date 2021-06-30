package com.oneul.web.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.MemberDao;
import com.oneul.web.entity.Member;

@Service
public class MemberServiceimp implements MemberService {
	
	@Autowired
	private MemberDao memberdao;
	
	@Override
	public Member get(String userId) {

		return memberdao.get(userId);
	}

	@Override
	public List<Member> getList() {

		return null;
	}
	
	@Override
	public int check_id(String userId) {
		
		return memberdao.check_id(userId);
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

