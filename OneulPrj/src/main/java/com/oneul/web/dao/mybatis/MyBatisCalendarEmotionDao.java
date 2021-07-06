package com.oneul.web.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oneul.web.dao.CalendarEmotionDao;
import com.oneul.web.entity.CalendarEmotion;

@Repository
public class MyBatisCalendarEmotionDao implements CalendarEmotionDao {

	private SqlSession SqlSession;
	private CalendarEmotionDao mapper;
	
	@Autowired
	public MyBatisCalendarEmotionDao(SqlSession sqlSession) {
		this.SqlSession = sqlSession;
		mapper = SqlSession.getMapper(CalendarEmotionDao.class);
	}
	
	@Override
	public List<Map<String, Object>> getListCalendar(CalendarEmotion param) {
		return mapper.getListCalendar(param);
	}
	
	@Override
	public List<CalendarEmotion> getListDiary(CalendarEmotion param) {
		return mapper.getListDiary(param);
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

	@Override
	public int deleteCalendar(CalendarEmotion calendarEmotion) {
		return mapper.deleteCalendar(calendarEmotion);
	}

	



	
}
