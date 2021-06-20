package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.OnelineComment;

public interface OnelineCommentService {
	OnelineComment get(int id);
	List<OnelineComment> getViewList(int onelineId);
	
	
	int getCount(int onelineId);
	
	int insert(OnelineComment oneline);
	int update(OnelineComment oneline);
	int delete(int id);
}
