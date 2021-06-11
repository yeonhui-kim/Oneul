package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.FutureDiary;


public interface FreeDiaryDao {
	FreeDiary get(int id);	
	List<FreeDiary> getList(); // 필터링, 정렬, 페이징, 집계	

}
