package com.oneul.web.service;

import java.util.List;

import com.oneul.web.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.entity.Member;

@Service
public class MemberServiceimp implements MemberService {
	
	@Autowired
	private MemberDao memberdao;
	
	@Override
	public Member get(int id) {

		return null;
	}

	@Override
	public List<Member> getList() {

		return null;
	}

	@Override
	public int insert(Member member) {

		return memberdao.insert(member);
	}

	@Override
	public int update(Member member) {

		return 0;
	}

	@Override
	public int delete(int id) {

		return 0;
	}

}
