package com.oneul.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.CalendarEmotionDao;
import com.oneul.web.entity.CalendarEmotion;

@Service
public class CalendarEmotionServiceImp implements CalendarEmotionService {

	@Autowired
	private CalendarEmotionDao dao;
	
	@Override
	public List<Map<String, Object>> getListCalendar(CalendarEmotion param) {
		List<Map<String, Object>> list = dao.getListCalendar(param);
		return list;
	}
	
	@Override
	public List<CalendarEmotion> getListDiary(CalendarEmotion param) {
		List<CalendarEmotion> diaryList = dao.getListDiary(param);
		return diaryList;
	}

	@Override
	public int insertCalendar(CalendarEmotion calendarEmotion) {
		return dao.insertCalendar(calendarEmotion);
	}

	@Override
	public int updateCalendar(CalendarEmotion calendarEmotion) {
		return dao.updateCalendar(calendarEmotion);
	}

	@Override
	public int selectCalEmotionCnt(CalendarEmotion calendarEmotion) {
		return dao.selectCalEmotionCnt(calendarEmotion);
	}

	@Override
	public int selectCalEmotionPrevCnt(CalendarEmotion calendarEmotion) {
		
		return dao.selectCalEmotionPrevCnt(calendarEmotion);
	}
	
	@Override
	public int deleteCalendar(CalendarEmotion calendarEmotion) {
		
		return dao.deleteCalendar(calendarEmotion);
	}

	@Override
	public int deleteCalendarPrev(CalendarEmotion calendarEmotion) {
		return dao.deleteCalendarPrev(calendarEmotion);
	}


	
	
}
