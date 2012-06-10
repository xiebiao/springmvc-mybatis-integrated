package com.xiebiao.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.xiebiao.mybatis.domain.BaseDomain;

@Entity
public class User extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private int age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
