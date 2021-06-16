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
	public Member get(int id) {

		return mapper.get(id);
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
	public int update(Member member) {

		return mapper.update(member);
	}

	@Override
	public int delete(int id) {

		return 0;
	}

	@Override
	public int check_id(String userId) {
		return mapper.check_id(userId);
	}

}
