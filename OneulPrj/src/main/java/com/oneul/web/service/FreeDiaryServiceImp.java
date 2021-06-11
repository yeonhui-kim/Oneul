package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.FreeDiaryDao;
import com.oneul.web.entity.FreeDiary;
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
		
		List<FreeDiary> list = getList(1,null,null);
		return list;
	}

	@Override
	public List<FreeDiary> getList(int page) {
		
		List<FreeDiary> list = getList(page,null,null);
		return list;
	}

	@Override
	public List<FreeDiary> getList(int page, String field, String query) {
		int offset = (page-1)*10;
		int size =10;
		
		List<FreeDiary> list = dao.getList(offset,size,field,query);
		return list;
	}

	@Override
	public int insert(FreeDiary freeDiary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(FreeDiary freeDiary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
