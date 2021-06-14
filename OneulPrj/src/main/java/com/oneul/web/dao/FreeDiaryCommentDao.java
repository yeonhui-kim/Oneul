package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.FreeDiaryComment;


public interface FreeDiaryCommentDao {
	FreeDiaryComment get(int id);
	List<FreeDiaryComment> getMainList(int freeDiaryId);
	List<FreeDiaryComment> getSubList(int commentId);
	
	int getCount(int freeDiaryId);
	
	int insert(FreeDiaryComment freeDiary);
	int update(FreeDiaryComment freeDiary);
	int delete(int id);

}
