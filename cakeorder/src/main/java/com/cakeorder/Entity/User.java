package com.cakeorder.Entity;



import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
@Table
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String 	userMail;
	private String userName;
	private String password;
	@Column(length = 10)
	private String 	userPhonenumber;
	
	public String getUserPhonenumber() {
		return userPhonenumber;
	}
	public void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(long userId, String userMail, String userName, String password, String userPhonenumber) {
		super();
		this.userId = userId;
		this.userMail = userMail;
		this.userName = userName;
		this.password = password;
		this.userPhonenumber = userPhonenumber;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
