package com.hcmue.vocabulary.english.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.vocabulary.english.model.TypeOfWordsModel;

@Entity
@Table(name = "type_of_words")
public class TypeOfWords {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_type_of_words;
	@Column(name = "type_of_words")
	private String type_of_words;
	@Column(name = "status_type_of_words")
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
	
	public TypeOfWords(TypeOfWordsModel m) {
		this.id_type_of_words = m.getId_type_of_words();
		this.type_of_words = m.getType_of_words();
		this.status_type_of_words = m.getStatus_type_of_words();
	}
	public TypeOfWords() {
		this.status_type_of_words = true;
	}
}
