package com.oneul.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.GratitudeDiaryDao;
import com.oneul.web.entity.CalendarEmotion;
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
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public int insertDiary(GratitudeDiary gratitudeDiary) {
		return mapper.insertDiary(gratitudeDiary);
	}

	@Override
	public int updateDiary(GratitudeDiary gratitudeDiary) {
		return mapper.updateDiary(gratitudeDiary);
	}

	@Override
	public int insertCalendar(CalendarEmotion calendarEmotion) {
		return mapper.insertCalendar(calendarEmotion);
	}

	@Override
	public int updateCalendar(CalendarEmotion calendarEmotion) {
		return mapper.updateCalendar(calendarEmotion);
	}

	@Override
	public int selectCalEmotionCnt(CalendarEmotion calendarEmotion) {
		return mapper.selectCalEmotionCnt(calendarEmotion);
	}

	
}
