package com.oneul.web.entity;

import java.sql.Date;
import java.util.List;

public class OnelineComment {
	private Integer id;
	private Date regDate;
	private String content;
	private Integer memberId;
	private Integer onelineId;
	private Integer commentId;
	private String writerId;
	private String image;
	private List<OnelineComment> list;
	
	public OnelineComment() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public OnelineComment(Integer id, Date regDate, String content, Integer memberId, Integer onelineId,
			Integer commentId, List<OnelineComment> list) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.memberId = memberId;
		this.onelineId = onelineId;
		this.commentId = commentId;
		this.list = list;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
	public Integer getOnelineId() {
		return onelineId;
	}
	public void setOnelineId(Integer onelineId) {
		this.onelineId = onelineId;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public List<OnelineComment> getList() {
		return list;
	}
	public void setList(List<OnelineComment> list) {
		this.list = list;
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

	@Override
	public String toString() {
		return "OnelineComment [id=" + id + ", regDate=" + regDate + ", content=" + content + ", memberId=" + memberId
				+ ", onelineId=" + onelineId + ", commentId=" + commentId + ", list=" + list + "]";
	}
	
	
	
}
