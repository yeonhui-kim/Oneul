package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.Member;

public interface FreeDiaryService {
	
	FreeDiary get(int id);
	List<FreeDiary> getList();
	List<FreeDiary> getList(int id);

	int insert(FreeDiary freeDiary);
	int update(FreeDiary freeDiary);
	int delete(int id);
	}
