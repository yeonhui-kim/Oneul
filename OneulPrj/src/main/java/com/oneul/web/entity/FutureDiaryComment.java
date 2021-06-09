package com.oneul.web.entity;

public class FutureDiaryComment {
	private Integer id;
	private String regDate;
	private String content;
	private Integer memberId;
	private Integer freeDiaryId;
	private Integer commentId;
	
	public FutureDiaryComment() {
		// TODO Auto-generated constructor stub
	}

	public FutureDiaryComment(Integer id, String regDate, String content, Integer memberId, Integer freeDiaryId,
			Integer commentId) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.memberId = memberId;
		this.freeDiaryId = freeDiaryId;
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

	public Integer getfreeDiaryId() {
		return freeDiaryId;
	}

	public void setfreeDiaryId(Integer freeDiaryId) {
		this.freeDiaryId = freeDiaryId;
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
				+ memberId + ", freeDiaryId=" + freeDiaryId + ", commentId=" + commentId + "]";
	}
	
	
}
