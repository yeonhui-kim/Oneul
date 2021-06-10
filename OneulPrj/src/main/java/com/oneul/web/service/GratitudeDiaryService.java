package com.oneul.web.service;

import java.util.List;
import com.oneul.web.entity.GratitudeDiary;
//업무적인 내용 // 이름을 보는 순간 그 업무의 내용이 느껴질 수 있도록
public interface GratitudeDiaryService {
	
	GratitudeDiary get(int id);
	List<GratitudeDiary> getList();
	List<GratitudeDiary> getList(int page);
	
	int insert(GratitudeDiary gratitudeDiary);
	int update(GratitudeDiary gratitudeDiary);
	int delete(int id);
}
