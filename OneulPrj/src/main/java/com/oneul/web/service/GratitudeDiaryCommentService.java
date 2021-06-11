package com.oneul.web.service;

import java.util.List;


import com.oneul.web.entity.GratitudeDiaryComment;


public interface GratitudeDiaryCommentService {
	GratitudeDiaryComment get(int id);
	List<GratitudeDiaryComment> getViewList(int gratitudeDiaryId);
	
	
	int getCount(int gratitudeDiaryId);
	
	int insert(GratitudeDiaryComment gratitudeDiary);
	int update(GratitudeDiaryComment gratitudeDiary);
	int delete(int id);

}
