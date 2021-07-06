package com.oneul.web.entity;

import java.util.Date;

import javax.annotation.sql.DataSourceDefinition;

import org.springframework.format.annotation.DateTimeFormat;

public class FutureDiary {
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookingDate;
	private String content;
	
	private String image;	
	private Date regDate;
	private Integer memberId;
	private Integer emotionId;
	
	public FutureDiary() {
		// TODO Auto-generated constructor stub
	}
	
	public FutureDiary(Integer id, Date bookingDate, String content, String image, Date regDate,
			Integer memberId, Integer emotionId) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.content = content;
		
		this.image = image;
		this.regDate = regDate;
		this.memberId = memberId;
		this.emotionId = emotionId;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
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
		return "FutureDiary [id=" + id + ", bookingDate=" + bookingDate + ", content=" + content + ", image=" + image + ", regDate=" + regDate + ", memberId=" + memberId + ", emotionId=" + emotionId
				+ "]";
	}
	
}
