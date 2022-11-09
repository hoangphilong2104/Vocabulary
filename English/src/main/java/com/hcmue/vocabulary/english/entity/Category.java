package com.hcmue.vocabulary.english.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.vocabulary.english.model.CategoryModel;
@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_category;
	@Column(name = "name_category")
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
	public Category(CategoryModel c) {
		this.id_category = c.getId_category();
		this.name_category = c.getName_category();
		this.date_create = c.getDate_create();
		this.status_category = c.getStatus_category();
	}
	
	public Category() {
		this.status_category = true;
	}
}
