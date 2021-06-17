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
	public int update(Member member) {

		return memberdao.update(member);
	}
	
	@Override
	public int delete(int id) {

		return 0;
	}

	@Override
	public int member_plus(Member member) {

		if(check_id(member.getUserId())==1) { //아이디 중복 있으면
			return 0;
		}
		else { //아이디 중복 없으면
			return 0;			
		}
		
	}


	
	




}
