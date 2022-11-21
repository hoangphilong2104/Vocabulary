package com.hcmue.vocabulary.english.model;

import com.hcmue.vocabulary.english.entity.VocabularyType;

public class VocabularyTypeModel {
	
	private int id_vocabulary_type;
	private int id_vocabulary;
	private int id_type_of_words;
	private String type;
	private String vocabulary;
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
	public int getId_type_of_words() {
		return id_type_of_words;
	}
	public void setId_type_of_words(int id_type_of_words) {
		this.id_type_of_words = id_type_of_words;
	}
	public String getVocabulary() {
		return vocabulary;
	}
	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}
	public VocabularyTypeModel(VocabularyType m) {
		this.id_vocabulary_type = m.getId_vocabulary_type();
		this.id_vocabulary = m.getId_vocabulary();
		this.id_type_of_words = m.getId_type_of_words();
		this.type = m.getType();
		this.status_vocabulary_type = m.getStatus_vocabulary_type();
	}
	public VocabularyTypeModel() {
		this.status_vocabulary_type = true;
	}
	
}
