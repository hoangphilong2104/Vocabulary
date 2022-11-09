package com.hcmue.vocabulary.english.model;

import com.hcmue.vocabulary.english.entity.Vocabulary;

public class VocabularyModel {
	
	private int id_vocabulary;
	private int id_category;
	private String spelling;
	private String sound;
	private Boolean status_vocabulary;
	public int getId_vocabulary() {
		return id_vocabulary;
	}
	public void setId_vocabulary(int id_vocabulary) {
		this.id_vocabulary = id_vocabulary;
	}
	public String getSpelling() {
		return spelling;
	}
	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public Boolean getStatus_vocabulary() {
		return status_vocabulary;
	}
	public void setStatus_vocabulary(Boolean status_vocabulary) {
		this.status_vocabulary = status_vocabulary;
	}
	
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public VocabularyModel(Vocabulary v) {
		this.id_category = v.getId_category();
		this.id_vocabulary = v.getId_vocabulary();
		this.spelling = v.getSpelling();
		this.sound = v.getSound();
		this.status_vocabulary = v.getStatus_vocabulary();
	}
	public VocabularyModel() {
		this.status_vocabulary = true;
	}
}
