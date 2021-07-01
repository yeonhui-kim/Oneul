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
	public List<GratitudeDiary> getList(int id) {
		List<GratitudeDiary> list = dao.getList(id);
		return list;
	}

	/*
	 * @Override public List<GratitudeDiary> getList1(int page) { int offset =
	 * (page-1)*10; int size = 10;
	 * 
	 * return dao.getList(offset, size); }
	 */

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

	@Override
	public int insertDiary(GratitudeDiary gratitudeDiary) {
		return dao.insertDiary(gratitudeDiary);
	}

	@Override
	public int updateDiary(GratitudeDiary gratitudeDiary) {
		return dao.updateDiary(gratitudeDiary);
	}
	
	
}
