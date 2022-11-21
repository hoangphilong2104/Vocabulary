package com.hcmue.vocabulary.english.model;

public class ItemDetailModel {
	private int id_vocabulary_detail;
	private int id_vocabulary_type;
	private String type_detail;
	private String mean;
	private String example_detail;
	public int getId_vocabulary_detail() {
		return id_vocabulary_detail;
	}
	public void setId_vocabulary_detail(int id_vocabulary_detail) {
		this.id_vocabulary_detail = id_vocabulary_detail;
	}
	public int getId_vocabulary_type() {
		return id_vocabulary_type;
	}
	public void setId_vocabulary_type(int id_vocabulary_type) {
		this.id_vocabulary_type = id_vocabulary_type;
	}
	public String getType_detail() {
		return type_detail;
	}
	public void setType_detail(String type_detail) {
		this.type_detail = type_detail;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public String getExample_detail() {
		return example_detail;
	}
	public void setExample_detail(String example_detail) {
		this.example_detail = example_detail;
	}
	
}
