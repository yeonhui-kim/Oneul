package com.oneul.web.entity;

import java.sql.Date;

public class PublicDiary {
	private Integer id;
	private String content;
	private Integer memberId;
	private Date regDate;
	private String writerId;
	private String image;
	private Integer count;
	private String diary;
	
	
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
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String getDiary() {
		return diary;
	}
	public void setDiary(String diary) {
		this.diary = diary;
	}
	@Override
	public String toString() {
		return "Oneline24 [id=" + id + ", content=" + content + ", memberId=" + memberId + ", regDate=" + regDate + "]";
	}
	
	
	
	
}

