package com.oneul.web.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FutureDiaryView {
	private Integer id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookingDate;
	private String content;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private Integer memberId;
	private Integer emotionId;
	private String image;
	private String userId;
	private Integer commentCount;
	
	public FutureDiaryView() {
		// TODO Auto-generated constructor stub
	}

	public FutureDiaryView(Integer id, Date bookingDate, String content, Date regDate, Integer memberId,
			Integer emotionId, String userId, String image, Integer commentCount) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.content = content;
		
		this.regDate = regDate;
		this.memberId = memberId;
		this.emotionId = emotionId;
		this.userId = userId;
		this.image = image;
		this.commentCount = commentCount;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "FutureDiaryView [id=" + id + ", bookingDate=" + bookingDate + ", content=" + content 
				+ ", regDate=" + regDate + ", memberId=" + memberId + ", emotionId=" + emotionId + ", userId=" + userId
				+ ", image=" + image + ", commentCount=" + commentCount + "]";
	}
	
	
	
	
}
