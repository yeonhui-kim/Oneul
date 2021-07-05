package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.FreeDiaryCommentDao;
import com.oneul.web.dao.MyPageDao;
import com.oneul.web.entity.MyComment;
import com.oneul.web.entity.MyDiary;
import com.oneul.web.entity.MyOneline;


@Repository
public class MyBatisMyPageDao implements MyPageDao {
	
	private SqlSession sqlSession;
	private MyPageDao mapper;
	
	
	@Autowired
	public MyBatisMyPageDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(MyPageDao.class);
	}
	
	

	@Override
	public List<MyDiary> getDiaryList(int id) {
		
		return mapper.getDiaryList(id);
	}

	@Override
	public List<MyComment> getCommentList(int id) {
		
		return mapper.getCommentList(id);
	}



	@Override
	public List<MyOneline> getOnelineList(int id) {
		// TODO Auto-generated method stub
		return mapper.getOnelineList(id);
	}

}
