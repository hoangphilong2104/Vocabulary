package com.hcmue.vocabulary.english.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.vocabulary.english.model.VocabularyModel;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vocabulary;
	private int id_category;
	@Column(name = "spelling")
	private String spelling;
	@Column(name = "sound")
	private String sound;
	@Column(name = "status_vocabulary")
	private Boolean status_vocabulary;
	public int getId_vocabulary() {
		return id_vocabulary;
	}
	public String getSpelling() {
		return spelling;
	}
	public String getSound() {
		return sound;
	}
	public Boolean getStatus_vocabulary() {
		return status_vocabulary;
	}
	
	public int getId_category() {
		return id_category;
	}
	public Vocabulary(VocabularyModel v) {
		this.id_category = v.getId_category();
		this.id_vocabulary = v.getId_vocabulary();
		this.spelling = v.getSpelling();
		this.sound = v.getSound();
		this.status_vocabulary = v.getStatus_vocabulary();
	}
	public Vocabulary() {
		this.status_vocabulary = true;
	}
	
}
