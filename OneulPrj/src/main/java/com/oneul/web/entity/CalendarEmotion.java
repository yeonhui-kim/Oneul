package com.oneul.web.entity;

import java.sql.Date;

public class CalendarEmotion {
	
	private String regDate;
	private Integer memberId;
	private Integer emotionId;
	
	
	public CalendarEmotion(Integer id, String regDate, Integer memberId, Integer emotionId) {
		super();
		this.regDate = regDate;
		this.memberId = memberId;
		this.emotionId = emotionId;
	}
	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getEmotionId() {
		return emotionId;
	}
	public void setEmotionId(Integer emotionId) {
		this.emotionId = emotionId;
	}

	@Override
	public String toString() {
		return "CalendarEmotion [regDate=" + regDate + ", memberId=" + memberId + ", emotionId=" + emotionId + "]";
	}
	
	
	
	
}
