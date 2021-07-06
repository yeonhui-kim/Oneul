package com.oneul.web.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OnelineView {
	private Integer id;
	private String content;
	private Integer memberId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private String writerId;
	private String image;
	private Integer commentCount;
	
	public OnelineView() {
		// TODO Auto-generated constructor stub
	}

	public OnelineView(Integer id, String content, Integer memberId, Date regDate, String writerId, String image,
			Integer commentCount) {
		super();
		this.id = id;
		this.content = content;
		this.memberId = memberId;
		this.regDate = regDate;
		this.writerId = writerId;
		this.image = image;
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

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "OnelineView [id=" + id + ", content=" + content + ", memberId=" + memberId + ", regDate=" + regDate
				+ ", writerId=" + writerId + ", image=" + image + ", commentCount=" + commentCount + "]";
	}

	
	
}
