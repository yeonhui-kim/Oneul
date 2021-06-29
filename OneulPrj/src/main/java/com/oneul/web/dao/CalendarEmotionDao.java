package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.CalendarEmotion;

public interface CalendarEmotionDao {
	
	List<CalendarEmotion> getListCalendar();
	int insertCalendar(CalendarEmotion calendarEmotion);
	int updateCalendar(CalendarEmotion calendarEmotion);

	int selectCalEmotionCnt(CalendarEmotion calendarEmotion);
	
}
