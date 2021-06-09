package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.GratitudeDiary;

public interface GratitudeDiaryDao {

	GratitudeDiary get(int id);
	
	List<GratitudeDiary> getList();
	List<GratitudeDiary> getList(int offset, int size);
	
	int insert(GratitudeDiary gratitudeDiary);
	int update(GratitudeDiary gratitudeDiary);
	int delete(int id);
	
	
}
