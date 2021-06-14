package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.FutureDiaryDao;
import com.oneul.web.entity.FutureDiary;

@Service
public class FutureDiaryServiceImp implements FutureDiaryService{
	
	@Autowired
	FutureDiaryDao dao;
	
	@Override
	public List<FutureDiary> getList(int page) {
		int offset = (page-1)*10;
		int size = 10;
	
		return dao.getList(offset, size);
	}

	@Override
	public FutureDiary get(int id) {
		
		return dao.get(id);
	}
	
	@Override
	public int delete(int id) {
		return dao.delete(id);
	}
	
	@Override
	public int insert(FutureDiary futureDiary) {
		return dao.insert(futureDiary);
	}
	
	@Override
	public int update(FutureDiary futureDiary) {
		return dao.update(futureDiary);
	}
}
