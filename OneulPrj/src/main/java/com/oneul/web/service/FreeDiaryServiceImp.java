package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.FreeDiaryDao;
import com.oneul.web.entity.FreeDiary;
import com.oneul.web.entity.Member;
@Service
public class FreeDiaryServiceImp implements FreeDiaryService {
	
	@Autowired
	private FreeDiaryDao dao;

	@Override
	public FreeDiary get(int id) {
		
		return dao.get(id);
	}

	@Override
	public List<FreeDiary> getList() {
		
		List<FreeDiary> list = dao.getList();
		return list;
	}

	@Override
	public int insert(FreeDiary freeDiary) {

		return dao.insert(freeDiary);
	}

	@Override
	public int update(FreeDiary freeDiary) {

		return dao.update(freeDiary);
	}

	@Override
	public int delete(int id) {

		return dao.delete(id);
	}

}
