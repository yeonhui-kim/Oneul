package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.GratitudeDiaryComment;


public interface GratitudeDiaryCommentDao {
	GratitudeDiaryComment get(int id);
	List<GratitudeDiaryComment> getMainList(int gratitudeDiaryId);
	List<GratitudeDiaryComment> getSubList(int commentId);
	
	int getCount(int gratitudeDiaryId);
	
	int insert(GratitudeDiaryComment gratitudeDiary);
	int update(GratitudeDiaryComment gratitudeDiary);
	int delete(int id);

}
