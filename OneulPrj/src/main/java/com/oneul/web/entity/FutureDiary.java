package com.oneul.web.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FutureDiary {
	private Integer id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bookingDate;
	private String content;
	private Boolean pub;
	private String image;
	private Date regDate;
	private Integer memberId;
	private Integer emotionId;
	
	public FutureDiary() {
		// TODO Auto-generated constructor stub
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

	public Boolean getPub() {
		return pub;
	}

	public void setPub(Boolean pub) {
		this.pub = pub;
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
		return "FutureDiary [id=" + id + ", bookingDate=" + bookingDate + ", content=" + content + ", pub=" + pub
				+ ", image=" + image + ", regDate=" + regDate + ", memberId=" + memberId + ", emotionId=" + emotionId
				+ "]";
	}
	
}
