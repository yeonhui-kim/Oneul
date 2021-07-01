package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.FutureDiaryDao;
import com.oneul.web.entity.FutureDiary;

@Repository
public class MyBatisFutureDiaryDao implements FutureDiaryDao {

	private SqlSession sqlSession;
	private FutureDiaryDao mapper;
	
	//생성자 di
	public MyBatisFutureDiaryDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(FutureDiaryDao.class);
	}
	
	@Override
	public FutureDiary get(int id) {
		return mapper.get(id);
		//return null;
	}

	@Override
	public List<FutureDiary> getList() {
		List<FutureDiary> list = getList(0,10);
		return list;
	}

	@Override
	public List<FutureDiary> getList(int offset, int size) {
		
		return mapper.getList(offset, size);
		//return null;
	}

	@Override
	public int insert(FutureDiary futureDiary) {
		
		return mapper.insert(futureDiary);
		
	}

	@Override
	public int update(FutureDiary futureDiary) {
		
		return mapper.update(futureDiary);
		
	}

	@Override
	public int delete(int id) {
		
		return mapper.delete(id);
		
	}

	@Override
	public List<FutureDiary> getListAll() {
		// TODO Auto-generated method stub
		return mapper.getListAll();
	}

}
