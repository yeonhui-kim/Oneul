package com.oneul.web.entity;

import java.sql.Date;

public class GratitudeDiary {
	
	private Integer id;
	private String content;
	private String image;
	private Boolean pub;
	private Date regDate;
	private Integer memberId;
	private Integer emotionId;
	
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
	
	@Override
	public String toString() {
		return "GratitudeDiary [id=" + id + ", content=" + content + ", image=" + image + ", pub=" + pub + ", regDate="
				+ regDate + ", memberId=" + memberId + ", emotionId=" + emotionId + "]";
	}
	
	
	
}
