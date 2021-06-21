package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.GratitudeDiaryDao;
import com.oneul.web.entity.CalendarEmotion;
import com.oneul.web.entity.GratitudeDiary;

@Service
public class GratitudeDiaryServiceImp implements GratitudeDiaryService {

	@Autowired
	private GratitudeDiaryDao dao;
	
	@Override
	public GratitudeDiary get(int id) {
		return dao.get(id);
	}

	@Override
	public List<GratitudeDiary> getList() {
		List<GratitudeDiary> list = dao.getList();
		return list;
	}

	@Override
	public List<GratitudeDiary> getList(int page) {
		int offset = (page-1)*10;
		int size = 10;
		
		return dao.getList(offset, size);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

	@Override
	public int insertDiary(GratitudeDiary gratitudeDiary) {
		return dao.insertDiary(gratitudeDiary);
	}

	@Override
	public int updateDiary(GratitudeDiary gratitudeDiary) {
		return dao.updateDiary(gratitudeDiary);
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
