package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.FutureDiaryCommentDao;
import com.oneul.web.entity.FutureDiaryComment;


@Repository
public class MyBatisFutureDiaryCommentDao implements FutureDiaryCommentDao {

	private SqlSession sqlSession;

	private FutureDiaryCommentDao mapper;
	
	
	@Autowired
	public MyBatisFutureDiaryCommentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		this.mapper = sqlSession.getMapper(FutureDiaryCommentDao.class);
	}
	
	
	
	@Override
	public FutureDiaryComment get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<FutureDiaryComment> getMainList(int futureDiaryId) {
		// TODO Auto-generated method stub
		return mapper.getMainList(futureDiaryId);
	}

	@Override
	public List<FutureDiaryComment> getSubList(int commentId) {
		// TODO Auto-generated method stub
		return mapper.getSubList(commentId);
	}

	@Override
	public int getCount(int futureDiaryId) {
		// TODO Auto-generated method stub
		return mapper.getCount(futureDiaryId);
	}

	@Override
	public int insert(FutureDiaryComment futureDiary) {
		// TODO Auto-generated method stub
		return mapper.insert(futureDiary);
	}

	@Override
	public int update(FutureDiaryComment futureDiary) {
		// TODO Auto-generated method stub
		return mapper.update(futureDiary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}
	

}
