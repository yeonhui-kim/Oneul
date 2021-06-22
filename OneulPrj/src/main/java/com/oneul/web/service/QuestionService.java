package com.oneul.web.service;

import java.util.List;

import com.oneul.web.entity.Question;

public interface QuestionService {

	Question get();
	List<Question> getList();
	
}
