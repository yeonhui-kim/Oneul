package com.oneul.web.service;

import java.util.List;


import com.oneul.web.entity.FutureDiaryComment;


public interface FutureDiaryCommentService {
	FutureDiaryComment get(int id);
	List<FutureDiaryComment> getViewList(int futureDiaryId);
	
	
	int getCount(int futureDiaryId);
	
	int insert(FutureDiaryComment futureDiary);
	int update(FutureDiaryComment futureDiary);
	int delete(int id);

}
