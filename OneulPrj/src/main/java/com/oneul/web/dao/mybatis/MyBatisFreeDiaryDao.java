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

	@Override
	public FreeDiary get(int id) {
		return mapper.get(id);
	}

	@Override
	public int getCount(String field, String query) {
		return mapper.getCount(field, query);
	}

	@Override
	public int insert(FreeDiary freeDiary) {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public List<FreeDiary> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FreeDiary> getList(int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FreeDiary> getListIn(int[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FreeDiary> getList(int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}



}
