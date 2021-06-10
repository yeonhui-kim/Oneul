package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.FreeDiary;

public interface FreeDiaryService {
	
	FreeDiary get(int id);
	List<FreeDiary> getList();
	List<FreeDiary> getList(int page);
	List<FreeDiary> getList(int page,String field,String query);
	
	int insert(FreeDiary freeDiary);
	int update(FreeDiary freeDiary);
	int delete(int id);

}
