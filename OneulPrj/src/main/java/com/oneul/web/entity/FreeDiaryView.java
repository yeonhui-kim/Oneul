package com.oneul.web.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FreeDiaryView {
	private Integer id;
	private String content;
	private String image;
	private Boolean pub;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private Integer memberId;
	private Integer emotionId;
	private String userId;
	private Integer commentCount;
	
	public FreeDiaryView() {
		// TODO Auto-generated constructor stub
	}

	public FreeDiaryView(Integer id, String content, String image, Boolean pub, Date regDate, Integer memberId,
			Integer emotionId, String userId, Integer commentCount) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.pub = pub;
		this.regDate = regDate;
		this.memberId = memberId;
		this.emotionId = emotionId;
		this.userId = userId;
		this.commentCount = commentCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getPub() {
		return pub;
	}

	public void setPub(Boolean pub) {
		this.pub = pub;
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

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "FreeDiaryView [id=" + id + ", content=" + content + ", image=" + image + ", pub=" + pub + ", regDate="
				+ regDate + ", memberId=" + memberId + ", emotionId=" + emotionId + ", userId=" + userId
				+ ", commentCount=" + commentCount + "]";
	}
	
	
	
	
}
