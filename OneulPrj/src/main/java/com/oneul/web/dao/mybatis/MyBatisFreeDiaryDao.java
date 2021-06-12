package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.FreeDiaryDao;
import com.oneul.web.entity.FreeDiary;
@Repository
public class MyBatisFreeDiaryDao implements FreeDiaryDao {
	
	private SqlSession sqlSession;//연결
	private FreeDiaryDao mapper;//freeDiaryDao객체
	
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

	@Override
	public int insert(FreeDiary freeDiary) {

		return mapper.insert(freeDiary);
	}

	@Override
	public int update(FreeDiary freeDiary) {
		int result = 0;
		result = mapper.update(freeDiary);
		return result;
	}

	@Override
	public int delete(int id) {
		
		return mapper.delete(id);
	}



}
