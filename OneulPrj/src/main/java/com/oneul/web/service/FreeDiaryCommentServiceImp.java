package com.oneul.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.FreeDiaryCommentDao;
import com.oneul.web.entity.FreeDiaryComment;


@Service
public class FreeDiaryCommentServiceImp implements FreeDiaryCommentService {
	
	@Autowired
	private FreeDiaryCommentDao dao;
	
	@Override
	public FreeDiaryComment get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public List<FreeDiaryComment> getViewList(int freeDiaryId) {
		List<FreeDiaryComment> list;
		list = dao.getMainList(freeDiaryId);
		for(FreeDiaryComment n : list) {
			n.setList(dao.getSubList(n.getFreeDiaryId()));
			
		}
		
		
		
		
		return list;
	}

	@Override
	public int getCount(int freeDiaryId) {
		// TODO Auto-generated method stub
		return dao.getCount(freeDiaryId);
	}

	@Override
	public int insert(FreeDiaryComment freeDiary) {
		// TODO Auto-generated method stub
		return dao.insert(freeDiary);
	}

	@Override
	public int update(FreeDiaryComment freeDiary) {
		// TODO Auto-generated method stub
		return dao.update(freeDiary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

}
