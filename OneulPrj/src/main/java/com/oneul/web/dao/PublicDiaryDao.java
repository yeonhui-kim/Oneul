package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.Oneline;
import com.oneul.web.entity.PublicDiary;

public interface PublicDiaryDao {
	PublicDiary get(int id);	
	List<PublicDiary> getList();//필터링, 정렬, 페이징, 집계	
	List<PublicDiary> getList(int offset, int size);
	List<PublicDiary> getList(int offset,int size, String field, String query);
	
	int insert (PublicDiary publicdiary);
	int delete (int id);
	int update(PublicDiary publicdiary);
	
	

}
