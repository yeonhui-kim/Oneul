package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.OnelineDao;
import com.oneul.web.dao.PublicDiaryDao;
import com.oneul.web.entity.Oneline;
import com.oneul.web.entity.PublicDiary;



@Repository
public class MyBatisPublicDiary implements PublicDiaryDao{
	
	private SqlSession sqlSession; //매퍼 컨테이너에서 매퍼를 불러오기위한 도구	
	private PublicDiaryDao mapper; 
	
	@Autowired
	public MyBatisPublicDiary(SqlSession sqlSession) {
		this.sqlSession = sqlSession;		
		mapper = sqlSession.getMapper(PublicDiaryDao.class);
	}

	@Override
	public PublicDiary get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<PublicDiary> getList() {
		return getList(0,0,"","");
	}

	@Override
	public List<PublicDiary> getList(int offset, int size) {
		return getList(offset, size, "","");
	}

	@Override
	public List<PublicDiary> getList(int offset, int size, String field, String query) {
		return mapper.getList(offset, size, field, query);
	}

	@Override
	public int insert(PublicDiary publicdiary) {
		// TODO Auto-generated method stub
		return mapper.insert(publicdiary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public int update(PublicDiary publicdiary) {
		// TODO Auto-generated method stub
		return mapper.update(publicdiary);
	}


	}

