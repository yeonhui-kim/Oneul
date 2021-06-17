package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oneul.web.dao.OnelineCommentDao;
import com.oneul.web.entity.FreeDiaryComment;
import com.oneul.web.entity.OnelineComment;

public class OnelineCommentServiceImp implements OnelineCommentService {

	@Autowired
	private OnelineCommentDao dao;
	
	@Override
	public OnelineComment get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public List<OnelineComment> getViewList(int onelineId) {
		List<OnelineComment> list;
		list = dao.getMainList(onelineId);
		for(OnelineComment n : list) {
			if(n.getCommentId() == null)
				n.setList(dao.getSubList(n.getId()));
			
		}
		
		
		
		
		return list;
	}

	@Override
	public int getCount(int onelineId) {
		// TODO Auto-generated method stub
		return dao.getCount(onelineId);
	}

	@Override
	public int insert(OnelineComment oneline) {
		// TODO Auto-generated method stub
		return dao.insert(oneline);
	}

	@Override
	public int update(OnelineComment oneline) {
		// TODO Auto-generated method stub
		return dao.update(oneline);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

}
