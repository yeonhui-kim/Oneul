package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.Oneline24;

public interface OnelineDao {
	Oneline24 get(int id);	
	List<Oneline24> getList();//필터링, 정렬, 페이징, 집계	
	List<Oneline24> getList(int offset, int size);
	List<Oneline24> getList(int offset,int size, String field, String query);
	
	int insert(Oneline24 oneline24);
	int update(Oneline24 oneline24);
	int delete(int id);
}
