package com.oneul.web.entity;

import java.util.Date;
//import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CalendarEmotion {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prevRegDate;
	private Integer memberId;
	private String content;
	private String image;
	private String diary;
	private Integer emotionId;
	private Integer diaryId;
	
	public Date getPrevRegDate() {
		return prevRegDate;
	}

	public void setPrevRegDate(Date prevRegDate) {
		this.prevRegDate = prevRegDate;
	}
	
	public Integer getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(Integer diaryId) {
		this.diaryId = diaryId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDiary() {
		return diary;
	}

	public void setDiary(String diary) {
		this.diary = diary;
	}

	public CalendarEmotion() {
	}
	
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
