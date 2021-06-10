//package com.oneul.web.dao.mybatis;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//
//import com.oneul.web.dao.FutureDiaryDao;
//import com.oneul.web.entity.FutureDiary;
//
//public class MyBatisFutureDiaryDao implements FutureDiaryDao {
//
//	private SqlSession sqlSession;
//	private FutureDiaryDao mapper;
//	
//	public MyBatisFutureDiaryDao(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//		mapper = sqlSession.getMapper(FutureDiaryDao.class);
//	}
//	
//	@Override
//	public FutureDiary get(int id) {
//		return mapper.get(id);
//		
//	}
//
//	@Override
//	public List<FutureDiary> getList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<FutureDiary> getList(int offset, int size) {
//		// TODO Auto-generated method stub
//		return mapper.getList(offset, size);
//	}
//
//	@Override
//	public int insert(FutureDiary futureDiary) {
//		// TODO Auto-generated method stub
//		return mapper.insert(futureDiary);
//	}
//
//	@Override
//	public int update(FutureDiary futureDiary) {
//		// TODO Auto-generated method stub
//		return mapper.update(futureDiary);
//	}
//
//	@Override
//	public int delete(int id) {
//		// TODO Auto-generated method stub
//		return mapper.delete(id);
//	}
//
//}
