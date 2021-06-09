package com.oneul.web.entity;

public class FreeDiaryComment {
	private Integer id;
	private String regDate;
	private String content;
	private Integer memberId;
	private Integer futureDiaryId;
	private Integer commentId;
	
	public FreeDiaryComment() {
		// TODO Auto-generated constructor stub
	}

	public FreeDiaryComment(Integer id, String regDate, String content, Integer memberId, Integer futureDiaryId,
			Integer commentId) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.memberId = memberId;
		this.futureDiaryId = futureDiaryId;
		this.commentId = commentId;
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

	@Override
	public String toString() {
		return "FutureDiaryComment [id=" + id + ", regDate=" + regDate + ", content=" + content + ", memberId="
				+ memberId + ", futureDiaryId=" + futureDiaryId + ", commentId=" + commentId + "]";
	}
	
	
}
