package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.CalendarEmotion;

//업무적인 내용 // 이름을 보는 순간 그 업무의 내용이 느껴질 수 있도록
public interface CalendarEmotionService {
	
	List<CalendarEmotion> getListCalendar();
	
	int insertCalendar(CalendarEmotion calendarEmotion);
	int updateCalendar(CalendarEmotion calendarEmotion);
	
	int selectCalEmotionCnt(CalendarEmotion calendarEmotion);
}
