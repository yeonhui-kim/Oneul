package com.oneul.web.entity;

import java.sql.Date;

public class Member {
	private Integer id;
	private String userId;
	private String password;
	private String name;
	private String email;
	private Date birthday;
	private String image;
	private String introduction;
	
	public Member(Integer id, String userId, String password, String name, String email, Date birthday, String image,
			String introduction) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.image = image;
		this.introduction = introduction;
	}
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + ", email="
				+ email + ", birthday=" + birthday + ", image=" + image + ", introduction=" + introduction + "]";
	}
	
	
}