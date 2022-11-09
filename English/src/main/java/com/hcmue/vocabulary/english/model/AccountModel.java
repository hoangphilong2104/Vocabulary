package com.hcmue.vocabulary.english.model;

import java.util.Date;

import com.hcmue.vocabulary.english.entity.Account;

public class AccountModel {
	private int id;

	private String username;
	
	private String password;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private Date birthday;
	
	private String phone;
	
	private String token;
	
	private String avatar;
	
	private Boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFullName() {
		return firstname + " " + lastname;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public AccountModel(Account a) {
		this.id = a.getId();
		this.username = a.getUsername();
		this.password = a.getPassword();
		this.firstname = a.getFirstname();
		this.lastname = a.getLastname();
		this.email = a.getEmail();
		this.birthday = a.getBirthday();
		this.phone = a.getPhone();
		this.token = a.getToken();
		this.avatar = a.getAvatar();
		this.status = a.getStatus();
	}
	
	public AccountModel() {
		this.avatar = "account.png";
		this.status = true;
	}
}
