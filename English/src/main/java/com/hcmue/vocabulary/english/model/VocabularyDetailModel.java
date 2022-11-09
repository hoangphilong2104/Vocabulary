package com.hcmue.vocabulary.english.model;

import com.hcmue.vocabulary.english.entity.VocabularyDetail;

public class VocabularyDetailModel {
	
	private int id_vocabulary_detail;
	private int id_vocabulary_type;
	private String mean;
	private String example;
	private Boolean status_vocabulary_detail;
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
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public Boolean getStatus_vocabulary_detail() {
		return status_vocabulary_detail;
	}
	public void setStatus_vocabulary_detail(Boolean status_vocabulary_detail) {
		this.status_vocabulary_detail = status_vocabulary_detail;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public VocabularyDetailModel(VocabularyDetail v) {
		this.id_vocabulary_detail = v.getId_vocabulary_detail();
		this.id_vocabulary_type = v.getId_vocabulary_type();
		this.mean = v.getMean();
		this.example = v.getExample();
		this.status_vocabulary_detail = v.getStatus_vocabulary_detail();
	}
	public VocabularyDetailModel() {
		this.status_vocabulary_detail = true;
	}
	
}
