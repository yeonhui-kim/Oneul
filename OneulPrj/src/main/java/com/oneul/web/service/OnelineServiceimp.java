package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.OnelineDao;
import com.oneul.web.entity.Oneline;

@Service
public class OnelineServiceimp implements OnelineService {

	@Autowired
	private OnelineDao dao;

	@Override
	public List<Oneline> getList() {
		List<Oneline> list = getList(1, null, null);
		return list;
	}

	@Override
	public List<Oneline> getList(int page) {
		List<Oneline> list = getList(page, null, null);
		return list;
	}

	@Override
	public List<Oneline> getList(int page, String field, String query) {
		int offset = (page-1)*10; //1->0, 2->10, 3->20, 4->30 
		int size = 100;	
		List<Oneline> list = dao.getList(offset, size, field, query);	
		return list;
	}

	@Override
	public int insert(Oneline oneline) {
		
		return dao.insert(oneline);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int update(Oneline oneline) {

		return dao.update(oneline);
		
	}

	@Override
	public Oneline get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}


}
