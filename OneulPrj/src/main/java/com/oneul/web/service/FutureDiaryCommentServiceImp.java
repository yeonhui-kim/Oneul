package com.oneul.web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.FutureDiaryCommentDao;
import com.oneul.web.entity.FutureDiaryComment;


@Service
public class FutureDiaryCommentServiceImp implements FutureDiaryCommentService {
	
	@Autowired
	private FutureDiaryCommentDao dao;
	
	@Override
	public FutureDiaryComment get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public List<FutureDiaryComment> getViewList(int futureDiaryId) {
		List<FutureDiaryComment> list;
		list = dao.getMainList(futureDiaryId);
		for(FutureDiaryComment n : list) {
			n.setList(dao.getSubList(n.getFutureDiaryId()));
			
		}
		
		
		
		
		return list;
	}

	@Override
	public int getCount(int futureDiaryId) {
		// TODO Auto-generated method stub
		return dao.getCount(futureDiaryId);
	}

	@Override
	public int insert(FutureDiaryComment futureDiary) {
		// TODO Auto-generated method stub
		return dao.insert(futureDiary);
	}

	@Override
	public int update(FutureDiaryComment futureDiary) {
		// TODO Auto-generated method stub
		return dao.update(futureDiary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

}
