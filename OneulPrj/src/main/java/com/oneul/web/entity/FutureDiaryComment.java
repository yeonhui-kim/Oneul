package com.oneul.web.entity;

import java.util.List;

public class FutureDiaryComment {
	private Integer id;
	private String regDate;
	private String content;
	private Integer memberId;
	private Integer futureDiaryId;
	private Integer commentId;
	private String userId;
	private String image;
	private List<FutureDiaryComment> list;
	
	public FutureDiaryComment() {
		// TODO Auto-generated constructor stub
	}

	public FutureDiaryComment(Integer id, String regDate, String content, Integer memberId, Integer futureDiaryId,
			Integer commentId, String userId, String image, List<FutureDiaryComment> list) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.memberId = memberId;
		this.futureDiaryId = futureDiaryId;
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

	public Integer getFutureDiaryId() {
		return futureDiaryId;
	}

	public void setFutureDiaryId(Integer futureDiaryId) {
		this.futureDiaryId = futureDiaryId;
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

	public List<FutureDiaryComment> getList() {
		return list;
	}

	public void setList(List<FutureDiaryComment> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "FutureDiaryComment [id=" + id + ", regDate=" + regDate + ", content=" + content + ", memberId="
				+ memberId + ", futureDiaryId=" + futureDiaryId + ", commentId=" + commentId + ", userId=" + userId
				+ ", image=" + image + ", list=" + list + "]";
	}
	
	
	
}
