package com.oneul.web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.GratitudeDiaryCommentDao;
import com.oneul.web.entity.GratitudeDiaryComment;


@Service
public class GratitudeDiaryCommentServiceImp implements GratitudeDiaryCommentService {
	
	@Autowired
	private GratitudeDiaryCommentDao dao;
	
	@Override
	public GratitudeDiaryComment get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public List<GratitudeDiaryComment> getViewList(int gratitudeDiaryId) {
		List<GratitudeDiaryComment> list;
		list = dao.getMainList(gratitudeDiaryId);
		for(GratitudeDiaryComment n : list) {
			if(n.getCommentId() == null)
			n.setList(dao.getSubList(n.getId()));
			
		}
		
		
		
		
		return list;
	}

	@Override
	public int getCount(int gratitudeDiaryId) {
		// TODO Auto-generated method stub
		return dao.getCount(gratitudeDiaryId);
	}

	@Override
	public int insert(GratitudeDiaryComment gratitudeDiary) {
		// TODO Auto-generated method stub
		return dao.insert(gratitudeDiary);
	}

	@Override
	public int update(GratitudeDiaryComment gratitudeDiary) {
		// TODO Auto-generated method stub
		return dao.update(gratitudeDiary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

}
