package com.oneul.web.entity;

import java.util.Date;

public class MyComment {
	private int id;
	private String content;
	private Date regDate;
	private String comment;
	
	public MyComment() {
		// TODO Auto-generated constructor stub
	}

	public MyComment(int id, String content, Date regDate, String comment) {
		super();
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "MyComment [id=" + id + ", content=" + content + ", comment=" + comment + "]";
	}
	
	
	
}
