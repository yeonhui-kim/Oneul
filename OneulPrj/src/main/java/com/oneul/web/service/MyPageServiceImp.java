package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.MyPageDao;
import com.oneul.web.entity.MyComment;
import com.oneul.web.entity.MyDiary;


@Service
public class MyPageServiceImp implements MyPageService {
	
	@Autowired
	private MyPageDao dao;
	

	@Override
	public List<MyDiary> getDiaryList(int id) {
		// TODO Auto-generated method stub
		return dao.getDiaryList(id);
	}

	@Override
	public List<MyComment> getCommentList(int id) {
		// TODO Auto-generated method stub
		return dao.getCommentList(id);
	}

}
