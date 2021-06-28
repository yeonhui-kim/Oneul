package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.FutureDiary;


public interface FreeDiaryDao {
	FreeDiary get(int id);	
	List<FreeDiary> getList();
	List<FreeDiary> getList(int id);
	
	int insert(FreeDiary freeDiary);
	int update(FreeDiary freeDiary);
	int delete(int id);

}
