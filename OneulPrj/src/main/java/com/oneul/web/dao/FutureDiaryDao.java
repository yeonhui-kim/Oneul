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
	//@Select("select * from Notice where ${field} like '%${query}%'")//#은 값으로 취급(홑따옴표붙음), $은 키로 취급
	//List<Notice> getList(int offset,int size, String field, String query);
	//List<Notice> getList(int offset,int size);
	//List<NoticeView> getViewList(int page, String field, String query);
	
	int insert(FutureDiary futureDiary);
	int update(FutureDiary futureDiary);
	int delete(int id);
	//int hitUp
	//int likeUp
	//int getCount(String field, String query);
	
}
