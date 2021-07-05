package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.MyComment;
import com.oneul.web.entity.MyDiary;
import com.oneul.web.entity.MyOneline;

public interface MyPageDao {
	List<MyDiary> getDiaryList(int id);
	List<MyComment> getCommentList(int id);
	List<MyOneline> getOnelineList(int id);
}
