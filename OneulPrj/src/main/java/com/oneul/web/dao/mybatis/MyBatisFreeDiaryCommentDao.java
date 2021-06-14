package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.FreeDiaryCommentDao;
import com.oneul.web.entity.FreeDiaryComment;


@Repository
public class MyBatisFreeDiaryCommentDao implements FreeDiaryCommentDao {

	private SqlSession sqlSession;
	private FreeDiaryCommentDao mapper;
	
	
	@Autowired
	public MyBatisFreeDiaryCommentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(FreeDiaryCommentDao.class);
	}
	
	
	
	@Override
	public FreeDiaryComment get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<FreeDiaryComment> getMainList(int freeDiaryId) {
		// TODO Auto-generated method stub
		return mapper.getMainList(freeDiaryId);
	}

	@Override
	public List<FreeDiaryComment> getSubList(int commentId) {
		// TODO Auto-generated method stub
		return mapper.getSubList(commentId);
	}

	@Override
	public int getCount(int freeDiaryId) {
		// TODO Auto-generated method stub
		return mapper.getCount(freeDiaryId);
	}

	@Override
	public int insert(FreeDiaryComment freeDiary) {
		// TODO Auto-generated method stub
		return mapper.insert(freeDiary);
	}

	@Override
	public int update(FreeDiaryComment freeDiary) {
		// TODO Auto-generated method stub
		return mapper.update(freeDiary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}
	

}
