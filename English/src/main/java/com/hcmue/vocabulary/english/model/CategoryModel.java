package com.hcmue.vocabulary.english.model;

import java.util.Date;

import javax.persistence.Column;

import com.hcmue.vocabulary.english.entity.Category;

public class CategoryModel {
	private int id_category;
	private String name_category;
	@Column(name = "date_create")
	private Date date_create;
	@Column(name = "status_category")
	private Boolean status_category;
	public int getId_category() {
		return id_category;
	}
	public String getName_category() {
		return name_category;
	}
	public Date getDate_create() {
		return date_create;
	}
	public Boolean getStatus_category() {
		return status_category;
	}
	
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public void setName_category(String name_category) {
		this.name_category = name_category;
	}
	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}
	public void setStatus_category(Boolean status_category) {
		this.status_category = status_category;
	}
	public CategoryModel(Category c) {
		this.id_category = c.getId_category();
		this.name_category = c.getName_category();
		this.date_create = c.getDate_create();
		this.status_category = c.getStatus_category();
	}
	
	public CategoryModel() {
		this.status_category = true;
	}
}
