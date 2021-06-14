package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.GratitudeDiaryCommentDao;
import com.oneul.web.entity.GratitudeDiaryComment;


@Repository
public class MyBatisGratitudeDiaryCommentDao implements GratitudeDiaryCommentDao {

	private SqlSession sqlSession;

	private GratitudeDiaryCommentDao mapper;
	
	
	@Autowired
	public MyBatisGratitudeDiaryCommentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(GratitudeDiaryCommentDao.class);
	}
	
	
	
	@Override
	public GratitudeDiaryComment get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<GratitudeDiaryComment> getMainList(int gratitudeDiaryId) {
		// TODO Auto-generated method stub
		return mapper.getMainList(gratitudeDiaryId);
	}

	@Override
	public List<GratitudeDiaryComment> getSubList(int commentId) {
		// TODO Auto-generated method stub
		return mapper.getSubList(commentId);
	}

	@Override
	public int getCount(int gratitudeDiaryId) {
		// TODO Auto-generated method stub
		return mapper.getCount(gratitudeDiaryId);
	}

	@Override
	public int insert(GratitudeDiaryComment gratitudeDiary) {
		// TODO Auto-generated method stub
		return mapper.insert(gratitudeDiary);
	}

	@Override
	public int update(GratitudeDiaryComment gratitudeDiary) {
		// TODO Auto-generated method stub
		return mapper.update(gratitudeDiary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}
	

}
