package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.FreeDiaryDao;
import com.oneul.web.entity.FreeDiary;
@Repository
public class MyBatisFreeDiaryDao implements FreeDiaryDao {
	
	private SqlSession sqlSession;
	private FreeDiaryDao mapper;
	
	public MyBatisFreeDiaryDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(FreeDiaryDao.class);

	}

	@Override
	public FreeDiary get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<FreeDiary> getList() {
		return mapper.getList();
	}



}
