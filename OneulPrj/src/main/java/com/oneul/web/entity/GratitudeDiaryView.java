package com.oneul.web.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GratitudeDiaryView {
	private Integer id;
	private boolean pub;
	private Integer memberId;
	private Integer emotionId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private String content1;
	private String content2;
	private String content3;
	private String userId;
	private Integer commentCount;
	
	public GratitudeDiaryView() {
		// TODO Auto-generated constructor stub
	}

	public GratitudeDiaryView(Integer id, boolean pub, Integer memberId, Integer emotionId, Date regDate,
			String content1, String content2, String content3, String userId, Integer commentCount) {
		super();
		this.id = id;
		this.pub = pub;
		this.memberId = memberId;
		this.emotionId = emotionId;
		this.regDate = regDate;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
		this.userId = userId;
		this.commentCount = commentCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "GratitudeDiaryView [id=" + id + ", pub=" + pub + ", memberId=" + memberId + ", emotionId=" + emotionId
				+ ", regDate=" + regDate + ", content1=" + content1 + ", content2=" + content2 + ", content3="
				+ content3 + ", userId=" + userId + ", commentCount=" + commentCount + "]";
	}
	
	
	
}
