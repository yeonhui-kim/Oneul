//package com.oneul.web.dao.mybatis;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.oneul.web.dao.OnelineDao;
//import com.oneul.web.entity.Oneline24;
//
//
//@Repository
//public class MyBatisOnelineDao implements OnelineDao{
//	
//	private SqlSession sqlSession; //매퍼 컨테이너에서 매퍼를 불러오기위한 도구	
//	private OnelineDao mapper; 
//	
//	@Autowired
//	public MyBatisOnelineDao(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;		
//		mapper = sqlSession.getMapper(OnelineDao.class);
//	}
//
//	@Override
//	public Oneline24 get(int id) {
//		return mapper.get(id);
//	}
//
//	@Override
//	public List<Oneline24> getList() {
//		return getList(0,0,"","");
//	}
//
//	@Override
//	public List<Oneline24> getList(int offset, int size) {
//		return getList(offset, size, "","");
//	}
//
//	@Override
//	public List<Oneline24> getList(int offset, int size, String field, String query) {
//		return mapper.getList(offset, size, field, query);
//	}
//
//	@Override
//	public int insert(Oneline24 oneline24) {
//		return mapper.insert(oneline24);
//	}
//
//	@Override
//	public int update(Oneline24 oneline24) {
//		return mapper.update(oneline24);
//	}
//
//	@Override
//	public int delete(int id) {
//		return mapper.delete(id);
//	}
//
//}
