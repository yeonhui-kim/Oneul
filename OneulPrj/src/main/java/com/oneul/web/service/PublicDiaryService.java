package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.PublicDiary;



public interface PublicDiaryService {

	List<PublicDiary> getList();
	List<PublicDiary> getList(int page);
	List<PublicDiary> getList(int page, String field, String query); //serviceimp.java
	
	PublicDiary get(int id);
	int insert(PublicDiary publicdiary);
	int delete(int id);
	int update(PublicDiary publicdiary);
	

}
