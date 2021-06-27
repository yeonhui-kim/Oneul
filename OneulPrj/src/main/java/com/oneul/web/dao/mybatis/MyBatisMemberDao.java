package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.MemberDao;
import com.oneul.web.entity.Member;

@Repository
public class MyBatisMemberDao implements MemberDao {
	
	private SqlSession sqlSession;
	private MemberDao mapper;
	
	@Autowired
	public MyBatisMemberDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(MemberDao.class);
	}
	
	@Override
	public Member get(String userId) {

		return mapper.get(userId);
	}

	@Override
	public List<Member> getList() {

		return null;
	}

	@Override
	public int insert(Member member) {

		return mapper.insert(member);
	}

	@Override
	public int updatebyid(Member member) {

		return mapper.updatebyid(member);
	}
	
	@Override
	public int updatebyname(Member member) {

		return mapper.updatebyname(member);
	}

	@Override
	public int delete(int id) {

		return mapper.delete(id);
	}

	@Override
	public int check_id(String userId) {
		return mapper.check_id(userId);
	}

}
