package com.oneul.web.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GratitudeDiary {
	private Integer id;
	private String content1;
	private String content2;
	private String content3;
	private String image;
	private boolean pub;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private Integer memberId;
	private Integer emotionId;
	
	public GratitudeDiary() {
		
	}
	
	public GratitudeDiary(Integer id, String content1, String content2, String content3, String image, boolean pub,
			Date regDate, Integer memberId, Integer emotionId) {
		super();
		this.id = id;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
		this.image = image;
		this.pub = pub;
		this.regDate = regDate;
		this.memberId = memberId;
		this.emotionId = emotionId;
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

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public boolean getPub() {
		return pub;
	}
	
	public void setPub(boolean pub) {
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
		return "GratitudeDiary [id=" + id + ", content1=" + content1 + ", content2=" + content2 + ", content3="
				+ content3 + ", image=" + image + ", pub=" + pub + ", regDate=" + regDate + ", memberId=" + memberId
				+ ", emotionId=" + emotionId + "]";
	}

	

	
}
