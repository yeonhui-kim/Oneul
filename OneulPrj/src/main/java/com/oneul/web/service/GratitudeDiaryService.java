package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.GratitudeDiary;
//업무적인 내용 // 이름을 보는 순간 그 업무의 내용이 느껴질 수 있도록
public interface GratitudeDiaryService {
	
	GratitudeDiary get(int id);
	List<GratitudeDiary> getList(int id);
//	List<GratitudeDiary> getList(int page);
	
	int insertDiary(GratitudeDiary gratitudeDiary);
	int updateDiary(GratitudeDiary gratitudeDiary);
	int delete(int id);
	
}
