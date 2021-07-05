package com.oneul.web.entity;

import java.util.Date;

public class MyOneline {
	
	private Integer id;
	private String writerId;
	private String content;
	private Date regDate;
	private Integer memberId;
	private String image;
	private Integer count;
	
	public MyOneline() {
		// TODO Auto-generated constructor stub
	}

	public MyOneline(Integer id, String writerId, String content, Date regDate, Integer memberId, String image,
			Integer count) {
		super();
		this.id = id;
		this.writerId = writerId;
		this.content = content;
		this.regDate = regDate;
		this.memberId = memberId;
		this.image = image;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
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

	@Override
	public String toString() {
		return "MyOneline [id=" + id + ", writerId=" + writerId + ", content=" + content + ", regDate=" + regDate
				+ ", memberId=" + memberId + ", image=" + image + ", count=" + count + "]";
	}
	
	
}

