package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.FutureDiaryComment;


public interface FutureDiaryCommentDao {
	FutureDiaryComment get(int id);
	List<FutureDiaryComment> getMainList(int futureDiaryId);
	List<FutureDiaryComment> getSubList(int commentId);
	
	int getCount(int futureDiaryId);
	
	int insert(FutureDiaryComment futureDiary);
	int update(FutureDiaryComment futureDiary);
	int delete(int id);

}
