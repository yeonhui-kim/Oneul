package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.OnelineDao;
import com.oneul.web.dao.PublicDiaryDao;
import com.oneul.web.entity.Oneline;
import com.oneul.web.entity.PublicDiary;

@Service
public class PublicDiaryServiceimp implements PublicDiaryService {

	@Autowired
	private PublicDiaryDao dao;

	@Override
	public List<PublicDiary> getList() {
		List<PublicDiary> list = getList(1, null, null);
		return list;
	}

	@Override
	public List<PublicDiary> getList(int page) {
		List<PublicDiary> list = getList(page, null, null);
		return list;
	}

	@Override
	public List<PublicDiary> getList(int page, String field, String query) {
		int offset = (page-1)*10; //1->0, 2->10, 3->20, 4->30 
		int size = 100;	
		List<PublicDiary> list = dao.getList(offset, size, field, query);	
		return list; 
	}

	@Override
	public int insert(PublicDiary publicdiary) {
		
		return dao.insert(publicdiary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int update(PublicDiary publicdiary) {

		return dao.update(publicdiary);
		
	}

	@Override
	public PublicDiary get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}


}
