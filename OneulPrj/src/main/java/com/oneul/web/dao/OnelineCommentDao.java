package com.oneul.web.dao;

import java.util.List;


import com.oneul.web.entity.OnelineComment;

public interface OnelineCommentDao {
	OnelineComment get(int id);
	List<OnelineComment> getMainList(int onelineId);
	List<OnelineComment> getSubList(int commentId);
	
	int getCount(int onelineId);
	
	int insert(OnelineComment oneline);
	int update(OnelineComment oneline);
	int delete(int id);

}
