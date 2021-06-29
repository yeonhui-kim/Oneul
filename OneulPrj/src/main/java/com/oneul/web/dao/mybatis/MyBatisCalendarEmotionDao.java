package com.oneul.web.dao.mybatis;

import java.util.List;

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
	public List<CalendarEmotion> getListCalendar() {
		return mapper.getListCalendar();
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
