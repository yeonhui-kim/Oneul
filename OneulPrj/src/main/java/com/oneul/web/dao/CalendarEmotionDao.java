package com.oneul.web.dao;

import java.util.List;
import java.util.Map;

import com.oneul.web.entity.CalendarEmotion;

public interface CalendarEmotionDao {
	
	List<Map<String, Object>> getListCalendar(CalendarEmotion param);
	List<CalendarEmotion> getListDiary(CalendarEmotion param);
	
	int insertCalendar(CalendarEmotion calendarEmotion);
	int updateCalendar(CalendarEmotion calendarEmotion);

	int selectCalEmotionCnt(CalendarEmotion calendarEmotion);
	int selectCalEmotionPrevCnt(CalendarEmotion calendarEmotion);
	int deleteCalendar(CalendarEmotion calendarEmotion);
	int deleteCalendarPrev(CalendarEmotion calendarEmotion);
	
}
