package com.oneul.web.dao;

import java.util.List;

import com.oneul.web.entity.FutureDiary;

public interface FutureDiaryDao {
//Notice get(int id);//하나만줘
	FutureDiary get(int id);
	//@Select("select * from Notice") mybatis는 오버로드 지원하지 않음
	//List<Notice> getList();//여러개줘. 필터링,정렬,페이징,집계 등 인자들
	List<FutureDiary> getList();
	List<FutureDiary> getList(int offset, int size);

	int insert(FutureDiary futureDiary);
	int update(FutureDiary futureDiary);
	int delete(int id);
	List<FutureDiary> getListAll();
	List<FutureDiary> getListToday();
	
	
}
