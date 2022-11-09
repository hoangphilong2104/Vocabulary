package com.hcmue.vocabulary.english.model;

import com.hcmue.vocabulary.english.entity.VocabularyType;

public class VocabularyTypeModel {
	
	private int id_vocabulary_type;
	private int id_vocabulary;
	private String type;
	private Boolean status_vocabulary_type;
	public int getId_vocabulary_type() {
		return id_vocabulary_type;
	}
	public void setId_vocabulary_type(int id_vocabulary_type) {
		this.id_vocabulary_type = id_vocabulary_type;
	}
	public int getId_vocabulary() {
		return id_vocabulary;
	}
	public void setId_vocabulary(int id_vocabulary) {
		this.id_vocabulary = id_vocabulary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getStatus_vocabulary_type() {
		return status_vocabulary_type;
	}
	public void setStatus_vocabulary_type(Boolean status_vocabulary_type) {
		this.status_vocabulary_type = status_vocabulary_type;
	}
	public VocabularyTypeModel(VocabularyType m) {
		this.id_vocabulary_type = m.getId_vocabulary_type();
		this.id_vocabulary = m.getId_vocabulary();
		this.type = m.getType();
		this.status_vocabulary_type = m.getStatus_vocabulary_type();
	}
	public VocabularyTypeModel() {
		this.status_vocabulary_type = true;
	}
	
}
