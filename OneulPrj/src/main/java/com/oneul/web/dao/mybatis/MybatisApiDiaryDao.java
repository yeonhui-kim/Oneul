package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.ApiDiaryDao;
import com.oneul.web.dao.FreeDiaryCommentDao;
import com.oneul.web.entity.FreeDiaryView;
import com.oneul.web.entity.FutureDiaryView;
import com.oneul.web.entity.GratitudeDiaryView;


@Repository
public class MybatisApiDiaryDao implements ApiDiaryDao {
	
	
	
	private SqlSession sqlSession;
	private ApiDiaryDao mapper;
	
	
	@Autowired
	public MybatisApiDiaryDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(ApiDiaryDao.class);
	}

	
	
	@Override
	public List<FreeDiaryView> getFreeList(Integer memberId, String query, Integer pageOffset) {
		// TODO Auto-generated method stub
		return mapper.getFreeList(memberId, query, pageOffset);
	}

	@Override
	public List<FutureDiaryView> getFutureList(Integer memberId, String query, Integer pageOffset) {
		// TODO Auto-generated method stub
		return mapper.getFutureList(memberId, query, pageOffset);
	}

	@Override
	public List<GratitudeDiaryView> getGratitudeList(Integer memberId, String query, Integer pageOffset) {
		// TODO Auto-generated method stub
		return mapper.getGratitudeList(memberId, query, pageOffset);
	}

	
}
