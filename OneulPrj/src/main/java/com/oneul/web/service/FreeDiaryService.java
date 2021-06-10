package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.FreeDiary;

public interface FreeDiaryService {
	
	FreeDiary get(int id);
	List<FreeDiary> getList();
	
	int insert(FreeDiary freeDiary);
	int update(FreeDiary freeDiary);
	int delete(int id);

}
