package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.Question;
import com.oneul.web.service.QuestionService;

public interface QuestionDao {
	
	Question get();
	List<Question> getList();

}
