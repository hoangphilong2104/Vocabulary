package com.hcmue.vocabulary.english.model;

import com.hcmue.vocabulary.english.entity.TypeOfWords;

public class TypeOfWordsModel {
	
	private int id_type_of_words;
	private String type_of_words;
	private Boolean status_type_of_words;
	
	public int getId_type_of_words() {
		return id_type_of_words;
	}
	public String getType_of_words() {
		return type_of_words;
	}
	public Boolean getStatus_type_of_words() {
		return status_type_of_words;
	}
	public void setId_type_of_words(int id_type_of_words) {
		this.id_type_of_words = id_type_of_words;
	}
	public void setType_of_words(String type_of_words) {
		this.type_of_words = type_of_words;
	}
	public void setStatus_type_of_words(Boolean status_type_of_words) {
		this.status_type_of_words = status_type_of_words;
	}
	public TypeOfWordsModel(TypeOfWords m) {
		this.id_type_of_words = m.getId_type_of_words();
		this.type_of_words = m.getType_of_words();
		this.status_type_of_words = m.getStatus_type_of_words();
	}
	public TypeOfWordsModel() {
		this.status_type_of_words = true;
	}
}
