package com.oneul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneul.web.dao.ApiDiaryDao;
import com.oneul.web.dao.FreeDiaryCommentDao;
import com.oneul.web.entity.FreeDiaryView;
import com.oneul.web.entity.FutureDiaryView;
import com.oneul.web.entity.GratitudeDiaryView;
import com.oneul.web.entity.OnelineView;

@Service
public class ApiDiaryServiceImp implements ApiDiaryService {
	
	@Autowired
	private ApiDiaryDao dao;
	
	@Override
	public List<FreeDiaryView> getFreeList(Integer memberId, String query, Integer pageOffset) {
		// TODO Auto-generated method stub
		return dao.getFreeList(memberId, query, pageOffset);
	}

	@Override
	public List<FutureDiaryView> getFutureList(Integer memberId, String query, Integer pageOffset) {
		// TODO Auto-generated method stub
		return dao.getFutureList(memberId, query, pageOffset);
	}

	@Override
	public List<GratitudeDiaryView> getGratitudeList(Integer memberId, String query, Integer pageOffset) {
		// TODO Auto-generated method stub
		return dao.getGratitudeList(memberId, query, pageOffset);
	}
	
	@Override
	public List<OnelineView> getOnelineList(Integer memberId, String query, Integer pageOffset) {
		// TODO Auto-generated method stub
		return dao.getOnelineList(memberId, query, pageOffset);
	}
	
	
}
