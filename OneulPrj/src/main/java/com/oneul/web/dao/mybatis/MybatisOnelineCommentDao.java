package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;


import com.oneul.web.dao.OnelineCommentDao;
import com.oneul.web.entity.OnelineComment;

public class MybatisOnelineCommentDao implements OnelineCommentDao{
	
	private SqlSession sqlSession;
	private OnelineCommentDao mapper;
	
	
	@Autowired
	public MybatisOnelineCommentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(OnelineCommentDao.class);
	}
	
	
	
	@Override
	public OnelineComment get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<OnelineComment> getMainList(int onelineId) {
		// TODO Auto-generated method stub
		return mapper.getMainList(onelineId);
	}

	@Override
	public List<OnelineComment> getSubList(int commentId) {
		// TODO Auto-generated method stub
		return mapper.getSubList(commentId);
	}

	@Override
	public int getCount(int onelineId) {
		// TODO Auto-generated method stub
		return mapper.getCount(onelineId);
	}

	@Override
	public int insert(OnelineComment oneline) {
		// TODO Auto-generated method stub
		return mapper.insert(oneline);
	}

	@Override
	public int update(OnelineComment oneline) {
		// TODO Auto-generated method stub
		return mapper.update(oneline);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

}
