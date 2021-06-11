package com.oneul.web.entity;

import java.util.List;

public class FreeDiaryComment {
	private Integer id;
	private String regDate;
	private String content;
	private Integer memberId;
	private Integer freeDiaryId;
	private Integer commentId;
	private List<FreeDiaryComment> list;
	
	
	
	public FreeDiaryComment() {
		// TODO Auto-generated constructor stub
	}



	public FreeDiaryComment(Integer id, String regDate, String content, Integer memberId, Integer freeDiaryId,
			Integer commentId, List<FreeDiaryComment> list) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.memberId = memberId;
		this.freeDiaryId = freeDiaryId;
		this.commentId = commentId;
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



	public Integer getFreeDiaryId() {
		return freeDiaryId;
	}



	public void setFreeDiaryId(Integer freeDiaryId) {
		this.freeDiaryId = freeDiaryId;
	}



	public Integer getCommentId() {
		return commentId;
	}



	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}



	public List<FreeDiaryComment> getList() {
		return list;
	}



	public void setList(List<FreeDiaryComment> list) {
		this.list = list;
	}



	@Override
	public String toString() {
		return "FreeDiaryComment [id=" + id + ", regDate=" + regDate + ", content=" + content + ", memberId=" + memberId
				+ ", freeDiaryId=" + freeDiaryId + ", commentId=" + commentId + ", list=" + list + "]";
	}
	
	
	
	
	
	
	
}
