package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.GratitudeDiaryDao;
import com.oneul.web.entity.GratitudeDiary;

@Service
public class GratitudeDiaryServiceImp implements GratitudeDiaryService {

	@Autowired
	private GratitudeDiaryDao dao;
	
	@Override
	public GratitudeDiary get(int id) {
		return dao.get(id);
	}

	@Override
	public List<GratitudeDiary> getList() {
		List<GratitudeDiary> list = dao.getList();
		return list;
	}

	@Override
	public List<GratitudeDiary> getList(int page) {
		int offset = 0;
		int size = 0;
		
		List<GratitudeDiary> list = dao.getList(offset, size);
		return list;
	}

	@Override
	public int insert(GratitudeDiary gratitudeDiary) {
		return dao.insert(gratitudeDiary);
	}

	@Override
	public int update(GratitudeDiary gratitudeDiary) {
		return dao.update(gratitudeDiary);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}
	
	
}
