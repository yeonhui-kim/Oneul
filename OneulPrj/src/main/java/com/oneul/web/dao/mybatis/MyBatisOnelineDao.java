package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.OnelineDao;
import com.oneul.web.entity.Oneline;



@Repository
public class MyBatisOnelineDao implements OnelineDao{
	
	private SqlSession sqlSession; //매퍼 컨테이너에서 매퍼를 불러오기위한 도구	
	private OnelineDao mapper; 
	
	@Autowired
	public MyBatisOnelineDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;		
		mapper = sqlSession.getMapper(OnelineDao.class);
	}

	@Override
	public Oneline get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<Oneline> getList() {
		return getList(0,0,"","");
	}

	@Override
	public List<Oneline> getList(int offset, int size) {
		return getList(offset, size, "","");
	}

	@Override
	public List<Oneline> getList(int offset, int size, String field, String query) {
		return mapper.getList(offset, size, field, query);
	}

	@Override
	public int insert(Oneline oneline) {
		// TODO Auto-generated method stub
		return mapper.insert(oneline);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public int update(Oneline oneline) {
		// TODO Auto-generated method stub
		return mapper.update(oneline);
	}


	}

