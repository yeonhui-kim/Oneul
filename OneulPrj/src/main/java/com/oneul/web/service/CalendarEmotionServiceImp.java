package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.CalendarEmotionDao;
import com.oneul.web.entity.CalendarEmotion;

@Service
public class CalendarEmotionServiceImp implements CalendarEmotionService {

	@Autowired
	private CalendarEmotionDao dao;
	
	@Override
	public List<CalendarEmotion> getListCalendar() {
		List<CalendarEmotion> list = dao.getListCalendar();
		return list;
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



	
}
