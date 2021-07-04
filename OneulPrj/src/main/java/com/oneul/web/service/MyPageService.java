package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oneul.web.dao.MyPageDao;
import com.oneul.web.entity.MyComment;
import com.oneul.web.entity.MyDiary;
import com.oneul.web.entity.MyOneline;

public interface MyPageService {


	public List<MyDiary> getDiaryList(int id);

	
	public List<MyComment> getCommentList(int id);
	
	public List<MyOneline> getOnelineList(int id);
}
