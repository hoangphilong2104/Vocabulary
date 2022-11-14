package com.hcmue.vocabulary.english.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.vocabulary.english.model.AccountModel;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "status_account")
	private Boolean status;
	
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getPhone() {
		return phone;
	}
	public Boolean getStatus() {
		return status;
	}
	public String getToken() {
		return token;
	}
	public String getAvatar() {
		return avatar;
	}
	public Account(AccountModel a) {
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
	
	public Account() {
		this.avatar = "account.png";
		this.status = true;
		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		this.birthday = dateformat.format(date);
	}
	
}
