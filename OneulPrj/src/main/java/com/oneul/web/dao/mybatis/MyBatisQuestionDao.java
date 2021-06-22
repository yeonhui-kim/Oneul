package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.QuestionDao;
import com.oneul.web.entity.Question;
import com.oneul.web.service.QuestionService;
@Repository
public class MyBatisQuestionDao implements QuestionDao{
	
	private SqlSession sqlSession;
	private QuestionDao mapper;
	
	public MyBatisQuestionDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(QuestionDao.class);
	}

	@Override
	public Question get() {
		return mapper.get();
	}

	@Override
	public List<Question> getList() {
		return mapper.getList();
	}

}
