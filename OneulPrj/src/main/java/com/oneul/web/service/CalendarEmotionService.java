package com.oneul.web.service;

import java.util.List;
import java.util.Map;

import com.oneul.web.entity.CalendarEmotion;

//업무적인 내용 // 이름을 보는 순간 그 업무의 내용이 느껴질 수 있도록
public interface CalendarEmotionService {
	
	List<Map<String, Object>> getListCalendar(CalendarEmotion param);
	List<CalendarEmotion> getListDiary(CalendarEmotion param);
	
	int insertCalendar(CalendarEmotion calendarEmotion);
	int updateCalendar(CalendarEmotion calendarEmotion);
	
	int selectCalEmotionCnt(CalendarEmotion calendarEmotion);

	int deleteCalendar(CalendarEmotion calendarEmotion);
}
