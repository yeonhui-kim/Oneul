package com.oneul.web.entity;

import java.util.Date;

public class FreeDiary {
	
	private Integer id;
	private String content;
	private String image;
	private Boolean pub;
	private Date regDate;
	private Integer memberId;
	private Integer emotionId;
	private Integer count;
	
	public FreeDiary() {
		// TODO Auto-generated constructor stub
	}
	
	

	public FreeDiary(Integer id, String content, String image, Boolean pub, Date regDate, Integer memberId,
			Integer emotionId, Integer count) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.pub = pub;
		this.regDate = regDate;
		this.memberId = memberId;
		this.emotionId = emotionId;
		this.count = count;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	public Boolean getPub() {
		return pub;
	}

	public void setPub(Boolean pub) {
		this.pub = pub;
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

	public Integer getEmotionId() {
		return emotionId;
	}

	public void setEmotionId(Integer emotionId) {
		this.emotionId = emotionId;
	}
	
	

	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}
	

	@Override
	public String toString() {
		return "FreeDiary [id=" + id + ", content=" + content + ", image=" + image + ", pub=" + pub + ", regDate="
				+ regDate + ", memberId=" + memberId + ", emotionId=" + emotionId + ", count=" + count + "]";
	}
	
	

}
