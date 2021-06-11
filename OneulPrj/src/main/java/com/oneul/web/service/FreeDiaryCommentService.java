package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.FreeDiaryComment;


public interface FreeDiaryCommentService {
	FreeDiaryComment get(int id);
	List<FreeDiaryComment> getViewList(int freeDiaryId);
	
	
	int getCount(int freeDiaryId);
	
	int insert(FreeDiaryComment freeDiary);
	int update(FreeDiaryComment freeDiary);
	int delete(int id);

}
