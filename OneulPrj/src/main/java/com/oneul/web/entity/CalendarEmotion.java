package com.oneul.web.entity;

import java.util.Date;
//import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CalendarEmotion {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private Integer memberId;
	private Integer emotionId;
	
	
	public CalendarEmotion(Integer id, Date regDate, Integer memberId, Integer emotionId) {
		super();
		this.regDate = regDate;
		this.memberId = memberId;
		this.emotionId = emotionId;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
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
