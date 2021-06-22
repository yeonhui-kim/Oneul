package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.QuestionDao;
import com.oneul.web.entity.Question;

@Service
public class QuestionServieImp implements QuestionService{
	
	@Autowired
	private QuestionDao dao;

	@Override
	public Question get() {

		return dao.get();
	}

	@Override
	public List<Question> getList() {
		List<Question> list = dao.getList();
		return list;
	}

}
