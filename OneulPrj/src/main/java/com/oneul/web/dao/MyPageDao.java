package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.MyComment;
import com.oneul.web.entity.MyDiary;

public interface MyPageDao {
	List<MyDiary> getDiaryList(int id);
	List<MyComment> getCommentList(int id);
}
