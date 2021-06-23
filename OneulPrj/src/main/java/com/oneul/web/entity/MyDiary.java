package com.oneul.web.entity;

import java.util.Date;

public class MyDiary {
	private int id ;
	private String content;
	private Date regDate;
	private String diary;
	
	public MyDiary() {
		// TODO Auto-generated constructor stub
	}

	public MyDiary(int id, String content, Date regDate, String diary) {
		super();
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.diary = diary;
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

	public String getDiary() {
		return diary;
	}

	public void setDiary(String diary) {
		this.diary = diary;
	}

	@Override
	public String toString() {
		return "MyDiary [id=" + id + ", content=" + content + ", diary=" + diary + "]";
	}
	
	
}
