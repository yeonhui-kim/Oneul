package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.GratitudeDiaryDao;
import com.oneul.web.entity.GratitudeDiary;

@Repository
public class MyBatisGratitudeDiaryDao implements GratitudeDiaryDao {

	private SqlSession SqlSession;
	private GratitudeDiaryDao mapper;
	
	@Autowired
	public MyBatisGratitudeDiaryDao(SqlSession sqlSession) {
		this.SqlSession = sqlSession;
		mapper = SqlSession.getMapper(GratitudeDiaryDao.class);
	}
	
	@Override
	public GratitudeDiary get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<GratitudeDiary> getList() {
		return mapper.getList();
	}

	@Override
	public List<GratitudeDiary> getList(int offset, int size) {
		return getList(offset, size);
	}

	@Override
	public int insert(GratitudeDiary gratitudeDiary) {
		return mapper.insert(gratitudeDiary);
	}

	@Override
	public int update(GratitudeDiary gratitudeDiary) {
		return mapper.update(gratitudeDiary);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	
}
