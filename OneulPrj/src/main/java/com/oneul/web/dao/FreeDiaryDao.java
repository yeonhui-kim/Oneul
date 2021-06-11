package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.FutureDiary;


public interface FreeDiaryDao {
	FreeDiary get(int id);	
	List<FreeDiary> getList(); // 필터링, 정렬, 페이징, 집계	
	List<FreeDiary> getList(int offset, int size); // 필터링, 정렬, 페이징, 집계	
	List<FreeDiary> getListIn(int[] ids);
	
	int getCount(String field, String query);
		
	int insert(FreeDiary freeDiary);
	int update(FreeDiary freeDiary);
	int delete(int id);
	//int hitUp();
	//int likeUp(int id);
	List<FreeDiary> getList(int offset, int size, String field, String query);


}
