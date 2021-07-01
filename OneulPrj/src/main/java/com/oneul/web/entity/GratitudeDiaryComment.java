package com.oneul.web.entity;

import java.util.List;

public class GratitudeDiaryComment {
	private Integer id;
	private String regDate;
	private String content;
	private Integer memberId;
	private Integer gratitudeDiaryId;
	private Integer commentId;
	private String userId;
	private String image;
	private List<GratitudeDiaryComment> list;
	
	public GratitudeDiaryComment() {
		// TODO Auto-generated constructor stub
	}

	public GratitudeDiaryComment(Integer id, String regDate, String content, Integer memberId, Integer gratitudeDiaryId,
			Integer commentId, String userId, String image, List<GratitudeDiaryComment> list) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.memberId = memberId;
		this.gratitudeDiaryId = gratitudeDiaryId;
		this.commentId = commentId;
		this.userId = userId;
		this.image = image;
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
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

	public Integer getGratitudeDiaryId() {
		return gratitudeDiaryId;
	}

	public void setGratitudeDiaryId(Integer gratitudeDiaryId) {
		this.gratitudeDiaryId = gratitudeDiaryId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<GratitudeDiaryComment> getList() {
		return list;
	}

	public void setList(List<GratitudeDiaryComment> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "GratitudeDiaryComment [id=" + id + ", regDate=" + regDate + ", content=" + content + ", memberId="
				+ memberId + ", gratitudeDiaryId=" + gratitudeDiaryId + ", commentId=" + commentId + ", userId="
				+ userId + ", image=" + image + ", list=" + list + "]";
	}
	
	
	
	
}
